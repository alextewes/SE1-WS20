package org.hbrs.se.ws20.uebung4.model.persistence;


import org.hbrs.se.ws20.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws20.uebung4.model.entity.UserStory;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream implements PersistenceStrategy<UserStory> {

    private String LOCATION = "userStories.ser";

    private ObjectOutputStream oos = null;
    private FileOutputStream fos = null;

    private FileInputStream fis = null;
    private ObjectInputStream ois = null;


    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    @Override
    public void openConnection() throws PersistenceException {
        try {
            fos = new FileOutputStream(LOCATION);
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        try {
            // Closing the outputstreams for storing
            if (oos != null) oos.close();
            if (fos != null) fos.close();

            // Closing the inputstreams for loading
            if (ois != null) ois.close();
            if (fis != null) fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<UserStory> list) throws PersistenceException {
        this.openConnection();

        try {
            System.out.println(  list.size() + " User Stories wurden erfolgreich gespeichert!");
            oos.writeObject( list );
        } catch (IOException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "Fehler beim Laden");
        } finally {
            this.closeConnection();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<UserStory> load() throws PersistenceException {

        List<UserStory> list =  null;

        try {
            fis = new FileInputStream( LOCATION );
            ois = new ObjectInputStream( fis );

            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List) obj;
            }
            System.out.println("LOG: Es wurden " + list.size() + " User Stories erfolgreich reingeladen!");
            return list;
        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "Fehler beim Laden");
        } finally {
            this.closeConnection();
        }
    }
}
