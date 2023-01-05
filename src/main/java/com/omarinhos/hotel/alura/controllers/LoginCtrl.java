package com.omarinhos.hotel.alura.controllers;

import com.omarinhos.hotel.alura.models.User;
import com.omarinhos.hotel.alura.services.ILoginService;
import com.omarinhos.hotel.alura.services.LoginServicePredeterminedImpl;
import com.omarinhos.hotel.alura.views.LoginFrm;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class LoginCtrl {
    
    private final LoginFrm loginFrm;
    MenuUsuarioCtrl menuUsuarioCtrl;
    private final ILoginService service = new LoginServicePredeterminedImpl();

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
        String username = loginFrm.getTxtUsuario().getText();
        String pass = String.valueOf(loginFrm.getTxtPassword().getPassword());

        if (pass.isEmpty() || username.isEmpty()) {
            JOptionPane.showMessageDialog(
                    loginFrm, "Debe llenar los campos", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = new User(username, pass);
        if (!service.getUser(user).isPresent()) {
            JOptionPane.showMessageDialog(
                    loginFrm, "El usuario y/o contraseña no coincide"
                    , "Usuario no válido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        menuUsuarioCtrl = new MenuUsuarioCtrl();
        menuUsuarioCtrl.init();
        loginFrm.dispose();

    }

    public void init() {
        loginFrm.setVisible(true);
    }
     
}