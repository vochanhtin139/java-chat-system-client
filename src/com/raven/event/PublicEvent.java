/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.event;

/**
 *
 * @author vochanhtin139
 */
public class PublicEvent {
    private static PublicEvent instance;
    private EventImageView eventImageView;
    
    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }
    
    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }
    
    public EventImageView getEventImageView() { 
        return this.eventImageView;
    }
    
}
