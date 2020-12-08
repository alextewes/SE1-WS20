package org.hbrs.se.ws20.uebung4.model;

import java.io.Serializable;
import java.util.Comparator;

public class UserStory implements Serializable {


    private String beschreibung;
    private int ID, mehrwert, strafe, aufwand, risiko;
    private double prio;


    public UserStory(int ID, String beschreibung,  int mehrwert, int strafe, int aufwand, int risiko) {
        if(risiko < 0 || mehrwert < 1) {
            throw new IllegalArgumentException("Ungültige Eingabe!");
        }
        this.ID = ID;
        this.beschreibung = beschreibung;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risiko = risiko;
        this.prio = (double)Math.round(((double)(mehrwert + strafe)/(aufwand + risiko))*100)/100;
    }


    public Integer getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "User Story(ID=" + ID + "): Beschreibung: " + beschreibung + " Mehrwert: "
                + mehrwert + " Strafe: " + strafe + " Aufwand: " + aufwand + " Risiko: " + risiko + " Prio: " + prio;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public int getMehrwert() {
        return mehrwert;
    }

    public int getStrafe() {
        return strafe;
    }

    public int getAufwand() {
        return aufwand;
    }

    public int getRisiko() {
        return risiko;
    }

    public double getPrio() {
        return prio;
    }
}
