/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import protocols.ServerProtocol;
import sockets.SocketServer;
import utils.SocketsUtil;
import utils.TimeUtil;

/**
 *
 * @author Jerry Auvagha
 */
public class ServerApp extends javax.swing.JFrame {

    //I need this bool so that the text is not changed every single time the send option is selected
    private boolean sendActionWasSelected = false;
    private ServerProtocol serverProtocol;

    /**
     * Creates new form ClientApp
     */
    public ServerApp() {
        initComponents();
        initVariables();
        populateChooseActionComboBox();
        showPortNumber();
    }

    private void showPortNumber() {
        portNumberLabel.setText(String.format("Running: Port %s", SocketsUtil.getSelectedPort()));
    }

    private void initVariables() {
        serverProtocol = new ServerProtocol();
    }

    private void populateChooseActionComboBox() {
        String[] actions = serverProtocol.getActionStrings();

        for (String action : actions) {
            chooseActionComboBox.addItem(action);
        }

        ActionListener chooseActionComboBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseActionComboBox.getSelectedIndex() == 5) {
                    sendBtn.setText("SEND INFORMATION");
                    sendActionWasSelected = true;
                } else if (sendActionWasSelected) {
                    sendActionWasSelected = false;
                    sendBtn.setText("REQUEST INFORMATION");
                }
            }
        };

        chooseActionComboBox.addActionListener(chooseActionComboBoxListener);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        chooseActionComboBox = new javax.swing.JComboBox<>();
        sendBtn = new javax.swing.JButton();
        toyServerLabel = new javax.swing.JLabel();
        portNumberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Side");
        setResizable(false);

        bgPanel.setBackground(new java.awt.Color(0, 0, 0));

        messageTextArea.setBackground(new java.awt.Color(255, 255, 255));
        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane2.setViewportView(messageTextArea);

        sendBtn.setBackground(new java.awt.Color(255, 0, 51));
        sendBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sendBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendBtn.setText("REQUEST INFORMATION");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        toyServerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        toyServerLabel.setForeground(new java.awt.Color(255, 255, 255));
        toyServerLabel.setText("TOY SERVER");

        portNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        portNumberLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toyServerLabel)
                        .addGap(162, 162, 162)
                        .addComponent(portNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgPanelLayout.createSequentialGroup()
                                .addComponent(chooseActionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toyServerLabel)
                    .addComponent(portNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseActionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        String previousMessageStream = messageTextArea.getText();
        int actionSelected = chooseActionComboBox.getSelectedIndex();
        //Write message to client
        serverProtocol.setPreviousMessageStream(previousMessageStream);
        serverProtocol.processRequest(actionSelected);
    }//GEN-LAST:event_sendBtnActionPerformed

    public static void setReceivedMessage(String msgReceived) {
        String message = String.format("%s\n [CLIENT@%s]: %s", messageTextArea.getText(), TimeUtil.getLocalTimeNow(),
                msgReceived);
        messageTextArea.setText(message);
    }

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
            java.util.logging.Logger.getLogger(ServerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerApp().setVisible(true);
            }
        });

        //Open connection to server socket
        SocketServer.openServerSocket();
    }

    //NOTE: The texaarea is static because is needs to be access from the main method, which is static
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JComboBox<String> chooseActionComboBox;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea messageTextArea;
    private javax.swing.JLabel portNumberLabel;
    private javax.swing.JButton sendBtn;
    private javax.swing.JLabel toyServerLabel;
    // End of variables declaration//GEN-END:variables
}
