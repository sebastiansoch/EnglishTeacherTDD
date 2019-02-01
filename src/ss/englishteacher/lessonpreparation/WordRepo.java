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
interface WordRepo {

    public List<Word> getWordsForLesson(int nbOfWordPerLesson);
    
}
