/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ptq.component;

import com.ptq.model.Model_User_Account;
import com.ptq.model.Model_friendship;
import com.ptq.service.Service;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vochanhtin139
 */
public class Chat_Title extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }

    private Model_User_Account user;

    public Chat_Title() {
        initComponents();
    }

    public void setUserName(Model_User_Account user) {
        this.user = user;
        lbName.setText(user.getFullName());
        if (user.isStatus()) {
            statusActive();
        } else {
            setStatusText("Offline");
        }
        
        List<Model_User_Account> users = Service.getInstance().getSpamList();
        
        for (Model_User_Account d : users)
            if (d.getUserID() == user.getUserID()) {
                btnSpam.setEnabled(false);
                btnSpam.setText("MARKED AS SPAM");
                break;
            }
    }

    public void updateUser(Model_User_Account user) {
        if (this.user == user) {
            lbName.setText(user.getUserName());
            if (user.isStatus()) {
                statusActive();
            } else {
                setStatusText("Offline");
            }
        }
    }

    private void statusActive() {
        lbStatus.setText("Active now");
        lbStatus.setForeground(new java.awt.Color(40, 147, 59));
    }

    private void setStatusText(String text) {
        lbStatus.setText(text);
        lbStatus.setForeground(new Color(160, 160, 160));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        btnSpam = new javax.swing.JButton();

        layer.setLayout(new java.awt.GridLayout(0, 1));

        lbName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lbName.setForeground(new java.awt.Color(66, 66, 66));
        lbName.setText("Name");
        layer.add(lbName);

        lbStatus.setForeground(new java.awt.Color(35, 164, 59));
        lbStatus.setText("Active now");
        layer.add(lbStatus);

        btnSpam.setText("MARK AS SPAM");
        btnSpam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layer, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSpam)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(layer)
                    .addComponent(btnSpam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSpamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpamActionPerformed
        int output = JOptionPane.showConfirmDialog(this
               , "Are you sure to mark this as spam?"
               ,"Warning"
               ,JOptionPane.YES_NO_OPTION);

            if(output == JOptionPane.YES_OPTION){
                Model_friendship data = new Model_friendship(Service.getInstance().getUser().getUserID(), this.user.getUserID());
                Service.getInstance().getClient().emit("report_user_spam", data.toJSONObject());
                btnSpam.setEnabled(false);
                btnSpam.setText("MARKED AS SPAM");
            }
    }//GEN-LAST:event_btnSpamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpam;
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
