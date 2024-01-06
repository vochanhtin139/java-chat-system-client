package com.ptq.model;

import com.ptq.app.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

public class Model_Send_Message {

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getConversationID() {
        return conversationID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public Model_Send_Message(MessageType messageType, int fromUserID, int toUserID, String text,String time) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.conversationID = -1;
        this.time=time;
    }
    
    public Model_Send_Message(MessageType messageType, int fromUserID, int toUserID, String text, int conversationID, String time) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.conversationID = conversationID;
        this.time=time;
    }

    public Model_Send_Message() {
    }

    private MessageType messageType;
    private int fromUserID;
    private int toUserID;
    private String text;
    private int conversationID;
    private String time;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("messageType", messageType.getValue());
            json.put("fromUserID", fromUserID);
            json.put("toUserID", toUserID);
            json.put("text", text);
            json.put("conversationID", conversationID);
            json.put("time", time);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
}