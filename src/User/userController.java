/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;
import Landing.LandingPage;
import UserRequest.userPage;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CSC
 */
public class userController {
    
      private ResultSet result ;
      loginForm logForm;
      registerForm regForm;
      userModel model;
//      userModel model2;
      
    public userController(userModel model) {
        this.model=model; 
        //model = m;
//        initModel();
        //initRegisterView();
    }

    
    private void initModel()
    {
        model = new userModel();
    }
    
    private void initRegisterView() {
        regForm = new registerForm();
        //NGO.Donator.MoneyPage fi1 = new NGO.Donator.MoneyPage();
        regForm.setFocusable(true);
        regForm.show();
    }
    
    private void initLogView() {
        logForm = new loginForm();
        //NGO.Donator.MoneyPage fi1 = new NGO.Donator.MoneyPage();
        logForm.setFocusable(true);
        logForm.show();
    }
    
    private void disposeLogPage() {
        
        logForm.dispose();
    }
    
    private void alreadyRegistered() {
        initRegisterView();
        disposeLogPage();
    }
    
    private void disposeRegPage() {
        regForm.dispose();
    }
    
    
    private void cancelSignUp() {
          // TODO add your handling code here:
        LandingPage lPage = new LandingPage();
        lPage.setFocusable(true);
        lPage.show();
        disposeRegPage();
    }
    
    
    public void initRegController() {
        initRegisterView();
        System.out.println("hello");
        regForm.reg_createBtn.addActionListener(e->processSignUp());
       
    }
    
    public void initLogController() {
        initLogView();
        
        logForm.log_Btn.addActionListener(e->process_log());
       
    }
    
    public boolean process_log(){
       System.out.println("baahubali");
//       model.set_username(logForm.log_username.getText());
//       model.set_password(logForm.log_password.getText());
       DB dbreq = new DB();
        String query = "Select id from user where username=? and password=?";
        System.out.println("baahubali2");
          try {
                 if(model.getUsername().isEmpty() || model.getPassword().isEmpty())
                 {
                   JOptionPane.showMessageDialog(null,"Incorrect Username/Password999","Error Message",JOptionPane.ERROR_MESSAGE);
                 }
                 else
                 {
                   result = dbreq.process_log(model.getUsername(),model.getPassword());
//                   result = model.logInPerformed();
                   if(result.next())
                   {
                      JOptionPane.showMessageDialog(null,"Successfully Login!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                      userPage uPage = new userPage(result.getString("id"));
                      uPage.setFocusable(true);
                      uPage.show();
//                      disposeLogPage();   
                      return true;
    
                   }
                   else
                   {
                      JOptionPane.showMessageDialog(null,"Incorrect Username/Password","Error Message",JOptionPane.ERROR_MESSAGE);
                    }
                  }
               } catch (SQLException ex) {
                   System.out.println(ex);
               }
          return false;
    }

    public void clearFields()
    {
        regForm.reg_emailAddress.setText("");
        regForm.reg_username.setText("");
        regForm.reg_password.setText("");
    }
    
    
    
     public void processSignUp(){
       
       model.set_email(regForm.reg_emailAddress.getText());
       model.set_username(regForm.reg_username.getText());
       model.set_password(regForm.reg_password.getText());
        
        
        
        
          try {
               if(model.getemailId().isEmpty() || model.getUsername().isEmpty() || model.getPassword().isEmpty())
               {
                    JOptionPane.showMessageDialog(null,"Please fill all blank fields","Error Message",JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                  // result = dbreq.checkExistUsername(model.getUsername(),checkUsername);
                   result= model.checkExistingUsername();
                   if(result.next())
                   {
                        JOptionPane.showMessageDialog(null,model.getUsername()+"was already taken","Error Message",JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                       model.setRegDate();
                       model.signUpPerformed();
                       JOptionPane.showMessageDialog(null,"Successfully created a new Account!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                       initLogController();
                       disposeRegPage();
                       
                   }
                   
                }
              
          } catch (SQLException ex) {
              clearFields();
              System.out.println(ex);
          }
          
    }
     
    public ResultSet showUser(){
        DB dbreq = new DB(); 
    try{
      
        result=dbreq.showUser();
        return result;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return null;
    }

    

    
}
