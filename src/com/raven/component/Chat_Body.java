/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JScrollBar;
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
        addItemRight("Lorem Ipsum");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemLeft("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        addItemLeft("hellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsdhellofsfsdfsd");
        addItemRight("ABCsdfgsdfgsdfgsSDFS");
    }
    
    private void init() {
        body.setLayout(new MigLayout("fillx", "", "0[]0"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    public void addItemLeft(String text) {
        Chat_Left item = new Chat_Left();
        item.setText(text);
        body.add(item, "wrap, w ::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemRight(String text) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        body.add(item, "wrap, al right, w ::80%");
        body.repaint();
        body.revalidate();
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
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
