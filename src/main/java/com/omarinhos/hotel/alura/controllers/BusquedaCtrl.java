package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.models.Huesped;
import com.omarinhos.hotel.alura.models.Reserva;
import com.omarinhos.hotel.alura.repositories.HuespedRepositoryImpl;
import com.omarinhos.hotel.alura.repositories.IRepository;
import com.omarinhos.hotel.alura.repositories.ReservaRepositoryImpl;
import com.omarinhos.hotel.alura.services.HuespedeService;
import com.omarinhos.hotel.alura.services.ReservaService;
import com.omarinhos.hotel.alura.views.BusquedaFrm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BusquedaCtrl {
    
    private final BusquedaFrm busquedaFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;
    IRepository<Huesped> huespedRepository = new HuespedRepositoryImpl();
    IRepository<Reserva> reservaRepository = new ReservaRepositoryImpl();
    HuespedeService huespedeService = new HuespedeService(huespedRepository);
    ReservaService reservaService = new ReservaService(reservaRepository);
    private final DefaultTableModel huespedModelo = new DefaultTableModel();
    private final DefaultTableModel reservaModelo = new DefaultTableModel();
    List<Huesped> huespedes;
    List<Reserva> reservas;

    public BusquedaCtrl() {
        busquedaFrm = new BusquedaFrm();

        huespedes = huespedeService.getHuespedes();
        reservas = reservaService.getReservas();
        
        busquedaFrm.getBtnAtras().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuUsuarioCtrl = new MenuUsuarioCtrl();
                menuUsuarioCtrl.init();
                busquedaFrm.dispose();
            }
            
        });
        
        busquedaFrm.getBtnBuscar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
            
        });
        
        busquedaFrm.getBtnEditar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
            
        });
        
        busquedaFrm.getBtnEliminar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
            
        });
    }
    
    private void actualizarTablaHuespedes() {
        
    }

    private void actualizarTablaReservas() {

    }
    
    public void init() {
        busquedaFrm.setVisible(true);
    }
    

}