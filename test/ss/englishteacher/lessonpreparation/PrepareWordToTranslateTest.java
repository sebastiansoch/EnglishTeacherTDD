/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher.lessonpreparation;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Rule;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Stubber;

/**
 *
 * @author ssoch
 */
public class PrepareWordToTranslateTest {

    public PrepareWordToTranslateTest() {
    }

    @Spy
    WordRepoTest repo;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void ShouldReturnWordsToTranslate() {

        List<Word> transaledWords = prepareListOfWorlds();

        WordService wordService = new WordService(transaledWords);
        Word result = wordService.getNextWordToTranslate();
        assertEquals(transaledWords.get(0), result);

        result = wordService.getNextWordToTranslate();
        assertEquals(transaledWords.get(1), result);
    }

    @Test
    public void ShouldReturnWordsToTranslate2() {

        List<Word> transaledWords = prepareListOfWorlds2();

        WordService wordService = new WordService(transaledWords);
        Word result = wordService.getNextWordToTranslate();
        assertEquals(transaledWords.get(0), result);

        result = wordService.getNextWordToTranslate();
        assertEquals(transaledWords.get(1), result);
    }

    @Test
    public void ShouldCheckTranslationCorrectness() {
        List<Word> words = prepareListOfWorlds();
        WordService wordService = new WordService(words);
        String translation = wordService.getNextWordToTranslate().getTranslation();
        boolean result = wordService.checkTranslationCorrectness(translation);
        assertTrue(result);
    }

    @Test
    public void ShouldReturnListOfWordsMeetsTheCriteria() {
        int nbOfWordPerLesson = 2;
        when(repo.init()).thenReturn(prepareMeetsCriteriaRepo());
        LessonCriteria lessonCriteria = new LessonCriteria(nbOfWordPerLesson);
        Lesson lesson = new Lesson(lessonCriteria, repo);
        List<Word> actuals = lesson.getLesson();

        assertEquals(prepareListOfWorlds(), actuals);
    }

    @Ignore
    @Test
    public void ShouldReturnListOfWordsDoesntMeetTheQuantityCriteria() {
        int nbOfWordPerLesson = 5;
        LessonCriteria lessonCriteria = new LessonCriteria(nbOfWordPerLesson);
        Lesson lesson = new Lesson(lessonCriteria, null);
        List<Word> actuals = lesson.getLesson();

        assertNotEquals(prepareListOfFiveWorlds(), actuals);
    }

    private List<Word> prepareListOfWorlds() {
        List<Word> words = new ArrayList<>();
        words.add(new Word("house", "dom"));
        words.add(new Word("wheel", "koło"));
        return words;
    }

    private List<Word> prepareListOfWorlds2() {
        List<Word> words = new ArrayList<>();
        words.add(new Word("rat", "szczur"));
        words.add(new Word("dog", "pies"));
        return words;
    }

    private List<Word> prepareListOfFiveWorlds() {
        List<Word> words = new ArrayList<>();
        words.add(new Word("house", "dom"));
        words.add(new Word("wheel", "koło"));
        words.add(new Word("rat", "szczur"));
        words.add(new Word("dog", "pies"));
        words.add(new Word("quantity", "ilość"));
        return words;

    }

    private List<Word> prepareMeetsCriteriaRepo() {
        List<Word> words = new ArrayList<>();
        words.add(new Word("house", "dom"));
        words.add(new Word("wheel", "koło"));
        words.add(new Word("rat", "szczur"));
        words.add(new Word("dog", "pies"));
        return words;
    }
}
