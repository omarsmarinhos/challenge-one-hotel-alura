package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.models.Huesped;
import com.omarinhos.hotel.alura.models.Reserva;
import com.omarinhos.hotel.alura.repositories.HuespedRepositoryImpl;
import com.omarinhos.hotel.alura.repositories.IRepository;
import com.omarinhos.hotel.alura.repositories.ReservaRepositoryImpl;
import com.omarinhos.hotel.alura.services.HuespedeService;
import com.omarinhos.hotel.alura.services.ReservaService;
import com.omarinhos.hotel.alura.views.BusquedaFrm;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
    List<Huesped> huespedes;
    List<Reserva> reservas;

    public BusquedaCtrl() {
        busquedaFrm = new BusquedaFrm();

        String[] huespedHeader = {"id", "nombre", "apellido", "fecha nacimiento", "nacionalidad", "telefono", "reserva"};
        String[] reservaHeader = {"id", "fecha ingreso", "fecha salida", "valor", "forma pago"};
        huespedModelo.setColumnIdentifiers(huespedHeader);
        reservaModelo.setColumnIdentifiers(reservaHeader);
        busquedaFrm.getTblHuespedes().setModel(huespedModelo);
        busquedaFrm.getTblReservas().setModel(reservaModelo);
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        huespedes = huespedeService.getHuespedes();
        reservas = reservaService.getReservas();

        actualizarTablaHuespedes();
        actualizarTablaReservas();

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
                String buscador = busquedaFrm.getTxtBuscar().getText();
                if (busquedaFrm.getTabbedPanel().getSelectedIndex() == 0) {
                    buscarHuesped(buscador);
                } else {
                    buscarReserva(buscador);
                }
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

    private void buscarReserva(String buscador) {
        Reserva reserva = reservaService.getReservaPor(buscador);
        if (reserva != null) {
            reservaModelo.setRowCount(0);
            reservaModelo.addRow(new Object[]{
                    reserva.getId(),
                    reserva.getFechaEntrada(),
                    reserva.getFechaSalida(),
                    reserva.getValor(),
                    reserva.getFormaPago()
            });
        }
        if (buscador.isEmpty() || reserva == null){
            reservas = reservaService.getReservas();
            actualizarTablaReservas();
        }
    }

    private void buscarHuesped(String buscador) {
        Huesped huesped = huespedeService.getHuespedPor(buscador);
        if (huesped != null) {
            huespedModelo.setRowCount(0);
            huespedModelo.addRow(new Object[]{
                    huesped.getId(),
                    huesped.getNombre(),
                    huesped.getApellido(),
                    huesped.getFechaNacimiento(),
                    huesped.getNacionalidad(),
                    huesped.getTelefono(),
                    huesped.getReserva().getId()
            });
        }
        if (buscador.isEmpty() || huesped == null){
            huespedes = huespedeService.getHuespedes();
            actualizarTablaHuespedes();
        }
    }

    private void actualizarTablaHuespedes() {
        huespedModelo.setRowCount(0);
        huespedes.forEach(huesped -> huespedModelo.addRow(new Object[]{
                huesped.getId(),
                huesped.getNombre(),
                huesped.getApellido(),
                huesped.getFechaNacimiento(),
                huesped.getNacionalidad(),
                huesped.getTelefono(),
                huesped.getReserva().getId()
        }));
        busquedaFrm.getTblHuespedes().getColumnModel().getColumn(0).setCellRenderer(dtcr);
        busquedaFrm.getTblHuespedes().getColumnModel().getColumn(3).setCellRenderer(dtcr);
        busquedaFrm.getTblHuespedes().getColumnModel().getColumn(5).setCellRenderer(dtcr);
        busquedaFrm.getTblHuespedes().getColumnModel().getColumn(6).setCellRenderer(dtcr);
    }

    private void actualizarTablaReservas() {
        reservaModelo.setRowCount(0);
        reservas.forEach(reserva -> reservaModelo.addRow(new Object[]{
                reserva.getId(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida(),
                reserva.getValor(),
                reserva.getFormaPago()
        }));
        busquedaFrm.getTblReservas().getColumnModel().getColumn(0).setCellRenderer(dtcr);
        busquedaFrm.getTblReservas().getColumnModel().getColumn(1).setCellRenderer(dtcr);
        busquedaFrm.getTblReservas().getColumnModel().getColumn(2).setCellRenderer(dtcr);
        busquedaFrm.getTblReservas().getColumnModel().getColumn(3).setCellRenderer(dtcr);
    }
    
    public void init() {
        busquedaFrm.setVisible(true);
    }
    

}