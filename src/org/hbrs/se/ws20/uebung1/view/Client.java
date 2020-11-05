package org.hbrs.se.ws20.uebung1.view;

import org.hbrs.se.ws20.uebung1.control.Factory;
import org.hbrs.se.ws20.uebung1.control.Translator;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber
		// mit dem übergegebenen Wert der Variable aNumber
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		Factory f = new Factory();
		Translator gt = f.createTranslator();
		System.out.println("Das Ergebnis der Berechnung: " +
				gt.translateNumber(aNumber) );

	}
}




