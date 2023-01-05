package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.RegistroHuespedFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroHuespedCtrl {

    private final RegistroHuespedFrm registroHuespedFrm;
    RegistroReservasCtrl registroReservasCtrl;
    
    public RegistroHuespedCtrl() {
        registroHuespedFrm = new RegistroHuespedFrm();
        
        registroHuespedFrm.getBtnAtras().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registroReservasCtrl = new RegistroReservasCtrl();
                registroReservasCtrl.init();
                registroHuespedFrm.dispose();
            }
            
        });
        registroHuespedFrm.getBtnGuardar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validarDatos();
            }
            
        });
    }
    
    private void validarDatos() {
        
    }
    
    public void init() {
        registroHuespedFrm.setVisible(true);
    }
    

    
    
}