package org.hbrs.se.ws20.uebung2;

import java.util.ArrayList;

public class Container {

    private final ArrayList<Member> memberList;


    public Container() {
        memberList = new ArrayList<>();
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


    // Methode zur Ausgabe der Member des Containers auf Kommandozeile
    public void dump() {
        for(Member member : memberList) {
            System.out.println(member.toString());
        }
    }


    public int size() {
        return memberList.size();
    }


    public Member get(int i) {
        return memberList.get(i);
    }

}
