package com.omarinhos.hotel.alura.services;

import com.omarinhos.hotel.alura.models.Huesped;
import com.omarinhos.hotel.alura.repositories.IRepository;
import java.sql.SQLException;
import java.util.List;

public class HuespedeService {
    
    private final IRepository repository;
    
    public HuespedeService(IRepository repository) {
        this.repository = repository;
    }
    
    public void crearHuesped(Huesped huesped) throws SQLException {
        repository.create(huesped);
    }
    
    public List<Huesped> getHuespedes() throws SQLException {
        return repository.read();
    }
    
    public void editarHuesped(Huesped huesped) throws SQLException {
        repository.update(huesped);
    }
    
    public void elimiarHuesped(int id) throws SQLException {
        repository.delete(id);
    }
    
    public Huesped getHuespedPor(String apellido) throws SQLException {
        return (Huesped) repository.findBy(apellido);
    }
    
}