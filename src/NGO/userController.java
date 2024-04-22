/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO;
import User.*;
import UserRequest.userPage;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CSC
 */
class userController {
    
      private ResultSet result ;
      user_Model model;
      
    public userController(user_Model model){
        this.model=model; 
    }
    
    public boolean process_log(){
        User.DB dbreq = new User.DB();
        String query = "Select id from user where username=? and password=?";
        System.out.println("likhith");
          try {
                 if(model.getUsername().isEmpty() || model.getPassword().isEmpty())
                 {
                   JOptionPane.showMessageDialog(null,"Incorrect Username/Password","Error Message",JOptionPane.ERROR_MESSAGE);
                 }
                 else
                 {
                   result = dbreq.process_log(model.getUsername(),model.getPassword());
                   if(result.next())
                   {
                      JOptionPane.showMessageDialog(null,"Incorrect Username/Password","Error Message",JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                      JOptionPane.showMessageDialog(null,"Successfully Login!","Inofrmation Message",JOptionPane.INFORMATION_MESSAGE);
                      userPage uPage = new userPage(result.getString("id"));
                      uPage.setFocusable(true);
                      uPage.show();
                      return true;
                    }
                  }
               } catch (SQLException ex) {
                   System.out.println(ex);
               }
               return false;
    }


     public boolean processSignUp() throws IOException{
        User.DB dbreq = new User.DB();
        String insertData = "INSERT INTO user (email,username,password,date) "+"VALUES(?,?,?,?)";
        String checkUsername = "SELECT username FROM user WHERE username = ?";
        System.out.println("likhith");
        
          try {
               if(model.getemailId().isEmpty() || model.getUsername().isEmpty() || model.getPassword().isEmpty())
               {
                    JOptionPane.showMessageDialog(null,"Please fill all blank fields","Error Message",JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                   result = dbreq.checkExistUsername(model.getUsername());
                   if(result.next())
                   {
                        JOptionPane.showMessageDialog(null,model.getUsername()+"was already taken","Error Message",JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                       model.setRegDate();
                       dbreq.process_reg( model.getemailId(), model.getUsername(), model.getPassword(),model.getCurDate());
                       JOptionPane.showMessageDialog(null,"Successfully created a new Account!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                       loginForm lPage = new loginForm();
                       lPage.setFocusable(true);
                       lPage.show();
                       return true;
                   }
                   
                }
              
          } catch (SQLException ex) {
              System.out.println(ex);
          }
          return false;
    }
    
    
}
