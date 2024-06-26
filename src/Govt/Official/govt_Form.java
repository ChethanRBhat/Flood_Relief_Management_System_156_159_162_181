/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Govt.Official;

import User.userModel;
import databaseConnection.database;
import User.userController;
//import UserRequest.UserController;
import UserRequest.userRequestModel;
import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author CSC
 */
public class govt_Form extends javax.swing.JFrame {

    private static govt_Form instance;
    
    private govt_Form()
  {
    initComponents();
        
        setLocationRelativeTo(null);
        show_user_request();
        showUser();
  }
    
    public static govt_Form getInstance()
  {
    if (instance == null)
    {
      //synchronized block to remove overhead
      synchronized (govt_Form.class)
      {
        if(instance==null)
        {
          // if instance is null, initialize
          instance = new govt_Form();
        }
       
      }
    }
    return instance;
  }
    
    private static class Request_status extends JComboBox{
        Request_status()
        {
            addItem("Pending");
            addItem("Accept");
            addItem("Reject");
        }
    }
      
    private Connection connect;
    private PreparedStatement prepare;
    private  ResultSet result;
    
    
    public void showUser(){
    userModel model = new userModel();
    User.userController cont = new User.userController(model);
    DefaultTableModel userTableModel = (DefaultTableModel)userTable.getModel();
    userTableModel.setRowCount(0);
    try{
        result=cont.showUser();
       
        while(result.next())
        {
            String rows[] = {result.getString("id"),result.getString("email"),result.getString("username"),result.getString("date")};
            
            userTableModel.addRow(rows);
        }
        System.out.println(userTableModel.getRowCount());
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
    
    
    public void show_user_request(){
    String reqStatus=(String)reqStatusComboBox.getSelectedItem();
    UserRequest.userRequestModel model = new UserRequest.userRequestModel(reqStatus);
    UserRequest.userController cont = new UserRequest.userController(model);
    DefaultTableModel reqModel = (DefaultTableModel)admin_table2.getModel();
    try{
        result=cont.showEvacReqGovt();
        reqModel.setRowCount(0);
        while(result.next())
        {
            String rows[] = {result.getString("id"),result.getString("location"),result.getString("full_name"),result.getString("date"),result.getString("time"),result.getString("mob_no")};
            reqModel.addRow(rows);
        }
         TableColumn request_status_column = admin_table2.getColumnModel().getColumn(5);
         request_status_column.setCellEditor(new DefaultCellEditor(new Request_status()));
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        user_addBtn = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        user_logoutBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        navbar_username = new javax.swing.JLabel();
        user_logoutBtn2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        admin_table2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        req_id = new javax.swing.JTextField();
        req_status_combo_box = new javax.swing.JComboBox<>();
        submit_req_status_Btn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        reqStatusComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("jMenu3");

        user_addBtn.setBackground(new java.awt.Color(0, 102, 255));
        user_addBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user_addBtn.setForeground(new java.awt.Color(255, 255, 255));
        user_addBtn.setText("Add");
        user_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_addBtnActionPerformed(evt);
            }
        });

        user_logoutBtn.setBackground(new java.awt.Color(255, 0, 51));
        user_logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user_logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        user_logoutBtn.setText("Logout");
        user_logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_logoutBtnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 51, 204));

        jLabel2.setBackground(new java.awt.Color(102, 0, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Govt.Official DashBoard");

        navbar_username.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        navbar_username.setForeground(new java.awt.Color(255, 255, 255));

        user_logoutBtn2.setBackground(new java.awt.Color(255, 102, 102));
        user_logoutBtn2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user_logoutBtn2.setForeground(new java.awt.Color(255, 255, 255));
        user_logoutBtn2.setText("Logout");
        user_logoutBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_logoutBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navbar_username, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(user_logoutBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(navbar_username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user_logoutBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 102));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel13.setBackground(new java.awt.Color(153, 255, 204));

        admin_table2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        admin_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Location", "Name", "Date", "Time", "Mob.No"
            }
        ));
        admin_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(admin_table2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));

        req_status_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Accept", "Reject" }));

        submit_req_status_Btn.setBackground(new java.awt.Color(0, 153, 102));
        submit_req_status_Btn.setForeground(new java.awt.Color(255, 255, 255));
        submit_req_status_Btn.setText("Submit");
        submit_req_status_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_req_status_BtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Request Id:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(req_id, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(req_status_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(submit_req_status_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(submit_req_status_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(req_status_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(req_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reqStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accepted", "Pending", "Rejected" }));
        reqStatusComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                reqStatusComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(reqStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 346, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reqStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Process Pending Requests", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Email", "Username", "Date Of Registration"
            }
        ));
        jScrollPane2.setViewportView(userTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Users", jPanel1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Process Requests");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_addBtnActionPerformed
    
    }//GEN-LAST:event_user_addBtnActionPerformed

    private void user_logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_logoutBtnActionPerformed
        
    }//GEN-LAST:event_user_logoutBtnActionPerformed

    private void user_logoutBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_logoutBtn2ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?","Confirmation message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.YES_OPTION)
        {
            loginForm logForm = new loginForm();
            logForm.setFocusable(true);
            logForm.show();

            dispose();
        }
    }//GEN-LAST:event_user_logoutBtn2ActionPerformed

    private void submit_req_status_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_req_status_BtnActionPerformed
        // TODO add your handling code here:
        String request_status=(String)req_status_combo_box.getSelectedItem() + "ed";
        String user_request_id=req_id.getText();
        String update_request_status = "UPDATE user_request SET request_status='"+request_status+"' where id='"+user_request_id+"'";
        
        connect = database.connectDB();
        System.out.println("hello");
        try
        {
            System.out.println("hello_in_try");
            if(req_id.getText().isEmpty()||req_status_combo_box.getSelectedItem()==null)
            {
                JOptionPane.showMessageDialog(this,"Please fill all necessary information","Error Message",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to submit","Confirmation Message",JOptionPane.YES_NO_OPTION);
               
                if(option == JOptionPane.YES_OPTION)
                {
                     prepare = connect.prepareStatement(update_request_status);
                     prepare.executeUpdate();
                     JOptionPane.showMessageDialog(this,"Successfully Submitted the Response","inforamtion message",JOptionPane.INFORMATION_MESSAGE);
                    show_user_request();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please fill all necessary information","Error Message",JOptionPane.ERROR_MESSAGE);
                }
               
                

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Could not update Request,Try again","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submit_req_status_BtnActionPerformed

    private void reqStatusComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_reqStatusComboBoxItemStateChanged
        // TODO add your handling code here:
        show_user_request();
    }//GEN-LAST:event_reqStatusComboBoxItemStateChanged
    private String idNumber;
    private void admin_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_table2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel)admin_table2.getModel();
        int index  = admin_table2.getSelectedRow();
        idNumber = tableModel.getValueAt(index,0).toString();
        req_id.setText(idNumber);
    }//GEN-LAST:event_admin_table2MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(govt_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(govt_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(govt_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(govt_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new govt_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admin_table2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel navbar_username;
    private javax.swing.JComboBox<String> reqStatusComboBox;
    private javax.swing.JTextField req_id;
    private javax.swing.JComboBox<String> req_status_combo_box;
    private javax.swing.JToggleButton submit_req_status_Btn;
    private javax.swing.JTable userTable;
    private javax.swing.JButton user_addBtn;
    private javax.swing.JButton user_logoutBtn;
    private javax.swing.JButton user_logoutBtn2;
    // End of variables declaration//GEN-END:variables
}
