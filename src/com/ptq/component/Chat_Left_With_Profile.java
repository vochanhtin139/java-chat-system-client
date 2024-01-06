/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ptq.component;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author vochanhtin139
 */
public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {

    /**
     * Creates new form Chat_Left
     */
    public Chat_Left_With_Profile() {
        initComponents();
        chat_Item1.setBackground(new Color(242, 242, 242));
    }
    
    public void setUserProfile(String user) {
        chat_Item1.setUserProfile(user);
    }
    
    public void setImageProfile(Icon image) {
        lalImage.setImage(image);
    }
    
    public void setText(String text) {
        if (text.equals("")) {
            chat_Item1.hideText();
        }
        else {
            chat_Item1.setText(text);
        }
        
        chat_Item1.sendSuccess();
    }
    
    public void setImage(Icon... image) {
        chat_Item1.setImage(false, image);
    }
    
    public void setImage(String... image) {
        chat_Item1.setImage(false, image);
    }
    
    public void setFile(String fileName, String fileSize) {
        chat_Item1.setFile(fileName, fileSize);
    }
    
    public void setTime() {
        chat_Item1.setTime("11:55 AM");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lalImage = new com.ptq.swing.ImageAvatar();
        chat_Item1 = new com.ptq.component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        lalImage.setBorderSize(0);
        lalImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/ptq/icon/profile.png"))); // NOI18N

        jLayeredPane1.setLayer(lalImage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(chat_Item1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chat_Item1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chat_Item1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jLayeredPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ptq.component.Chat_Item chat_Item1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.ptq.swing.ImageAvatar lalImage;
    // End of variables declaration//GEN-END:variables
}