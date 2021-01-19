package org.hbrs.se.ws20.uebung4.model.persistence;

import org.hbrs.se.ws20.uebung4.model.exception.PersistenceException;

import java.util.List;

public class PersistenceStrategyMongoDB<E> implements PersistenceStrategy<E> {
    @Override
    public void openConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<E> member) {
        throw new UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<E> load() {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
