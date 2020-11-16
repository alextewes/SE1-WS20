package org.hbrs.se.ws20.uebung2;


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

    @Test
    void addMember() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        container.addMember(m3);
        assertEquals(m1 ,container.get(0));
        assertEquals(m2 ,container.get(1));
        assertEquals(m3 ,container.get(2));
        assertThrows(ContainerException.class, () -> container.addMember(m1));
    }

    @Test
    void deleteMember() throws ContainerException {
        container.addMember(m1);
        container.deleteMember(1);
        container.addMember(m2);
        container.addMember(m3);
        assertEquals(m2, container.get(0));
        assertEquals(m3, container.get(1));
    }

    @Test
    void size() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(2, container.size());
    }

}