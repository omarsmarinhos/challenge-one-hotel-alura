package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.RegistroReservasFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroReservasCtrl {
    
    private final RegistroReservasFrm registroReservasFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;
    RegistroHuespedCtrl registroHuespedCtrl;
    
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
    }
    
    private void validarDatos() {
        registroHuespedCtrl = new RegistroHuespedCtrl();
        registroHuespedCtrl.init();
        registroReservasFrm.dispose();
    }
    
    public void init() {
        registroReservasFrm.setVisible(true);
    }
    
    public RegistroReservasFrm getReservasFrm() {
        return registroReservasFrm;
    }
    
}