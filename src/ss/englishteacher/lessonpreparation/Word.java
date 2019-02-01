/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.englishteacher.lessonpreparation;

import java.util.Objects;

/**
 *
 * @author ssoch
 */
class Word {

    private String translatedWord;
    private String translation;
    
    Word(String translatedWord, String translation) {
        this.translatedWord = translatedWord;
        this.translation = translation;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.translatedWord);
        hash = 73 * hash + Objects.hashCode(this.translation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.translatedWord, other.translatedWord)) {
            return false;
        }
        if (!Objects.equals(this.translation, other.translation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Word{" + "translatedWord=" + translatedWord + ", translation=" + translation + '}';
    }
}
