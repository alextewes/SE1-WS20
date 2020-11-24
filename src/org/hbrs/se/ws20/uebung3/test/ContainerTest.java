package org.hbrs.se.ws20.uebung3.test;

import org.hbrs.se.ws20.uebung3.control.*;
import org.hbrs.se.ws20.uebung3.control.persistence.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Member m1;
    Member m2;
    Member m3;

    Container container;
    
    
    
    @BeforeEach
    void setup() {
        // Container und member erzeugen
        container = Container.getInstance();
        m1 = new MemberImpl(1);
        m2 = new MemberImpl(2);
        m3 = new MemberImpl(3);

    }

    @AfterEach
    void teardown() {
        // Container leeren
        for(int i = 1; i <= 3; i++) {
            container.deleteMember(i);
        }
    }
    
    void fillContainer() {
        // Container füllen
        try {
            container.addMember(m1);
            container.addMember(m2);
            container.addMember(m3);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }



    @Test
    void addMember() {
        // Testfall 1: leerer Container
        assertEquals(0, container.size());

        fillContainer();

        // Testfall 2: Member hinzugefügt
        assertEquals(3, container.size());

        container.deleteMember(m3.getID());

        //Testfall 3: Member gelöscht
        assertEquals(2, container.size());

        // Testfall 4: Member bereits vorhanden
        assertThrows(ContainerException.class, () -> container.addMember(m1));
        assertThrows(ContainerException.class, () -> container.addMember(m2));
        assertEquals(2, container.size());

    }

    @Test
    void getCurrentList() {
        List<Member> list = container.getCurrentList();

        //Testfall 5: Initiale Liste leer
        assertEquals(0, list.size());

        // Container füllen
        fillContainer();

        list = container.getCurrentList();

        // Testfall 6: volle Liste
        assertEquals(3, list.size());
    }

    @Test
    void store() {
        // Container füllen
        fillContainer();

        // Container speichern und laden
        try {
            container.store();
            container.load();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        // Testfall 7: Geladenen Container prüfen
        assertEquals(3, container.size());

    }

    @Test
    void persistenceMongoDB() {
        // PersistenceMongoDB Exception Test
        PersistenceStrategy<Container> persisitenceMongoDB = new PersistenceStrategyMongoDB<>();
        assertThrows(UnsupportedOperationException.class, persisitenceMongoDB::load);
        assertThrows(UnsupportedOperationException.class, () -> persisitenceMongoDB.save(new ArrayList<>()));
        assertThrows(UnsupportedOperationException.class, persisitenceMongoDB::openConnection);
        assertThrows(UnsupportedOperationException.class, persisitenceMongoDB::closeConnection);
    }

}