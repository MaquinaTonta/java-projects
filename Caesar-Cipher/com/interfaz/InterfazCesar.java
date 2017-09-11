/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.seguridad.Cesar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Ing. Eduardo Basurto
 */
public class InterfazCesar extends javax.swing.JFrame {

    /**
     * Creates new form InterfazCesar
     */
    public InterfazCesar() {

        initComponents();
        this.setLocationRelativeTo(null);
        btnGrupo.add(btnCifrar);
        btnGrupo.add(btnDecifrar);

        txtMensaje.setEditable(false);
        txtCifrado.setEditable(false);

        btnCifrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnCifrar.isSelected()) {
                    txtMensaje.setEditable(true);
                    txtClave.setText(null);
                    txtMensaje.setText(null);
                    txtCifrado.setText(null);
                    txtCifrado.setEditable(false);
                    warningMensaje.setText(null);
                    warningCifrado.setText(null);
                    warningClave.setText(null);
                    txtMensaje.setBackground(Color.WHITE);
                    txtCifrado.setBackground(Color.WHITE);
                }
            }
        });

        btnDecifrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnDecifrar.isSelected()) {
                    txtCifrado.setEditable(true);
                    txtCifrado.setText(null);
                    txtClave.setText(null);
                    txtMensaje.setText(null);
                    txtMensaje.setEditable(false);
                    warningMensaje.setText(null);
                    warningCifrado.setText(null);
                    warningClave.setText(null);
                    txtMensaje.setBackground(Color.WHITE);
                    txtCifrado.setBackground(Color.WHITE);
                }
            }
        });

        txtMensaje.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                evaluarMensaje();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                evaluarMensaje();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                evaluarMensaje();
            }

            public void evaluarMensaje() {
                boolean hayError = false;
                if (!txtMensaje.getText().isEmpty()) {
                    String cadenaMensaje = txtMensaje.getText();
                    for (int i = 0; i < cadenaMensaje.length(); i++) {
                        if (Cesar.getAlfabeto().indexOf(cadenaMensaje.charAt(i)) == -1) {
                            warningMensaje.setText("Caracter no encontrado en el alfabeto");
                            btnEnviar.setEnabled(false);
                            hayError = true;
                            break;
                        }
                    }
                    if (!hayError) {
                        warningMensaje.setText(null);
                        btnEnviar.setEnabled(true);
                    }
                }
            }
        });

        txtCifrado.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                evaluarCifrado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                evaluarCifrado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                evaluarCifrado();
            }

            public void evaluarCifrado() {
                boolean hayError = false;
                if (!txtCifrado.getText().isEmpty()) {
                    String cadenaCifrado = txtCifrado.getText();
                    for (int i = 0; i < cadenaCifrado.length(); i++) {
                        if (Cesar.getAlfabeto().indexOf(cadenaCifrado.charAt(i)) == -1) {
                            warningCifrado.setText("Caracter no encontrado en el alfabeto");
                            btnEnviar.setEnabled(false);
                            hayError = true;
                            break;
                        }
                    }
                    if (!hayError) {
                        warningCifrado.setText(null);
                        btnEnviar.setEnabled(true);
                    }
                }
            }
        }
        );

        txtClave.getDocument()
                .addDocumentListener(new DocumentListener() {

                    @Override
                    public void insertUpdate(DocumentEvent e
                    ) {
                        if (!txtClave.getText().isEmpty()) {
                            String error = getErrorClave(txtClave.getText());
                            if (!error.isEmpty()) {
                                switch (error) {
                                    case "LETRA":
                                        warningClave.setText("La clave no acepta letras");
                                        btnEnviar.setEnabled(false);
                                        break;
                                    case "RANGO":
                                        warningClave.setText("La clave está fuera de rango");
                                        btnEnviar.setEnabled(false);
                                        break;
                                    case "DESCONOCIDO":
                                        warningClave.setText("La clave no acepta caracteres especiales");
                                        btnEnviar.setEnabled(false);
                                        break;
                                }
                            } else {
                                btnEnviar.setEnabled(true);
                                warningClave.setText(null);
                            }
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e
                    ) {
                        warningClave.setText(null);
                        if (!txtClave.getText().isEmpty()) {
                            String error = getErrorClave(txtClave.getText());
                            if (!error.isEmpty()) {
                                switch (error) {
                                    case "LETRA":
                                        warningClave.setText("La clave no acepta letras");
                                        btnEnviar.setEnabled(false);
                                        break;
                                    case "RANGO":
                                        warningClave.setText("La clave está fuera de rango");
                                        btnEnviar.setEnabled(false);
                                        break;
                                    case "DESCONOCIDO":
                                        warningClave.setText("La clave no acepta caracteres especiales");
                                        btnEnviar.setEnabled(false);
                                        break;
                                }
                            } else {
                                btnEnviar.setEnabled(true);
                                warningClave.setText(null);
                            }
                        }
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e
                    ) {
                        if (!txtClave.getText().isEmpty()) {
                            String error = getErrorClave(txtClave.getText());
                            if (!error.isEmpty()) {
                                switch (error) {
                                    case "LETRA":
                                        warningClave.setText("La clave no acepta letras");
                                        btnEnviar.setEnabled(false);
                                        break;
                                    case "RANGO":
                                        warningClave.setText("La clave está fuera de rango");
                                        btnEnviar.setEnabled(false);
                                        break;
                                    case "DESCONOCIDO":
                                        warningClave.setText("La clave no acepta caracteres especiales");
                                        btnEnviar.setEnabled(false);
                                        break;
                                }
                            } else {
                                btnEnviar.setEnabled(true);
                                warningClave.setText(null);
                            }
                        }
                    }

                    public String getErrorClave(String textfield) {
                        String tipo = "";
                        for (int i = 0; i < textfield.length(); i++) {
                            if (Character.isLetter(textfield.charAt(i))) {
                                tipo = "LETRA";
                                break;
                            } else if (!Character.isDigit(textfield.charAt(i))) {
                                tipo = "DESCONOCIDO";
                                break;
                            }
                        }
                        if (tipo.isEmpty()) {
                            int clave = Integer.parseInt(textfield);
                            if (clave < 0 || clave > Cesar.getAlfabeto().length() - 1) {
                                tipo = "RANGO";
                            }
                        }
                        return tipo;
                    }

                }
                );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        lblCifrado = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        txtCifrado = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnCifrar = new javax.swing.JRadioButton();
        btnDecifrar = new javax.swing.JRadioButton();
        warningMensaje = new javax.swing.JLabel();
        warningCifrado = new javax.swing.JLabel();
        warningClave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cifrado Cesar");
        setResizable(false);

        lblMensaje.setText("Mensaje:");

        lblCifrado.setText("Cifrado:");

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });

        txtCifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCifradoActionPerformed(evt);
            }
        });

        lblClave.setText("Clave (0-"+(Cesar.getAlfabeto().length()-1)+")");

        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        lblTitulo.setText("CIFRADO CÉSAR");

        btnCifrar.setText("Cifrar");
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        btnDecifrar.setText("Decifrar");

        warningMensaje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningMensaje.setForeground(new java.awt.Color(255, 0, 0));

        warningCifrado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningCifrado.setForeground(new java.awt.Color(255, 0, 0));

        warningClave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningClave.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje)
                    .addComponent(lblCifrado))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(warningMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblClave)))
                            .addComponent(lblTitulo))
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(txtCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(warningClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(warningCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnCifrar)
                        .addGap(43, 43, 43)
                        .addComponent(btnDecifrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addGap(32, 32, 32)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(warningMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCifrado)
                        .addComponent(txtCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(warningClave, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(warningCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCifrar)
                    .addComponent(btnDecifrar))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajeActionPerformed

    private void txtCifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCifradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCifradoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        if (!btnCifrar.isSelected() && !btnDecifrar.isSelected()) {
            JOptionPane.showMessageDialog(panelPrincipal, "Favor de seleccionar un tipo de operación");
        } else if (btnCifrar.isSelected() && txtMensaje.getText().isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal, "Favor de ingresar un mensaje a cifrar");
        } else if (btnDecifrar.isSelected() && txtCifrado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal, "Favor de ingresar un mensaje a decifrar");
        } else if ((btnCifrar.isSelected() && txtClave.getText().isEmpty() || (btnDecifrar.isSelected() && txtClave.getText().isEmpty()))) {
            JOptionPane.showMessageDialog(panelPrincipal, "Favor de ingresar una clave");
        } else {
            Cesar.setK(Integer.parseInt(txtClave.getText()));
            if (btnCifrar.isSelected()) {
                txtCifrado.setBackground(Color.YELLOW);
                txtCifrado.setText(Cesar.cifrar(txtMensaje.getText()));
            } else if (btnDecifrar.isSelected()) {
                txtMensaje.setBackground(Color.YELLOW);
                txtMensaje.setText(Cesar.decifrar(txtCifrado.getText()));
            }
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCifrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazCesar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCesar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCesar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCesar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCesar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnCifrar;
    private javax.swing.JRadioButton btnDecifrar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JLabel lblCifrado;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtCifrado;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JLabel warningCifrado;
    private javax.swing.JLabel warningClave;
    private javax.swing.JLabel warningMensaje;
    // End of variables declaration//GEN-END:variables
}
