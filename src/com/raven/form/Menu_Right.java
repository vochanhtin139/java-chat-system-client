
package com.raven.form;

import com.raven.component.item_People;
import com.raven.component.item_People1;
import com.raven.component.item_People_Friend;
import com.raven.event.EventMenuLeft;
import com.raven.event.EventMenuRight;
import com.raven.event.PublicEvent;
import com.raven.model.Model_User_Account;
import com.raven.model.Model_friendship_status;
import com.raven.service.Service;
import com.raven.swing.ScrollBar;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author vochanhtin139
 */
public class Menu_Right extends javax.swing.JPanel {

    
    private List<Model_User_Account> userAccount;
    private List<Model_User_Account> accounts;
    private List<Model_User_Account> myFriendList;
    private List<Model_User_Account> myBlockedList;
    private List<Model_User_Account> mySearchedList;
    private List<Model_friendship_status> relationshipStatus;
    private String state = "";

    /**
     * Creates new form Menu_Left
     */
    public Menu_Right() {
        initComponents();
        
        state = "user";
        
        txtSearchField.setHintText("search for username or name...");
//        txtSearchField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent ke) {      
////                if (ke.getKeyChar() == 10) {
////                    
////                }
//                String searchText = txtSearchField.getText();
//                System.out.println(searchText);
//                Service.getInstance().getClient().emit("search_user", searchText);
//            }
//        });
        
        txtSearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearch();
            }

            private void updateSearch() {
                String searchText = txtSearchField.getText();
                
                if (searchText.trim().equals("")) {
                    if (state.equals("user")) {
                        showMessage();
                    }
                    else if (state.equals("friend")) {
                        showGroup();
                    }
                    else if (state.equals("block")) {
                        showBox();
                    }
                }
                else
                    // Use searchText or send it to the server
                    Service.getInstance().getClient().emit("search_user", searchText);
            }
        });
        
        sp.setVerticalScrollBar(new ScrollBar());
//        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    menuList.setLayout(new MigLayout("fillx"));
        userAccount = new ArrayList<>();
        
        PublicEvent.getInstance().addEventMenuRight(new EventMenuRight() {
            @Override
            public void getListFriend(List<Model_User_Account> users) {
                accounts = users;
            }

            @Override
            public void getFriendshipStatus(List<Model_friendship_status> relationships) {
                relationshipStatus = relationships;
                
                for (Model_User_Account d : accounts) {
                    String tmp = "Add friend";
                  
                    userAccount.add(d);
                    
                    
                    for (Model_friendship_status status : relationships) {
                        if (status.getUserID1() == Service.getInstance().getUser().getUserID() && status.getUserID2() == d.getUserID() && status.getStatus().equals("Pending")) {
                            tmp = "Cancel request";
                            break;
                        }
                        
                        if (status.getUserID1() == d.getUserID() && status.getUserID2() == Service.getInstance().getUser().getUserID() && status.getStatus().equals("Pending")) {
                            tmp = "Accept friend";
                            break;
                        }
                    }
                    
                    menuList.add(new item_People1(d, tmp), "wrap");
                    refreshMenuList();
                }
            }

            @Override
            public void getYourFriendList(List<Model_User_Account> users) {
                myFriendList = users;
            }

            @Override
            public void getYourBlockedList(List<Model_User_Account> users) {
                myBlockedList = users;
            }

            @Override
            public void getSearchedUser(List<Model_User_Account> users) {
                menuList.removeAll();
                
                for (Model_User_Account d : users) {
                    System.out.println(d.getUserName());
                    menuList.add(new item_People(d), "wrap");
                }
                    
                
                refreshMenuList();
            }
        
        });
    }
    
    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }
    
    private void showMessage() {
        //  test data
//        menuList.removeAll();
//        for (Model_User_Account d : userAccount) {
//            menuList.add(new item_People(null), "wrap");
//        }
//        refreshMenuList();

        menuList.removeAll();
        
        for (Model_User_Account d : accounts) {
            String tmp = "Add friend";

            userAccount.add(d);


            for (Model_friendship_status status : relationshipStatus) {
                if (status.getUserID1() == Service.getInstance().getUser().getUserID() && status.getUserID2() == d.getUserID() && status.getStatus().equals("Pending")) {
                    tmp = "Cancel request";
                    break;
                }

                if (status.getUserID1() == d.getUserID() && status.getUserID2() == Service.getInstance().getUser().getUserID() && status.getStatus().equals("Pending")) {
                    tmp = "Accept friend";
                    break;
                }
            }

            menuList.add(new item_People1(d, tmp), "wrap");

        }
        
        refreshMenuList();
    }

    private void showGroup() {
        //  test data
//        menuList.removeAll();
//        for (int i = 0; i < 5; i++) {
//            menuList.add(new item_People(null), "wrap");
//        }
//        refreshMenuList();

        menuList.removeAll();
        for (Model_User_Account d : myFriendList) {
            menuList.add(new item_People_Friend(d), "wrap");
//            menuList.add(new item_People(d, "Block"), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        //  test data
        menuList.removeAll();
        for (Model_User_Account d : myBlockedList) {
            menuList.add(new item_People(d), "wrap");
        }
        refreshMenuList();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.raven.component.MenuButton();
        menuGroup = new com.raven.component.MenuButton();
        menuBox = new com.raven.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSearchField = new com.raven.swing.JIMSendTextPane();

        setBackground(new java.awt.Color(230, 230, 230));

        jLabel1.setText("Menu Left note");

        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/message_selected.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/message.png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/group.png"))); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/group_selected.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/group.png"))); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/box.png"))); // NOI18N
        menuBox.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/box_selected.png"))); // NOI18N
        menuBox.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/box.png"))); // NOI18N
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        sp.setBorder(null);

        menuList.setBackground(new java.awt.Color(230, 230, 230));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        jScrollPane1.setViewportView(txtSearchField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 91, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 92, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 396, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 396, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            menuGroup.setSelected(false);
            menuBox.setSelected(false);
            showMessage();
            state = "user";
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        if (!menuGroup.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(true);
            menuBox.setSelected(false);
            showGroup();
            state = "friend";
        }
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
        if (!menuBox.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(false);
            menuBox.setSelected(true);
            showBox();
            state = "block";
        }
    }//GEN-LAST:event_menuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane menu;
    private com.raven.component.MenuButton menuBox;
    private com.raven.component.MenuButton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private com.raven.component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    private com.raven.swing.JIMSendTextPane txtSearchField;
    // End of variables declaration//GEN-END:variables
}
