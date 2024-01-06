/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptq.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author vochanhtin139
 */
public class Model_friendship_status {
    private int friendshipID;
    private int userID1;
    private int userID2;
    private String status;
    private String time;

    public Model_friendship_status(int friendshipID, int userID1, int userID2, String status, String time) {
        this.friendshipID = friendshipID;
        this.userID1 = userID1;
        this.userID2 = userID2;
        this.status = status;
        this.time = time;
    }
    
    public Model_friendship_status() {
    }

    public int getFriendshipID() {
        return friendshipID;
    }

    public void setFriendshipID(int friendshipID) {
        this.friendshipID = friendshipID;
    }

    public int getUserID1() {
        return userID1;
    }

    public void setUserID1(int userID1) {
        this.userID1 = userID1;
    }

    public int getUserID2() {
        return userID2;
    }

    public void setUserID2(int userID2) {
        this.userID2 = userID2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public Model_friendship_status(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            friendshipID = obj.getInt("friendshipID");
            userID1 = obj.getInt("userID1");
            userID2 = obj.getInt("userID2");
            status = obj.getString("status");
            time = obj.getString("time");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
    
}
