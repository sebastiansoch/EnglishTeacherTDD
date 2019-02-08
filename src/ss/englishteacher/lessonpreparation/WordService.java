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
public class WordService {

    private int wordNb = -1;
    private List<Word> wordsToTranslate;

    public WordService(List<Word> words) {
        this.wordsToTranslate = words;
    }

    public boolean isNextWord() {
        if (wordNb + 1 >= wordsToTranslate.size()) {
            return false;
        }
        
        return true;
    }

    public Word getNextWordToTranslate() {
        return wordsToTranslate.get(++wordNb);
    }

    public boolean checkTranslationCorrectness(Word answerWord) {
        return wordsToTranslate.get(wordNb).equals(answerWord);
    }

    public String giveCorrectAnswer(Word askedWord) {
        return askedWord.getTranslation();
    }

    
}
