package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.views.LoginFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginCtrl {
    
    private final LoginFrm loginFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;
    
    public LoginCtrl() {
        loginFrm = new LoginFrm();
        
        loginFrm.getBtnEntrar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validarIngreso();
            }
        });
    }
    
    private void validarIngreso() {
        menuUsuarioCtrl = new MenuUsuarioCtrl();
        menuUsuarioCtrl.init();
        loginFrm.dispose();
    }

    public LoginFrm getLoginFrm() {
        return loginFrm;
    }
    
    public void init() {
        loginFrm.setVisible(true);
    }
     
}