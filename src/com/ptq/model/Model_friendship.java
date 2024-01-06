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
public class Model_friendship {
    private int userID1;
    private int userID2;

    public Model_friendship(int userID1, int userID2) {
        this.userID1 = userID1;
        this.userID2 = userID2;
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
    
    public JSONObject toJSONObject() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("userID1", userID1);
            obj.put("userID2", userID2);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
}
