package org.hbrs.se.ws20.uebung3.control.persistence;


import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    ObjectInputStream ois = null;
    FileInputStream fis = null;
    List<Member> newListe =  null;

    @Override
    public void openConnection() throws PersistenceException {
        try {
            fis = new FileInputStream(" a location to a file");
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        try {
            fis.close();
            ois.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {
        try (OutputStream output = new FileOutputStream(" a location to a file")) {

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Thanks! ;)
     */
    public List<Member> load() throws PersistenceException  {
        openConnection();
        try {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                newListe = (List) obj;
                return newListe;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
        closeConnection();
        return null;
    }
}
