package com.ptq.service;

import com.ptq.event.PublicEvent;
import com.ptq.model.Model_Receive_Message;
import com.ptq.model.Model_User_Account;
import com.ptq.model.Model_conversation;
import com.ptq.model.Model_friendship_status;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private Model_User_Account user;
    private List<Model_User_Account> reportSpamList;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                            System.out.println("Username: " + u.getUserName());
                            System.out.println("Active: "+ u.isStatus());
                        }
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            
            client.on("list_friend", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                            System.out.println("Username: " + u.getUserName());
                            System.out.println("Active: "+ u.isStatus());
                        }
                    }
                    PublicEvent.getInstance().getEventMenuRight().getListFriend(users);
                }
            });
            
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (Boolean) os[1];
                    if (status) {
                        //  connect
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                    } else {
                        //  disconnect
                        PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_Receive_Message message = new Model_Receive_Message(os[0]);
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }
            });
            
            client.on("receive_conversation_message", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    List<Model_conversation> msg = new ArrayList<>();
                    for (Object o : os) {
                        Model_conversation u = new Model_conversation(o);
                        msg.add(u);
                    }
                    PublicEvent.getInstance().getEventChat().getConversationMessage(msg);
                }
            });
            
            client.on("receive_list_friend_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    List<Model_friendship_status> msg = new ArrayList<>();
                    for (Object o : os) {
                        Model_friendship_status u = new Model_friendship_status(o);
                        System.out.println(u.getFriendshipID());
                        System.out.println(u.getUserID1());
                        System.out.println(u.getUserID2());
                        System.out.println(u.getStatus());
                        System.out.println(u.getTime());
                        msg.add(u);
                    }
                    PublicEvent.getInstance().getEventMenuRight().getFriendshipStatus(msg);
                }
            });
            
            client.on("received_your_friend_list", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                            System.out.println("Username: " + u.getUserName());
                            System.out.println("Active: "+ u.isStatus());
                        }
                    }
                    PublicEvent.getInstance().getEventMenuRight().getYourFriendList(users);
                }
            });
           
            client.on("received_your_blocked_list", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                            System.out.println("Username: " + u.getUserName());
                            System.out.println("Active: "+ u.isStatus());
                        }
                    }
                    PublicEvent.getInstance().getEventMenuRight().getYourBlockedList(users);
                }
            });
            
            client.on("received_searched_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    System.out.println("RECEIVED SEARCHED!!!");
                    //  list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                            System.out.println("Username: " + u.getUserName());
                            System.out.println("Active: "+ u.isStatus());
                        }
                    }
                    PublicEvent.getInstance().getEventMenuRight().getSearchedUser(users);
                }
            });
            
            client.on("received_spam_report_list", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) 
                            users.add(u);        
                    }
//                    PublicEvent.getInstance().getEventChatTitle().checkSpamList(users);
                    Service.getInstance().setSpamList(users);
                }
            });
            
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }

    public Socket getClient() {
        return client;
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
    public void setSpamList(List<Model_User_Account> users) {
        this.reportSpamList = users;
    }
    
    public List<Model_User_Account> getSpamList() {
        return this.reportSpamList;
    }

    private void error(Exception e) {
        System.err.println(e);
    }
}