package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.MenuUsuarioFrm;

public class MenuUsuarioCtrl {
    
    private final MenuUsuarioFrm menuUsuarioFrm;
    
    public MenuUsuarioCtrl() {
        menuUsuarioFrm = new MenuUsuarioFrm();
    }
    
    public MenuUsuarioFrm getMenuUsuarioFrm() {
        return menuUsuarioFrm;
    }
    
    public void init() {
        menuUsuarioFrm.setVisible(true);
    }
    
}