package org.hbrs.se.ws20.uebung4.control.container;

import org.hbrs.se.ws20.uebung4.control.Member;
import org.hbrs.se.ws20.uebung4.control.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung4.control.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Member> memberList = new ArrayList<>();

    private static Container INSTANCE = null;

    private PersistenceStrategy<Member> persistence = null;

    private Container() {}

    public static Container getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Container();
        }
        return INSTANCE;
    }

    public void setPersistence(PersistenceStrategy<Member> persistenceStrategy) {
        this.persistence = persistenceStrategy;
    }

    // Methode zum Hinzufügen von Member-Objekten zum Container
    public void addMember(Member member) throws ContainerException {
        if(memberList.contains(member)) {
            throw new ContainerException("Das Member-Objekt mit der ID " +
                    member.getID() + " ist bereits vorhanden!");
        }
        memberList.add(member);
    }


    // Methode zum Löschen von Member-Objekten des Containers
    public String deleteMember(Integer id) {
        Member memberToRemove = null;
        for (Member member : memberList) {
            if(member.getID().equals(id)) {
                memberToRemove = member;
            }
        }
        memberList.remove(memberToRemove);
        return memberToRemove == null ? "Fehler: Objekt nicht gefunden." :
                "Objekt: " + memberToRemove.getID() + " gelöscht.";
    }

    public int size() {
        return memberList.size();
    }

    public Member get(int i) {
        return memberList.get(i);
    }

    public List<Member> getCurrentList() {
        return memberList;
    }

    public void store() throws PersistenceException {
        persistence.save(memberList);
    }

    public void load() throws PersistenceException {
        memberList = persistence.load();
    }


}
