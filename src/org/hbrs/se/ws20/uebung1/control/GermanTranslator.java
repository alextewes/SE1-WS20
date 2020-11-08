package org.hbrs.se.ws20.uebung1.control;

import java.util.HashMap;

public class GermanTranslator implements Translator {

	public String date = "Okt/2020"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		HashMap<Integer, String> numbers = new HashMap<>(10);
		numbers.put(1, "eins");
		numbers.put(2, "zwei");
		numbers.put(3, "drei");
		numbers.put(4, "vier");
		numbers.put(5, "fuenf");
		numbers.put(6, "sechs");
		numbers.put(7, "sieben");
		numbers.put(8, "acht");
		numbers.put(9, "neun");
		numbers.put(10, "zehn");

		// Lösung nach Anforderung
		// Fehlernachricht als Rückgabewert der Methode
		if(number < 1 || number > 10) {
			return  "Übersetzung der  Zahl " + number +
					" nicht möglich(" + Translator.version + ")";
		}
		return numbers.get(number);

		/*
		Lösung mit Wurf einer Exception

		if (number < 1 || number > 10) {
			throw new IllegalArgumentException("Übersetzung der  Zahl " + number +
				 " nicht möglich(" + Translator.version + ")");
		}
		*/
	}





	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Nov/2020))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
