package com.omarinhos.hotel.alura.services;

import com.omarinhos.hotel.alura.models.Reserva;
import com.omarinhos.hotel.alura.repositories.IRepository;
import java.sql.SQLException;
import java.util.List;

public class ReservaService {
 
    private final IRepository repository;
    
    public ReservaService(IRepository repository) {
        this.repository = repository;
    }
    
    public void crearReserva(Reserva reserva) throws SQLException {
        repository.create(reserva);
    }
    
    public List<Reserva> getReservas() throws SQLException {
        return repository.read();
    }
    
    public void editarReserva(Reserva reserva) throws SQLException {
        repository.update(reserva);
    }
    
    public void elimiarReserva(int id) throws SQLException {
        repository.delete(id);
    }
    
    public Reserva getReservaPor(String id) throws SQLException {
        return (Reserva) repository.findBy(id);
    }
    
}