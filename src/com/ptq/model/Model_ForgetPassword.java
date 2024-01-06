
package com.ptq.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author quynhphan
 */
public class Model_ForgetPassword {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Model_ForgetPassword(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public Model_ForgetPassword() {
        
    }
    
    private String userName;
    private String password;
    
    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("userName", userName);
            json.put("password", password);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }

//    public Object[] toJsonObject() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
