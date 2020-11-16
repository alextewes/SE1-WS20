package org.hbrs.se.ws20.uebung2;

public class MemberImpl implements Member {

    private final int ID;
    private static int memberCount;

    public MemberImpl() {
        this.ID = ++memberCount;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    public String toString() {
        return "Member (ID = " + this.getID() + ")";
    }

}
