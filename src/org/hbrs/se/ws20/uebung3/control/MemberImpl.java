package org.hbrs.se.ws20.uebung3.control;

import java.io.Serializable;

public class MemberImpl implements Member, Serializable {

    private final int ID;

    public MemberImpl(int id) {
        this.ID = id;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    public String toString() {
        return "Member (ID = " + this.getID() + ")";
    }

}
