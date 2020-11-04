package org.hbrs.se.ws20.uebung1.test;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GermanTranslatorTest {

    @org.junit.jupiter.api.Test
    void translateNumberTest() {
        Translator t = new GermanTranslator();
        assertEquals("zwei", t.translateNumber(2));
    }

}