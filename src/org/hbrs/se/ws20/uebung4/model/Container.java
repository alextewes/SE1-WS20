package org.hbrs.se.ws20.uebung4.model;

import org.hbrs.se.ws20.uebung4.model.exception.ContainerException;
import org.hbrs.se.ws20.uebung4.model.entity.UserStory;
import org.hbrs.se.ws20.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws20.uebung4.model.persistence.PersistenceStrategy;
import org.hbrs.se.ws20.uebung4.model.persistence.PersistenceStrategyStream;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<UserStory> list = new ArrayList<>();

    private static Container INSTANCE = null;

    private PersistenceStrategy<UserStory> persistence = new PersistenceStrategyStream();

    private Container() {}

    public static Container getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Container();
        }
        return INSTANCE;
    }

    public void setPersistence(PersistenceStrategy<UserStory> persistenceStrategy) {
        this.persistence = persistenceStrategy;
    }

    // Methode zum Hinzufügen von Member-Objekten zum Container
    public void addMember(UserStory userStory) throws ContainerException {
        if(list.contains(userStory)) {
            throw new ContainerException("Das Member-Objekt mit der ID " +
                    userStory.getID() + " ist bereits vorhanden!");
        }
        list.add(userStory);
    }


    // Methode zum Löschen von Member-Objekten des Containers
    public String deleteMember(Integer id) {
        UserStory toRemove = null;
        for (UserStory userStory : list) {
            if(userStory.getID().equals(id)) {
                toRemove = userStory;
            }
        }
        list.remove(toRemove);
        return toRemove == null ? "Fehler: Objekt nicht gefunden." :
                "Objekt: " + toRemove.getID() + " gelöscht.";
    }

    public int size() {
        return list.size();
    }

    public UserStory get(int i) {
        return list.get(i);
    }

    public List<UserStory> getCurrentList() {
        return list;
    }

    public void store() throws PersistenceException {
        if (this.persistence == null)
            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure,
                    "Strategy not initialized");

        this.openConnection();
        this.persistence.save( this.list  );
    }

    public void load() throws PersistenceException {
        if (this.persistence == null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,  "Strategy not initialized");

        List<UserStory> list = this.persistence.load();
        this.list = list;
    }

    public void loadMerge() throws PersistenceException {
        if (this.persistence == null)
            throw new PersistenceException( PersistenceException.ExceptionType.NoStrategyIsSet,  "Strategy not initialized");

        List<UserStory> newList = this.persistence.load();
        List<Integer> IDS = new ArrayList<>();
        for (UserStory u : this.list) {
            IDS.add(u.getID());
        }
        for (UserStory u : newList) {
            if(IDS.contains(u.getID())) {
                System.out.println("Duplikat mit der ID: " + u.getID());
            }
            else {
                this.list.add(u);
            }
        }


    }

    private void openConnection() throws PersistenceException {
        try {
            this.persistence.openConnection();
        } catch( java.lang.UnsupportedOperationException e ) {
            throw new PersistenceException( PersistenceException.ExceptionType.ImplementationNotAvailable , "Not implemented!" );
        }
    }


}
