package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.MenuUsuarioFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MenuUsuarioCtrl {
    
    private final MenuUsuarioFrm menuUsuarioFrm;
    RegistroReservasCtrl registroReservasCtrl;
    BusquedaCtrl busquedaCtrl;
    
    
    public MenuUsuarioCtrl() {
        menuUsuarioFrm = new MenuUsuarioFrm();
        
        String fechaHoy = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        menuUsuarioFrm.getTxtFechaHoy().setText("Hoy es " + fechaHoy);
        
        menuUsuarioFrm.getBtnRegistroReservas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registroReservasCtrl = new RegistroReservasCtrl();
                registroReservasCtrl.init();
                menuUsuarioFrm.dispose();
                
            }
        });
        
        menuUsuarioFrm.getBtnBusqueda().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                busquedaCtrl = new BusquedaCtrl();
                busquedaCtrl.init();
                menuUsuarioFrm.dispose();
            }
        });
    }
    
    public MenuUsuarioFrm getMenuUsuarioFrm() {
        return menuUsuarioFrm;
    }
    
    public void init() {
        menuUsuarioFrm.setVisible(true);
    }
    
}