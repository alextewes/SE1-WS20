package org.hbrs.se.ws20.uebung3.view;

import org.hbrs.se.ws20.uebung3.control.*;

import java.util.List;

public class Client {


    public static void main(String[] args) {
        Container container = Container.getInstance();
        MemberView memberView = new MemberView();
        Member m1 = new MemberImpl();
        Member m2 = new MemberImpl();
        Member m3 = new MemberImpl();
        try {
            container.addMember(m1);
            container.addMember(m2);
            container.addMember(m3);
        } catch (ContainerException e) {
            e.getStackTrace();
        }
        memberView.dump(container.getCurrentList());
    }

}
