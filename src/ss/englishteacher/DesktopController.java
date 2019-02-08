/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher;

import java.awt.Color;
import ss.englishteacher.lessonpreparation.Word;
import ss.englishteacher.lessonpreparation.WordService;
import ui.JWordFrame;

/**
 *
 * @author ssoch
 */
public class DesktopController {

    private JWordFrame jWordFrame;
    private final WordService wordService;
    private Word askedWord;

    public DesktopController(WordService wordService) {
        this.wordService = wordService;
    }

    public void run() {
        jWordFrame = new JWordFrame(this);
        jWordFrame.setVisible(true);

        giveWordToTranslation();

    }

    public void onCheck() {
        String answer = jWordFrame.jTranslation_TextField.getText().trim();

        if (wordService.checkTranslationCorrectness(new Word(askedWord.getTranslatedWord(), answer))) {
            jWordFrame.jInfo_Label.setForeground(Color.GREEN);
            jWordFrame.jInfo_Label.setText("Correct answer");
        } else {
            jWordFrame.jInfo_Label.setForeground(Color.RED);
            jWordFrame.jInfo_Label.setText("Wrong answer. Correct answer is: " + wordService.giveCorrectAnswer(askedWord));
        }
    }

    public void onNext() {
        giveWordToTranslation();
    }

    private void giveWordToTranslation() {
        if (wordService.isNextWord()) {
            askedWord = wordService.getNextWordToTranslate();
            jWordFrame.jTranslatedWord_Label.setText(askedWord.getTranslatedWord());
        } else {
            jWordFrame.jInfo_Label.setForeground(Color.MAGENTA);
            jWordFrame.jInfo_Label.setText("No more words on this lesson");
        }
    }
}
