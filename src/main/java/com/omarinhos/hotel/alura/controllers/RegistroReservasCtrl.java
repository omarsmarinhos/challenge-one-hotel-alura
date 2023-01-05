package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.models.Reserva;
import com.omarinhos.hotel.alura.repositories.IRepository;
import com.omarinhos.hotel.alura.repositories.ReservaRepositoryImpl;
import com.omarinhos.hotel.alura.services.ReservaService;
import com.omarinhos.hotel.alura.views.RegistroReservasFrm;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class RegistroReservasCtrl {
    
    private final RegistroReservasFrm registroReservasFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;
    RegistroHuespedCtrl registroHuespedCtrl;
    IRepository<Reserva> repository = new ReservaRepositoryImpl();
    ReservaService service = new ReservaService(repository);
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final double VALOR_DIARIO_FIJO = 50;

    public RegistroReservasCtrl() {
        registroReservasFrm = new RegistroReservasFrm();

        
        registroReservasFrm.getBtnAtras().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuUsuarioCtrl = new MenuUsuarioCtrl();
                menuUsuarioCtrl.init();
                registroReservasFrm.dispose();
            }
            
        });
        
        registroReservasFrm.getBtnSiguiente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validarDatos();
            }
            
        });

        registroReservasFrm.getjDtCheckOut().getJCalendar().
    }
    
    private void validarDatos() {
        String checkIn;
        String checkOut;
        try {
            checkIn = sdf.format(registroReservasFrm.getjDtCheckIn().getCalendar().getTime());
            checkOut = sdf.format(registroReservasFrm.getjDtCheckOut().getCalendar().getTime());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(registroReservasFrm, "Seleccionar las fechas",
                    "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LocalDate dateIn = LocalDate.parse(checkIn);
        LocalDate datOut = LocalDate.parse(checkOut);
        long days = DAYS.between(dateIn, datOut);
        String formaPago = (String) registroReservasFrm.getCmbFormaPago().getSelectedItem();

        Reserva reserva = new Reserva();
        reserva.setFechaEntrada(checkIn);
        reserva.setFechaSalida(checkOut);
        reserva.setValor(days * VALOR_DIARIO_FIJO);
        reserva.setFormaPago(formaPago);

        service.crearReserva(reserva);

        registroHuespedCtrl = new RegistroHuespedCtrl();
        registroHuespedCtrl.init();
        registroReservasFrm.dispose();
    }
    
    public void init() {
        registroReservasFrm.setVisible(true);
    }
    
}