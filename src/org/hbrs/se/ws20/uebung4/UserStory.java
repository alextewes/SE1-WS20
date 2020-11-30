package org.hbrs.se.ws20.uebung4;

import java.io.Serializable;

public class UserStory implements Serializable {

    private final int ID = UserStoryCount;
    private static int UserStoryCount;
    private String beschreibung;
    private int mehrwert, strafe, aufwand, risiko;
    private double prio;


    public UserStory(String beschreibung, int mehrwert, int strafe, int aufwand, int risiko) {
        UserStoryCount++;
        this.beschreibung = beschreibung;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risiko = risiko;
        this.prio = (double)(mehrwert + strafe)/(aufwand + risiko);
    }





}
