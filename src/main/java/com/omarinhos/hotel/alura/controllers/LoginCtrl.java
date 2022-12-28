package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.LoginFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginCtrl {
    
    private final LoginFrm loginFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;
    
    public LoginCtrl() {
        loginFrm = new LoginFrm();
        menuUsuarioCtrl = new MenuUsuarioCtrl();
        
        loginFrm.getBtnEntrar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validarIngreso();
            }
        });
    }
    
    private void validarIngreso() {
        menuUsuarioCtrl.init();
    }

    public LoginFrm getLoginFrm() {
        return loginFrm;
    }
    
    public void init() {
        loginFrm.setVisible(true);
    }
     
}