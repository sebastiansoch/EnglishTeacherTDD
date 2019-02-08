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
public class Lesson {

    private final LessonCriteria lessonCriteria;
    private final WordRepo wordRepo;
    
    public Lesson(LessonCriteria lessonCriteria, WordRepo wordRepo) {
        this.lessonCriteria = lessonCriteria;
        this.wordRepo = wordRepo;
    }

    
    public List<Word> getLesson() {
        return wordRepo.getWordsForLesson(lessonCriteria.getNbOfWordPerLesson());
    }
    
}
