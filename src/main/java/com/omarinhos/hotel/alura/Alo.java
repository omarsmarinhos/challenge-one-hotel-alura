package com.omarinhos.hotel.alura;

import com.omarinhos.hotel.alura.models.Huesped;
import com.omarinhos.hotel.alura.models.Reserva;
import com.omarinhos.hotel.alura.repositories.HuespedRepositoryImpl;
import com.omarinhos.hotel.alura.repositories.IRepository;
import com.omarinhos.hotel.alura.repositories.ReservaRepositoryImpl;
import com.omarinhos.hotel.alura.services.HuespedeService;
import com.omarinhos.hotel.alura.services.ReservaService;
import java.sql.SQLException;

public class Alo {

    public static void main(String[] args) throws SQLException {
        
        IRepository repository = new HuespedRepositoryImpl();
        ReservaService reservaService = new ReservaService(repository);
        HuespedeService huespedeService = new HuespedeService(repository);
        
        huespedeService.getHuespedes().forEach(r -> {
            System.out.println(r.toString());
        });
        System.out.println("");
        
        Huesped huespeed = new Huesped();
        huespeed.setId(4);
        huespeed.setNombre("Pedro");
        huespeed.setApellido("Ramirez");
        huespeed.setFechaNacimiento("2000-1-26");
        huespeed.setNacionalidad("Argentino");
        huespeed.setTelefono("902053114");
        Reserva reserva = new Reserva();
        reserva.setId(4);
        huespeed.setReserva(reserva);
        
        huespedeService.editarHuesped(huespeed);
        
        huespedeService.getHuespedes().forEach(r -> {
            System.out.println(r.toString());
        });
        System.out.println("");  
        
    }
}