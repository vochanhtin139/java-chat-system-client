package com.raven.event;
import com.raven.model.Model_User_Account;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vochanhtin139
 */
public interface EventChatTitle {

    public void checkSpamList(List<Model_User_Account> users);
}