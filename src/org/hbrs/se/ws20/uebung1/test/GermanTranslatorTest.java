package org.hbrs.se.ws20.uebung1.test;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    Translator t = new GermanTranslator();


    @org.junit.jupiter.api.Test
    void translateNumberTest() {
        assertEquals("zwei", t.translateNumber(2));
        assertThrows(IllegalArgumentException.class, () -> t.translateNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> t.translateNumber(16));
        assertThrows(IllegalArgumentException.class, () -> t.translateNumber(0));

    }

}