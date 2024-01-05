/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.event.PublicEvent;
import com.raven.model.Model_User_Account;
import com.raven.model.Model_friendship;
import com.raven.service.Service;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author vochanhtin139
 */
public class item_People_Friend extends javax.swing.JPanel {

     public Model_User_Account getUser() {
        return user;
    }
     
    private boolean mouseOver;
    private final Model_User_Account user;

    public item_People_Friend(Model_User_Account user) {
        this.user = user;
        initComponents();
        lb.setText(user.getFullName());
        activeStatus.setActive(user.isStatus());
        init();
    }
   
    public void updateStatus() {
        activeStatus.setActive(user.isStatus());
    }

    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (mouseOver) {
//                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.raven.swing.ImageAvatar();
        activeStatus = new com.raven.swing.ActiveStatus();
        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnChat = new javax.swing.JButton();
        btnBlock = new javax.swing.JButton();

        setBackground(new java.awt.Color(230, 230, 230));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/user.png"))); // NOI18N

        activeStatus.setActive(true);
        activeStatus.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        imageAvatar1.add(activeStatus);
        activeStatus.setBounds(46, 46, 10, 10);

        lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb.setText("Name");

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        btnChat.setText("Chat");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });
        jPanel1.add(btnChat);

        btnBlock.setText("Block");
        btnBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockActionPerformed(evt);
            }
        });
        jPanel1.add(btnBlock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        // TODO add your handling code here:
        Model_friendship friendship = new Model_friendship(this.user.getUserID(), Service.getInstance().getUser().getUserID());
        Service.getInstance().getClient().emit("create_conversation", friendship.toJSONObject());
    }//GEN-LAST:event_btnChatActionPerformed

    private void btnBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockActionPerformed
        if (btnBlock.getText().equals("Block")) {
            btnBlock.setText("BLOCKED");
            btnBlock.setEnabled(false);
            btnChat.setEnabled(false);
            Model_friendship friendship = new Model_friendship(this.user.getUserID(), Service.getInstance().getUser().getUserID());
            Service.getInstance().getClient().emit("block_user", friendship.toJSONObject());
        }
    }//GEN-LAST:event_btnBlockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ActiveStatus activeStatus;
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnChat;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
