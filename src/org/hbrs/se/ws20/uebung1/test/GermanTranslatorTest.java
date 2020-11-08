package org.hbrs.se.ws20.uebung1.test;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    Translator t = new GermanTranslator();


    @org.junit.jupiter.api.Test
    void translateNumberTest() {
        assertEquals("zwei", t.translateNumber(2));
        assertEquals("Übersetzung der  Zahl " + "-1" +
                " nicht möglich(" + Translator.version + ")", t.translateNumber(-1));
        assertEquals("Übersetzung der  Zahl " + "16" +
                " nicht möglich(" + Translator.version + ")", t.translateNumber(16));
        assertEquals("Übersetzung der  Zahl " + "0" +
                " nicht möglich(" + Translator.version + ")", t.translateNumber(0));
    }

    /*
        Lösung mit Exception:
        assertThrows(IllegalArgumentException.class, () -> t.translateNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> t.translateNumber(16));
        assertThrows(IllegalArgumentException.class, () -> t.translateNumber(0));
    */

}