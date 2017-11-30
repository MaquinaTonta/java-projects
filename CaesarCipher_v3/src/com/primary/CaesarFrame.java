/*
 * Caesar Cipher
 *
 * This is a project that exemplifies the use of the Caesar Cipher. It also can
 * be used for personal purposes such as communication of information lacking 
 * relevance or whichever usage found by the user.
 *
 * Author: Eng. Eduardo Basurto VÃ¡zquez
 * Email: contacto.ebv@gmail.com
 *
 * 2017 (c) Maquina Tonta
 * Email: maquinatonta1@gmail.com
 * 
 */
package com.primary;

import com.security.Caesar;
import com.security.MyException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * This is the main frame for the Caesar Cipher program. It is responsible for
 * the input of both message and key for the process being carried out. It also
 * let the user to select the mode and the alphabet using a friendly UI
 *
 * @author Eng. Eduardo Basurto
 * @version 2.0
 */
public class CaesarFrame extends javax.swing.JFrame {

    // Variable declaration for the CaesarFram class
    /**
     * Boolean value used as a flag to confirmate if the message written by the
     * user satisfy the restrictions for its proper operation.
     */
    private boolean messageIsCorrect = false;
    /**
     * Boolean value used as a flag to confirmate if the key written by the user
     * satisfy the restrictions for its proper operation.
     */
    private boolean keyIsCorrect = false;
    // End of the variable declaration

    /**
     * Creates new form <code>CaesarFrame</code>
     * <p>
     * Also:
     * <ol>
     * <li>Initialize the components</li>
     * <li>Center the frame in the screen</li>
     * <li>Evaluates for the first time the message</li>
     * <li>Evaluates for the first time the key</li>
     * <li>Establishes the listeners for every component in the GUI</li>
     * <li>Set the Caesar Cipher icon for the form</li>
     * </ol>
     *
     */
    public CaesarFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        evaluateMessage();
        evaluateKey();
        implementListeners();
        setIcon();

    }

    /**
     * Method used to implement every Listener used by the diferent components
     * in the GUI.
     */
    private void implementListeners() {

        /*Listener in charge of checking constantly the content of the message
         field (message)*/
        txtKey.getDocument().addDocumentListener(new DocumentListener() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void insertUpdate(DocumentEvent e) {
                evaluateKey();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void removeUpdate(DocumentEvent e) {
                evaluateKey();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void changedUpdate(DocumentEvent e) {
                evaluateKey();
            }

        });

        /*Listener in charge of checking constantly the content of the key
         field (Clave)*/
        txtMessage.getDocument().addDocumentListener(new DocumentListener() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void insertUpdate(DocumentEvent e) {
                evaluateMessage();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void removeUpdate(DocumentEvent e) {
                evaluateMessage();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void changedUpdate(DocumentEvent e) {
                evaluateMessage();
            }
        });

        /*Listener used for the text field txtKey to simulate the onPressed
         action for the sendButton when Enter key is pressed and the cursor is
         in txtKey*/
        txtKey.addKeyListener(new KeyListener() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void keyTyped(KeyEvent e) {
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        && (messageIsCorrect && keyIsCorrect)) {
                    //Execute sendButton's method when Enter is pressed
                    sendButtonActionPerformed(null);
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        /*Listener used for the text field txtMessage to simulate the onPressed
         action for the sendButton when Enter key is pressed and the cursor is
         in txtMessage*/
        txtMessage.addKeyListener(new KeyListener() {

            /**
             * {@inheritDoc}
             */
            @Override
            public void keyTyped(KeyEvent e) {
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        && (messageIsCorrect && keyIsCorrect)) {
                    sendButtonActionPerformed(null);
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        /*Action Listener used to modify toggleButton and warningMessage when
         toggleProcess is selected or not*/
        ActionListener processAction = (ActionEvent e) -> {
            AbstractButton abstractButton = (AbstractButton) e.getSource();
            boolean isSelected = abstractButton.getModel().isSelected();
            if (isSelected) {
                toggleProcess.setText("Cipher");
            } else {
                toggleProcess.setText("Decipher");
            }
        };

        //Adding Action Listeners to JToggleButton's
        toggleProcess.addActionListener(processAction);
    }

    /**
     * This method is in charge of evaluating the message depending on the mode
     * selected and the alphabet
     */
    private void evaluateKey() {
        String key = txtKey.getText();
        int numericKey;

        /*try-catch statement is used for catching the empty field error and
         the out of range error. It also verifies that -0 is discarded*/
        try {
            if (key.isEmpty()) {
                throw new MyException("empty-key");
            }
            if (key.equals("-0")) {
                throw new NumberFormatException("minus-zero");
            }
            numericKey = Integer.parseInt(key);
            if (numericKey < 0) {
                throw new NumberFormatException("negative-key");
            }
            if (numericKey
                    > (Caesar.getAlphabet().length() - 1)) {
                keyIsCorrect = false;
                warningKey.setText("Key out of range");
            } else {
                keyIsCorrect = true;
                warningKey.setText(null);
            }
        } catch (NumberFormatException ex) {
            keyIsCorrect = false;
            warningKey.setText("Key only supports numeric characters");
        } catch (MyException ex) {
            keyIsCorrect = false;
            warningKey.setText(null);
        }

        /*The following instructions are used to verify after each listener is
         triggered if the message and the kay are correct or not. If they are 
         correct, sendButton is activated, otherwise it will be disabled.*/
        if (messageIsCorrect && keyIsCorrect) {
            sendButton.setEnabled(true);
            this.getRootPane().setDefaultButton(sendButton);
        } else {
            sendButton.setEnabled(false);
        }
    }

    /**
     * This method evaluates continuosly the message(message) for the Caesar
     * cipher. If there is a character not contained in the alhphabet, it
     * displays an error on screen and disables the send(ENVIAR) button. If the
     * field is empty, it just disables the button
     */
    private void evaluateMessage() {
        String message = txtMessage.getText();

        /*The try-catch statement helps to throw an error when the message 
         has an empty field or when a character is not contained in the 
         alphabet*/
        try {
            if (message.isEmpty()) {
                throw new MyException("empty-field");
            } else if (notInAlphabet(message)) {
                throw new MyException("doesnt-exist");
            } else {
                warningMessage.setText(null);
                messageIsCorrect = true;
            }

        } catch (MyException ex) {
            String errorType = ex.getMessage();
            switch (errorType) {
                case "empty-field":
                    messageIsCorrect = false;
                    warningMessage.setText(null);
                    break;
                case "doesnt-exist":
                    messageIsCorrect = false;
                    warningMessage.setText("Non-existent character "
                            + "in alphabet");
                    break;
            }
        }

        /*The following instructions are used to verify after each listener is
         triggered if the message and the kay are correct or not. If they are 
         correct, sendButton is activated, otherwise it will be disabled.*/
        if (messageIsCorrect && keyIsCorrect) {
            sendButton.setEnabled(true);
            this.getRootPane().setDefaultButton(sendButton);
        } else {
            sendButton.setEnabled(false);
        }

    }

    /**
     * Method used in the evaluateMessage() method. It tells if one of the
     * characters in your message is not contained in the alphabet or
     * <code>restrictedAlphabet</code>, depending on the selected mode. It is
     * intended to eliminate the logic errors in the cipher/decipher proces
     *
     * @return boolean True if a character doesn't existe in alphabet
     * @param str The message to verify
     */
    private boolean notInAlphabet(String str) {
        boolean doesntExist = false;

        for (int i = 0; i < str.length(); i++) {
            if (Caesar.getAlphabet().indexOf(str.charAt(i)) == -1) {
                doesntExist = true;
                break;
            }

        }
        return doesntExist;
    }

    /**
     * Method to set the icon for the form
     */
    private void setIcon() {
        Image image = new ImageIcon(this.getClass().
                getResource("/res/caesar-cipher-icon.png")).getImage();
        this.setIconImage(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPanel = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        keyLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        warningKey = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        toggleProcess = new javax.swing.JToggleButton();
        warningMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caesar Cipher");
        setResizable(false);

        principalPanel.setPreferredSize(new java.awt.Dimension(466, 371));

        messageLabel.setText("Message:");

        keyLabel.setText("Key: 0-"+(Caesar.getAlphabet().length()-1));

        sendButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sendButton.setText("SEND");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Broadway", 1, 36)); // NOI18N
        titleLabel.setText("Caesar Cipher");

        warningKey.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningKey.setForeground(new java.awt.Color(255, 0, 0));
        warningKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(199, 150));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(199, 150));

        toggleProcess.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        toggleProcess.setSelected(true);
        toggleProcess.setText("Cipher");
        toggleProcess.setFocusable(false);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toggleProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(toggleProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(toggleProcess, javax.swing.JLayeredPane.DEFAULT_LAYER);

        toggleProcess.getAccessibleContext().setAccessibleDescription("");

        warningMessage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningMessage.setForeground(new java.awt.Color(255, 0, 0));
        warningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(principalPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(principalPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(messageLabel)
                                .addGap(126, 126, 126)))
                        .addGap(25, 25, 25)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyLabel)))
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titleLabel)
                        .addGap(3, 3, 3)))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(warningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warningKey, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(titleLabel)
                .addGap(29, 29, 29)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageLabel)
                    .addComponent(keyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(warningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningKey, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("Main frame for the Caesar cipher project");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Methos used to perform an action whenever the <code>sendButton</code> 
     * button is pressed. It realize the process of cipher/decipher using the 
     * data contained in the <code>txtMessage</code> and <code>txtKey</code> 
     * text fields.
     * @param evt The event that triggers the button
     */
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:

        /*One more filter to verify that key and message fields are filled*/
        if (messageIsCorrect && keyIsCorrect) {
            /*If user wants to cipher with all of the characters*/
            if (toggleProcess.isSelected()) {
                String result = Caesar.cipher(txtMessage.getText(), Integer.parseInt(txtKey.getText()));
                Caesar.setResult(result);
                FinalResult FR = new FinalResult();
                FR.setVisible(true);
                this.dispose();

            }/*If user wants to decipher with all of the characters*/ else {
                String result = Caesar.decipher(txtMessage.getText(), Integer.parseInt(txtKey.getText()));
                Caesar.setResult(result);
                FinalResult FR = new FinalResult();
                FR.setVisible(true);
                this.dispose();
            }

        } /*If for an unexplainable reason fields are not filled and the Send 
         Button is pressed*/ else {
            JOptionPane.showMessageDialog(null,
                    "Something unexpected happened. Please contact "
                    + "administrator at contacto.ebv@gmail.com",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_sendButtonActionPerformed

    /**
     *
     * Main method for execution of the CaesarFrame class
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaesarFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CaesarFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Layered panel created to prevent frame resizing everytime a button is
    * activated
    */
    private javax.swing.JLayeredPane jLayeredPane1;
    /**
    * Label that displays the word "Key" and the range of the key, depending on
    * which mode is selected
    */
    private javax.swing.JLabel keyLabel;
    /**
    * Label that displays "Message"
    */
    private javax.swing.JLabel messageLabel;
    /**
    * Main panel containing every component in the class
    */
    private javax.swing.JPanel principalPanel;
    /**
    * The button Send created to start the process
    */
    private javax.swing.JButton sendButton;
    /**
    * Label that displays "Caesar Cipher"
    */
    private javax.swing.JLabel titleLabel;
    /**
    * A toggle button created to select between ciphering or deciphering process
    */
    private javax.swing.JToggleButton toggleProcess;
    /**
    * A text field created to input the key by the user
    */
    private javax.swing.JTextField txtKey;
    /**
    * A text field created to input the message by the user
    */
    private javax.swing.JTextField txtMessage;
    /**
    * Label used for deploying warning messages related to the txtKey
    * text field
    */
    private javax.swing.JLabel warningKey;
    /**
    * Label used for deploying warning messages related to the txtMessage
    * text field
    */
    private javax.swing.JLabel warningMessage;
    // End of variables declaration//GEN-END:variables

}
