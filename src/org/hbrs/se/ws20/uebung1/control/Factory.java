package org.hbrs.se.ws20.uebung1.control;

public class Factory {

    /**
     *  Factory-Methode zur Rückgabe eines GermanTranslator Objektes
     */
    public static Translator createTranslator() {
        return new GermanTranslator();
    }


}
