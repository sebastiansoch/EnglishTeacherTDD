/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher.lessonpreparation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class WordRepoTest implements WordRepo {

    private List<Word> words ;
    
    @Override
    public List<Word> getWordsForLesson(int nbOfWordPerLesson) {
        if (words == null) {
            words = init();
        }

        List<Word> wordsForLesson = new ArrayList<>();
        
        if (nbOfWordPerLesson > words.size()) {
            nbOfWordPerLesson = words.size();
        }
        
        for (int i = 0; i < nbOfWordPerLesson; i++) {
            wordsForLesson.add(words.get(i));
        }
        return wordsForLesson;
        
    }

    List<Word> init() {
        List<Word> w = new ArrayList<>();
                
        w.add(new Word("house", "dom"));
        w.add(new Word("wheel", "koło"));
        w.add(new Word("rat", "szczur"));
        w.add(new Word("dog", "pies"));
        return w;
    }
}
