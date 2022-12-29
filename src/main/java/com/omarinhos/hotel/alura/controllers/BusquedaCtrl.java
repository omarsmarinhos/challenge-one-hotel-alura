package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.BusquedaFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusquedaCtrl {
    
    private final BusquedaFrm busquedaFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;

    public BusquedaCtrl() {
        busquedaFrm = new BusquedaFrm();
        
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
    
    
    
    public void init() {
        busquedaFrm.setVisible(true);
    }
    
    public BusquedaFrm getBusquedaFrm() {
        return busquedaFrm;
    }
    
    
}