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
public class item_People1 extends javax.swing.JPanel {

     public Model_User_Account getUser() {
        return user;
    }
    private boolean mouseOver;
    private final Model_User_Account user;

    public item_People1(Model_User_Account user, String btnText) {
        this.user = user;
        initComponents();
        btnAddFriend.setText(btnText);
        lb.setText(user.getUserName());
        activeStatus.setActive(user.isStatus());
        init();
    }

    public void updateStatus() {
        activeStatus.setActive(user.isStatus());
    }

    private void init() {
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                setBackground(new Color(230, 230, 230));
//                mouseOver = true;
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                setBackground(new Color(242, 242, 242));
//                mouseOver = false;
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent me) {
//                if (mouseOver) {
//                    PublicEvent.getInstance().getEventMain().selectUser(user);
//                }
//            }
//        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.raven.swing.ImageAvatar();
        activeStatus = new com.raven.swing.ActiveStatus();
        btnAddFriend = new javax.swing.JButton();
        lb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(230, 230, 230));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/user.png"))); // NOI18N

        activeStatus.setActive(true);
        activeStatus.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        imageAvatar1.add(activeStatus);
        activeStatus.setBounds(46, 46, 10, 10);

        btnAddFriend.setText("Add friend");
        btnAddFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFriendActionPerformed(evt);
            }
        });

        lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnAddFriend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnAddFriend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFriendActionPerformed
        // TODO add your handling code here
        if (btnAddFriend.getText().equals("Add friend")) {
            btnAddFriend.setText("Cancel request");
            Model_friendship friendship = new Model_friendship(Service.getInstance().getUser().getUserID(), this.user.getUserID());
            Service.getInstance().getClient().emit("make_friend", friendship.toJSONObject());
        }
        else if (btnAddFriend.getText().equals("Cancel request")) {
            btnAddFriend.setText("Add friend");
            Model_friendship friendship = new Model_friendship(Service.getInstance().getUser().getUserID(), this.user.getUserID());
            Service.getInstance().getClient().emit("unfriend", friendship.toJSONObject());   
        }
        else if (btnAddFriend.getText().equals("Accept friend")) {
            btnAddFriend.setText("SUCCESSFULLY!");
            Model_friendship friendship = new Model_friendship(this.user.getUserID(), Service.getInstance().getUser().getUserID());
            Service.getInstance().getClient().emit("accept_friend", friendship.toJSONObject());
        }
        else if (btnAddFriend.getText().equals("Block")) {
            btnAddFriend.setText("BLOCKED");
            btnAddFriend.setEnabled(false);
            Model_friendship friendship = new Model_friendship(this.user.getUserID(), Service.getInstance().getUser().getUserID());
            Service.getInstance().getClient().emit("block_user", friendship.toJSONObject());
        }
    }//GEN-LAST:event_btnAddFriendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ActiveStatus activeStatus;
    private javax.swing.JButton btnAddFriend;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
