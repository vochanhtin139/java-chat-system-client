package com.ptq.event;

public class PublicEvent {

    private static PublicEvent instance;
    private EventMain eventMain;
    private EventImageView eventImageView;
    private EventChat eventChat;
    private EventLogin eventLogin;
    private EventMenuLeft eventMenuLeft;
    private EventMenuRight eventMenuRight;
    private EventChatTitle eventChatTitle;

    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() { 
    }
    
    public void addEventChatTitle(EventChatTitle event) {
        this.eventChatTitle = event;
    }

    public void addEventMain(EventMain event) {
        this.eventMain = event;
    }

    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }

    public void addEventChat(EventChat event) {
        this.eventChat = event;
    }

    public void addEventLogin(EventLogin event) {
        this.eventLogin = event;
    }
    
    public void addEventMenuLeft(EventMenuLeft event) {
        this.eventMenuLeft = event;
    }
    
    public void addEventMenuRight(EventMenuRight event) {
        this.eventMenuRight = event;
    }

    public EventMain getEventMain() {
        return eventMain;
    }
    
    public EventChatTitle getEventChatTitle() {
        return eventChatTitle;
    }

    public EventImageView getEventImageView() {
        return eventImageView;
    }

    public EventChat getEventChat() {
        return eventChat;
    }

    public EventLogin getEventLogin() {
        return eventLogin;
    }
    
    public EventMenuLeft getEventMenuLeft() {
        return eventMenuLeft;
    }
    
    public EventMenuRight getEventMenuRight() {
        return eventMenuRight;
    }
}