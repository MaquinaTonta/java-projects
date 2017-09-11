/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.seguridad.Cesar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Ing. Eduardo Basurto
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();

        this.setLocationRelativeTo(null);
        
        txtAlfabeto.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (hayDuplicidad()) {
                    warningAlfabeto.setText("Hay caracteres duplicados en tu alfabeto");
                    btnIngresar.setEnabled(false);
                } else {
                    warningAlfabeto.setText(null);
                    btnIngresar.setEnabled(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (hayDuplicidad()) {
                    warningAlfabeto.setText("Hay caracteres duplicados en tu alfabeto");
                    btnIngresar.setEnabled(false);
                } else {
                    warningAlfabeto.setText(null);
                    btnIngresar.setEnabled(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (hayDuplicidad()) {
                    warningAlfabeto.setText("Hay caracteres duplicados en tu alfabeto");
                    btnIngresar.setEnabled(false);
                } else {
                    warningAlfabeto.setText(null);
                    btnIngresar.setEnabled(true);
                }
            }

            private boolean hayDuplicidad() {
                boolean estaDoble = false;

                String alfabeto = txtAlfabeto.getText();
                Map<Character, Integer> alfa = new HashMap<>();
                for (int i = 0; i < alfabeto.length(); i++) {
                    if (alfa.containsKey(alfabeto.charAt(i))) {
                        int cont = alfa.get(alfabeto.charAt(i));
                        alfa.put(alfabeto.charAt(i), ++cont);
                    } else {
                        alfa.put(alfabeto.charAt(i), 1);
                    }
                }

                for (Map.Entry<Character, Integer> entrada : alfa.entrySet()) {
                    if (entrada.getValue() > 1) {
                        estaDoble = true;
                    }
                }

                return estaDoble;
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAlfabeto = new javax.swing.JTextField();
        lblIngresar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        warningAlfabeto = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cifrado Cesar");
        setResizable(false);

        lblIngresar.setText("Por favor, ingresa tu alfabeto:");

        lblTitulo.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        lblTitulo.setText("CIFRADO CÉSAR");

        warningAlfabeto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningAlfabeto.setForeground(new java.awt.Color(255, 0, 0));

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIngresar)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201))))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(warningAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblIngresar)
                .addGap(6, 6, 6)
                .addComponent(txtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        if(!txtAlfabeto.getText().isEmpty()){
            Cesar.setAlfabeto(txtAlfabeto.getText());
            new InterfazCesar().setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No se puede dejar vacio el campo de alfabeto");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAlfabeto;
    private javax.swing.JLabel warningAlfabeto;
    // End of variables declaration//GEN-END:variables
}
