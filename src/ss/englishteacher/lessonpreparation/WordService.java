/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher.lessonpreparation;

import java.util.List;

/**
 *
 * @author ssoch
 */
class WordService {

    private int wordNb = -1;
    private List<Word> wordsToTranslate;

    WordService(List<Word> words) {
        this.wordsToTranslate = words;
    }

    Word getNextWordToTranslate() {
        return wordsToTranslate.get(++wordNb);
    }

    boolean checkTranslationCorrectness(String translation) {
        return wordsToTranslate.get(wordNb).getTranslation().equalsIgnoreCase(translation);
    }
    
}
