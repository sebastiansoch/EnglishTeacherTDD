/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher;

import java.util.Scanner;
import ss.englishteacher.lessonpreparation.Lesson;
import ss.englishteacher.lessonpreparation.LessonCriteria;
import ss.englishteacher.lessonpreparation.Word;
import ss.englishteacher.lessonpreparation.WordRepo;
import ss.englishteacher.lessonpreparation.WordRepoTest;
import ss.englishteacher.lessonpreparation.WordService;
import ui.JWordFrame;

/**
 *
 * @author ssoch
 */
public class EnglishTeacher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WordRepo repo = new WordRepoTest();
        int nbOfWordPerLesson = 20;
        Lesson lesson = new Lesson(new LessonCriteria(nbOfWordPerLesson), repo);
        WordService wordService = new WordService(lesson.getLesson());

//        consoleApp(wordService);
        desctopApp(wordService);
    }

    private static void consoleApp(WordService wordService) {
        while (wordService.isNextWord()) {
            Word askedWord = wordService.getNextWordToTranslate();
            System.out.println("Przetłumacz słowo: " + askedWord.getTranslatedWord());
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().trim();
            if (wordService.checkTranslationCorrectness(new Word(askedWord.getTranslatedWord(), answer))) {
                System.out.println("Correct answer");
            } else {
                System.out.println("Wrong answer");
            }
            System.out.println("-----------------------------------");
        }
    }

    private static void desctopApp(WordService wordService) {
        DesktopController controller = new DesktopController(wordService);
        controller.run();
    }
    
}
