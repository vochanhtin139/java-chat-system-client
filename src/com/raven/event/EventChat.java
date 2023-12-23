package com.raven.event;

import com.raven.model.Model_Receive_Message;
import com.raven.model.Model_Send_Message;
import com.raven.model.Model_conversation;
import java.util.List;

public interface EventChat {

    public void sendMessage(Model_Send_Message data);

    public void receiveMessage(Model_Receive_Message data);
    
    public void getConversationMessage(List<Model_conversation> msg);
}