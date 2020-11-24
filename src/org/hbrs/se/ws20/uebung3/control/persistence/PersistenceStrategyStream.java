package org.hbrs.se.ws20.uebung3.control.persistence;


import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    List<Member> newListe =  null;

    @Override
    public void openConnection() throws PersistenceException {
        try {
            fis = new FileInputStream("sampleFile");
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        try {
            fis.close();
            fos.close();
            ois.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {
        try {
            openConnection();
            fos = new FileOutputStream("sampleFile");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(member);
            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        closeConnection();
        return null;
    }
}
