/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.swing.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author vochanhtin139
 */
public class Chat_Body extends javax.swing.JPanel {

    /**
     * Creates new form Chat_Body
     */
    public Chat_Body() {
        initComponents();
        init();
        addDate("18/11/2023");
        addItemRight("Lorem Ipsum");
        addItemLeft("hellofsfsdfsdofsffsfsdfsd", "Chanh Tin");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemLeft("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "Chanh Tin");
        addDate("19/11/2023");
        String img[]={"LGP%V2-;_4ISt4IVRk?H~p%2Rk9Z","LPS$lkay?dofjrfQbIfQ%hj[ITay"};
        addItemLeft("hello", "Chanh Tin",img);
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd", "Chanh Tin");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",new ImageIcon(getClass().getResource("/com/raven/icon/rainbow.jpeg")));
        addDate("yesterday");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd", "Chanh Tin",new ImageIcon(getClass().getResource("/com/raven/icon/rainbow.jpeg")));
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd", new ImageIcon(getClass().getResource("/com/raven/icon/rainbow.jpeg")));
        addItemRight("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd", "Chanh Tin", new ImageIcon(getClass().getResource("/com/raven/icon/profile.png")));
        addDate("today");
        addItemRight("ABCsdfgsdfgsdfgsSDFS");
        addItemLeft("", "daniel", new ImageIcon(getClass().getResource("/com/raven/icon/rainbow.jpeg")), new ImageIcon(getClass().getResource("/com/raven/icon/rainbow.jpeg")));
        addItemFile("this is my file", "Chanh Tin", "my-file.pdf", "4 MB");
        addItemFileRight("file", "123pfls.txt", "100 KB");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd", new ImageIcon(getClass().getResource("/com/raven/icon/rainbow.jpeg")));
        addItemLeft("hellofsfsdfsdofsffsfsdfsd", "Chanh Tin");
        addItemLeft("hellofsfsdfsdofsffsfsdfsd", "Chanh Tin");
    }
    
    private void init() {
        body.setLayout(new MigLayout("fillx", "", "0[]0"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    public void addItemLeft(String text, String user, Icon... image) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setUserProfile(user);
        item.setText(text);
        item.setImage(image);
        item.setTime();
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemLeft(String text, String user, String[] image) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setUserProfile(user);
        item.setText(text);
        item.setImage(image);
        item.setTime();
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemFile(String text, String user, String fileName, String fileSize) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    
    public void addItemRight(String text, Icon... image) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setImage(image);
        body.add(item, "wrap, al right, w 100::80%");
        body.repaint();
        body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemFileRight(String text, String fileName, String fileSize) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setFile(fileName, fileSize);
        body.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    public void addDate(String date) {
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
    }
    
    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 939, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sp)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
