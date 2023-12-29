/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.event;

import com.raven.model.Model_User_Account;
import com.raven.model.Model_friendship_status;
import java.util.List;

/**
 *
 * @author vochanhtin139
 */
public interface EventMenuRight {

    public void getListFriend(List<Model_User_Account> users);
    
    public void getFriendshipStatus(List<Model_friendship_status> relationships);
    
    public void getYourFriendList(List<Model_User_Account> users);
    
    public void getYourBlockedList(List<Model_User_Account> users);
    
    public void getSearchedUser(List<Model_User_Account> users);
}