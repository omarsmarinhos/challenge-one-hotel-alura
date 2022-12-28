package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.MenuUsuarioFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MenuUsuarioCtrl {
    
    private final MenuUsuarioFrm menuUsuarioFrm;
    RegistroHuespedCtrl registroHuespedCtrl;
    
    public MenuUsuarioCtrl() {
        menuUsuarioFrm = new MenuUsuarioFrm();
        
        String fechaHoy = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        menuUsuarioFrm.getTxtFechaHoy().setText(fechaHoy);
        
        menuUsuarioFrm.getBtnRegistroReservas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registroHuespedCtrl = new RegistroHuespedCtrl();
                registroHuespedCtrl.init();
                menuUsuarioFrm.dispose();
                
            }
        });
        
        menuUsuarioFrm.getBtnBusqueda().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
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