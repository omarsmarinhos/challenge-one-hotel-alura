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
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

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
                if (busquedaFrm.getTabbedPanel().getSelectedIndex() == 0) {
                    editarHuesped();
                } else {
                    editarReserva();
                }
            }
            
        });
        
        busquedaFrm.getBtnEliminar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (busquedaFrm.getTabbedPanel().getSelectedIndex() == 0) {
                    eliminarHuesped();
                } else {
                    eliminarReserva();
                }
            }
        });
    }

    private void editarReserva() {
        int x = busquedaFrm.getTblReservas().getSelectedRow();
        if (x >= 0) {
            Reserva reserva = new Reserva();
            if (reservaModelo.getValueAt(x, 0) instanceof String) {
                System.out.println("string");
                reserva.setId(Integer.parseInt((String) reservaModelo.getValueAt(x, 0)));
            } else {
                System.out.println("integer");
                reserva.setId( (Integer) reservaModelo.getValueAt(x, 0));
            }
            reserva.setFechaEntrada((String) reservaModelo.getValueAt(x, 1));
            reserva.setFechaSalida((String) reservaModelo.getValueAt(x, 2));
            if (reservaModelo.getValueAt(x, 3) instanceof String) {
                reserva.setValor(Double.parseDouble((String) reservaModelo.getValueAt(x, 3)));
            } else {
                reserva.setValor( (Double) reservaModelo.getValueAt(x, 3));
            }
            reserva.setFormaPago((String) reservaModelo.getValueAt(x, 4));
            try {
                reservaService.editarReserva(reserva);
                JOptionPane.showMessageDialog(busquedaFrm,
                        "Reserva actualizada",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                reservas = reservaService.getReservas();
                actualizarTablaReservas();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(busquedaFrm,
                        "Datos incorrectos",
                        "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


    private void editarHuesped() {
        int x = busquedaFrm.getTblHuespedes().getSelectedRow();
        if (x >= 0) {
            Huesped huesped = new Huesped();
            Reserva reserva = new Reserva();
            huesped.setReserva(reserva);
            if (huespedModelo.getValueAt(x, 0) instanceof String) {
                huesped.setId(Integer.parseInt( (String) huespedModelo.getValueAt(x, 0)));
            } else {
                huesped.setId( (Integer) huespedModelo.getValueAt(x, 0));
            }
            huesped.setNombre( (String) huespedModelo.getValueAt(x, 1));
            huesped.setApellido( (String) huespedModelo.getValueAt(x, 2));
            huesped.setFechaNacimiento( (String) huespedModelo.getValueAt(x, 3));
            huesped.setNacionalidad( (String) huespedModelo.getValueAt(x, 4));
            huesped.setTelefono( (String) huespedModelo.getValueAt(x, 5));
            if (huespedModelo.getValueAt(x, 6) instanceof String) {
                huesped.getReserva().setId(Integer.parseInt((String) huespedModelo.getValueAt(x, 6)));
            } else {
                huesped.getReserva().setId( (Integer) huespedModelo.getValueAt(x, 6));
            }
            try {
                huespedeService.editarHuesped(huesped);
                JOptionPane.showMessageDialog(busquedaFrm,
                        "Huésped actualizado",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                huespedes = huespedeService.getHuespedes();
                actualizarTablaHuespedes();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(busquedaFrm,
                    "Datos incorrectos",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarReserva() {
        int x, id;
        x = busquedaFrm.getTblReservas().getSelectedRow();
        if (x >= 0) {
            x = busquedaFrm.getTblReservas().getSelectedRow();
            id = reservas.get(x).getId();
            try {
                reservaService.eliminarReserva(id);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(busquedaFrm,
                        "Debe eliminar a los huéspedes de esta reserva primero.",
                        "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
            reservas = reservaService.getReservas();
            actualizarTablaReservas();
        }
    }
    private void eliminarHuesped() {
        int x;
        int id;
        x = busquedaFrm.getTblHuespedes().getSelectedRow();
        if (x >= 0) {
            id = huespedes.get(x).getId();
            try {
                huespedeService.eliminarHuesped(id);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(busquedaFrm, "Error");
            }
            huespedes = huespedeService.getHuespedes();
            actualizarTablaHuespedes();
        }
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