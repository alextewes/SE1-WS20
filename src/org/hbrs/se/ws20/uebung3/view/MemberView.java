package org.hbrs.se.ws20.uebung3.view;

import org.hbrs.se.ws20.uebung3.control.Member;
import org.hbrs.se.ws20.uebung3.control.Container;

import java.util.List;

public class MemberView {

    // Methode zur Ausgabe der Member des Containers auf Kommandozeile
    public void dump(List<Member> liste) {
        for(Member member : liste) {
            System.out.println(member.toString());
        }
    }

}
