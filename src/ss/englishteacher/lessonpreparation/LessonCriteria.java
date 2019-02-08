/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher.lessonpreparation;

/**
 *
 * @author ssoch
 */
public class LessonCriteria {

    private int nbOfWordPerLesson;

    public LessonCriteria(int nbOfWordPerLesson) {
        this.nbOfWordPerLesson = nbOfWordPerLesson;
    }

    LessonCriteria(TranslationMode translationMode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNbOfWordPerLesson() {
        return nbOfWordPerLesson;
    }
    
    
}
