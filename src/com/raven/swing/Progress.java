/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.swing;

import javax.swing.JProgressBar;

/**
 *
 * @author ADMIN
 */
public class Progress extends JProgressBar {
    public Progress(){
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
}
