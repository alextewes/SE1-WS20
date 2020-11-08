package org.hbrs.se.ws20.uebung1.test;


import org.hbrs.se.ws20.uebung1.view.Client;

public class ClientTest {

    Client client = new Client();

    void displayTest() {
        client.display(2);
        client.display(0);
        client.display(12);
        client.display(-12);
    }


}
