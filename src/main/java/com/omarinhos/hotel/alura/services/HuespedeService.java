package com.omarinhos.hotel.alura.services;

import com.omarinhos.hotel.alura.models.Huesped;
import com.omarinhos.hotel.alura.repositories.IRepository;
import java.sql.SQLException;
import java.util.List;

public class HuespedeService {
    
    private final IRepository<Huesped> repository;
    
    public HuespedeService(IRepository<Huesped> repository) {
        this.repository = repository;
    }
    
    public void crearHuesped(Huesped huesped) {
        try {
            repository.create(huesped);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Huesped> getHuespedes() {
        try {
            return repository.read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void editarHuesped(Huesped huesped) {
        try {
            repository.update(huesped);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void eliminarHuesped(int id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Huesped getHuespedPor(String apellido) {
        try {
            return repository.findBy(apellido);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int lastId() {
        try {
            return repository.lastId();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    
}