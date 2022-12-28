package com.omarinhos.hotel.alura;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.omarinhos.hotel.alura.controllers.LoginCtrl;
import com.omarinhos.hotel.alura.views.MenuFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    MenuFrm menulFrm = new MenuFrm();
    LoginCtrl loginCtrl = new LoginCtrl();
    
    public Main() {
        menulFrm.getBtnLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginCtrl.init();
                menulFrm.dispose();
            }
            
        });
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Main().menulFrm.setVisible(true);
        });
    }
}
