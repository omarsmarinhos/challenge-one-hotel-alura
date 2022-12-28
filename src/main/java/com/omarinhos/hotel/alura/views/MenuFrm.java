package com.omarinhos.hotel.alura.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuFrm extends javax.swing.JFrame {

    public MenuFrm() {
        initComponents();
    }

    public JLabel getBtnLogin() {
        return btnLogin;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        menuImg = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hotelAlura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setMinimumSize(new java.awt.Dimension(1150, 570));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setText("X");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 60, 40));

        head.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headMouseDragged(evt);
            }
        });
        head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headMousePressed(evt);
            }
        });
        jPanel1.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuImg.setIcon(new ImageIcon("imagenes/menu-img.png"));
        jPanel2.add(menuImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 540));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 540));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hotelAlura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelAlura.setIcon(new ImageIcon("imagenes/aH-150px.png"));
        jPanel3.add(hotelAlura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 170));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 260, 230, -1));

        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogin.setIcon(new ImageIcon("imagenes/login.png"));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, 110));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 240, 540));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Desarrollado por Omar Mariños 2022");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 16, 1150, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 1150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_headMouseDragged
    int xx, xy;
    private void headMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headMousePressed
       xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_headMousePressed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel head;
    private javax.swing.JLabel hotelAlura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel menuImg;
    // End of variables declaration//GEN-END:variables
    
    
}
