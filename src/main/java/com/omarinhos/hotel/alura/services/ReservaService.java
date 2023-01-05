package com.omarinhos.hotel.alura.services;

import com.omarinhos.hotel.alura.models.Reserva;
import com.omarinhos.hotel.alura.repositories.IRepository;
import java.sql.SQLException;
import java.util.List;

public class ReservaService {
 
    private final IRepository<Reserva> repository;
    
    public ReservaService(IRepository<Reserva> repository) {
        this.repository = repository;
    }
    
    public void crearReserva(Reserva reserva) {
        try {
            repository.create(reserva);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Reserva> getReservas() {
        try {
            return repository.read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void editarReserva(Reserva reserva) {
        try {
            repository.update(reserva);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void elimiarReserva(int id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Reserva getReservaPor(String id) {
        try {
            return repository.findBy(id);
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