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
enum TranslationMode {
    PL_EN("polish to english"),
    EN_PL("english to polish");
    
    private final String name;

    private TranslationMode(String name) {
        this.name = name;
    }
}
