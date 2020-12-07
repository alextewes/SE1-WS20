package org.hbrs.se.ws20.uebung4.model;

import java.io.Serializable;

public class UserStory implements Serializable {

    private final int ID = UserStoryCount;
    private static int UserStoryCount;

    private String beschreibung;
    private int mehrwert, strafe, aufwand, risiko;
    private double prio;


    public UserStory(String beschreibung, int mehrwert, int strafe, int aufwand, int risiko) {
        if(risiko < 0 || mehrwert < 1) {
            throw new IllegalArgumentException("Ungültige Eingabe!");
        }
        UserStoryCount++;
        this.beschreibung = beschreibung;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risiko = risiko;
        this.prio = (double)(mehrwert + strafe)/(aufwand + risiko);
    }


    public Integer getID() {
        return ID;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
