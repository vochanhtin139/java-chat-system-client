
package com.raven.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author quynhphan
 */
public class Model_User_Account {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public Model_User_Account(int userID, String userName, String fullName, String address, String dob, String gender, String email, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }
    
    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            userID = obj.getInt("userID");
            userName = obj.getString("userName");
            fullName = obj.getString("fullName");
            address = obj.getString("address");
            dob = obj.getString("dob");
            gender = obj.getString("gender");
            email = obj.getString("email");
            status = obj.getBoolean("status");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
    
    private int userID;
    private String userName;
    private String fullName;
    private String address;
    private String dob;
    private String gender;
    private String email;
    private boolean status;
}
