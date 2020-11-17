package org.hbrs.se.ws20.uebung2.test;


import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ContainerTest {

    Container container;
    Member m1;
    Member m2;
    Member m3;


    @BeforeEach
    void setup() {
        container = new Container();
        m1 = new MemberImpl();
        m2 = new MemberImpl();
        m3 = new MemberImpl();
    }

    @AfterEach
    void teardown() {
        container = null;
        m1 = null;
        m2 = null;
        m3 = null;
    }

    void fillContainer() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        container.addMember(m3);
    }

    @Test
    void addMember() throws ContainerException {
        assertEquals(0, container.size());
        fillContainer();
        assertEquals(3, container.size());
        assertThrows(ContainerException.class, () -> container.addMember(m1));
    }

    @Test
    void deleteMember() throws ContainerException {
        fillContainer();
        int m1ID = m1.getID();
        assertEquals("Objekt: " + m1ID + " gelöscht." ,container.deleteMember(m1ID));
        assertEquals("Fehler: Objekt nicht gefunden.", container.deleteMember(m1.getID()));
        assertEquals(2, container.size());
        container.deleteMember(m2.getID());
        container.deleteMember(m3.getID());
        assertEquals(0, container.size());
    }

    @Test
    void size() throws ContainerException {
        assertEquals(0, container.size());
        fillContainer();
        assertEquals(3, container.size());
    }

    @Test
    void dump() throws ContainerException {
        fillContainer();
        container.dump();
    }

}