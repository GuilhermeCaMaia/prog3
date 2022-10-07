package br.edu.femass.Dao;

import java.util.List;

public interface Dao <T>{

    public void save(T objeto) throws Exception;
    public List<T> getAll() throws Exception;
}
