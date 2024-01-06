package com.ptq.event;

import com.ptq.model.Model_Login;
import com.ptq.model.Model_Register;
import com.ptq.model.Model_ForgetPassword;

public interface EventLogin {

    public void login(Model_Login data);

    public void register(Model_Register data, EventMessage message);
    
    public void forgetPassword(Model_ForgetPassword data, EventMessage message);

    public void goRegister();

    public void goLogin();    
    
    public void goForgetPassword();
}