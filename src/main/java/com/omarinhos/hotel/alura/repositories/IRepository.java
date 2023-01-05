package com.omarinhos.hotel.alura.repositories;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    
    void create(T t) throws SQLException;
    List<T> read() throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
    T findBy(String s) throws SQLException;
    int lastId() throws SQLException;
    
}
