package com.ptq.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vochanhtin139
 */
public class Model_conversation {
    private int msgID;
    private int cvsID;
    private int senderID;
    private String content;
    private String time;

    public Model_conversation(int msgID, int cvsID, int senderID, String content, String time) {
        this.msgID = msgID;
        this.cvsID = cvsID;
        this.senderID = senderID;
        this.content = content;
        this.time = time;
    }

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public int getCvsID() {
        return cvsID;
    }

    public void setCvsID(int cvsID) {
        this.cvsID = cvsID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        LocalDateTime dateTime = LocalDateTime.parse(this.time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        
        // Define a formatter to specify the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        
        // Convert the LocalDateTime to a string in the desired format
        String formattedTime = dateTime.format(formatter);
        return formattedTime;
    }

    public void setTime(String time) {
        
        this.time = time;
    }
    
    public Model_conversation(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            msgID = obj.getInt("msgID");
            cvsID = obj.getInt("cvsID");
            senderID = obj.getInt("senderID");
            content = obj.getString("content");
            time = obj.getString("time");
            
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
    
    public JSONObject toJSONObject() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("msgID", msgID);
            obj.put("cvsID", cvsID);
            obj.put("senderID", senderID);
            obj.put("content", content);
            obj.put("time", time);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
    
}
