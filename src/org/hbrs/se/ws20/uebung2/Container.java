package org.hbrs.se.ws20.uebung2;

import java.util.LinkedList;

public class Container {

    LinkedList<Member> memberLinkedList;

    public void addMember(Member member) throws ContainerException {

        boolean b = this.memberLinkedList.add(member);
        if(!b) {
            throw new ContainerException("Das Member-Objekt mit der ID " +
                                         member.getID() + " ist bereits vorhanden!");
        }

    }

    public int size() {
        return memberLinkedList.size();
    }

}
