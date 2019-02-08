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

        List<Word> transaledWords = prepareListOfFiveWorlds();

        WordService wordService = new WordService(transaledWords);
        Word result = wordService.getNextWordToTranslate();
        assertEquals(transaledWords.get(0), result);

        result = wordService.getNextWordToTranslate();
        assertEquals(transaledWords.get(1), result);
    }

    @Test
    public void ShouldCheckTranslationCorrectnessTranslationTrue() {
        List<Word> words = prepareListOfFiveWorlds();
        WordService wordService = new WordService(words);
        Word askedWord = wordService.getNextWordToTranslate();
        Word answerWord = new Word(askedWord.getTranslatedWord(), words.get(0).getTranslation());

        boolean result = wordService.checkTranslationCorrectness(answerWord);
        assertTrue(result);
    }

    @Test
    public void ShouldCheckTranslationCorrectnessTranslationFalse() {
        List<Word> words = prepareListOfFiveWorlds();
        WordService wordService = new WordService(words);
        Word askedWord = wordService.getNextWordToTranslate();
        String translation = "błędne tłumaczenie";
        Word answerWord = new Word(askedWord.getTranslatedWord(), translation);

        boolean result = wordService.checkTranslationCorrectness(answerWord);
        assertFalse(result);
    }

    @Test
    public void ShouldCheckTranslationCorrectnessTranslationNull() {
        List<Word> words = prepareListOfFiveWorlds();
        WordService wordService = new WordService(words);
        Word askedWord = wordService.getNextWordToTranslate();
        String translation = null;
        Word answerWord = new Word(askedWord.getTranslatedWord(), translation);

        boolean result = wordService.checkTranslationCorrectness(answerWord);
        assertFalse(result);
    }

    @Test
    public void ShouldReturnListOfWordsMeetsQuantityCriteria() {
        int nbOfWordPerLesson = 2;
        when(repo.init()).thenReturn(prepareListOfTwoWorlds());
        LessonCriteria lessonCriteria = new LessonCriteria(nbOfWordPerLesson);
        Lesson lesson = new Lesson(lessonCriteria, repo);
        List<Word> actual = lesson.getLesson();

        assertEquals(prepareListOfTwoWorlds(), actual);
    }

    @Test
    public void ShouldReturnListOfWordsDoesntMeetTheQuantityCriteria() {
        int nbOfWordPerLesson = 15;
        when(repo.init()).thenReturn(prepareListOfFiveWorlds());
        LessonCriteria lessonCriteria = new LessonCriteria(nbOfWordPerLesson);
        Lesson lesson = new Lesson(lessonCriteria, repo);
        List<Word> actual = lesson.getLesson();
        List<Word> expected = prepareListOfFiveWorlds();

        assertNotEquals(nbOfWordPerLesson, actual.size());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void ShouldCheckThatNextWordExists() {
        List<Word> words = new ArrayList<>();
        WordService wordService = new WordService(words);
        boolean result = wordService.isNextWord();
        assertFalse(result);
    }

    @Test
    public void ShouldCheckThatNextWordDoesntExist() {
        List<Word> words = new ArrayList<>();
        words.add(new Word("house", "dom"));
        WordService wordService = new WordService(words);
        boolean result = wordService.isNextWord();
        assertTrue(result);
    }

    @Test
    public void ShouldReturnCorrectAnswerIfAnswerIsWrong() {
        List<Word> words = prepareListOfFiveWorlds();
        WordService wordService = new WordService(words);
        Word askedWord = wordService.getNextWordToTranslate();
        String correctAnswer = wordService.giveCorrectAnswer(askedWord);

        assertEquals(correctAnswer, askedWord.getTranslation());
    }

    @Test
    public void ShouldReturnEnglishToPolishTranslation() {
        when(repo.init()).thenReturn(prepareListOfTwoWorlds());
        LessonCriteria lessonCriteria = new LessonCriteria(TranslationMode.PL_EN);
        Lesson lesson = new Lesson(lessonCriteria, repo);
        List<Word> actual = lesson.getLesson();
        List<Word> expected = prepareListOfTwoWorlds();
        assertEquals(expected, actual);
    }

    private List<Word> prepareListOfTwoWorlds() {
        List<Word> words = new ArrayList<>();
        words.add(new Word("house", "dom"));
        words.add(new Word("wheel", "koło"));
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

}
