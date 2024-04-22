/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO;
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
class ngoController {
     private ResultSet result ;
      ngoModel model;
      
      public ngoController(ngoModel model){
        this.model=model; 
    }
      
    
     public boolean process_log(){
        DB dbreq = new DB();
        String query = "Select id from NGO where email=? and password=?";
        System.out.println("hello");
          try {
                 if(model.getEmail().isEmpty() || model.getPassword().isEmpty())
                 {
                   JOptionPane.showMessageDialog(null,"Please fill All Blank Fields","Error Message",JOptionPane.ERROR_MESSAGE);
                 }
                 else
                 {
                   result = dbreq.process_log(model.getEmail(),model.getPassword(),query);
                   if(result.next())
                   {
                      JOptionPane.showMessageDialog(null,"Successfully Login!","Inofrmation Message",JOptionPane.INFORMATION_MESSAGE);
                      ngoPage nPage = new ngoPage(result.getString("id"));
                      nPage.setFocusable(true);
                      nPage.show();
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
     

    public boolean processSignUp() throws IOException{
        DB dbreq = new DB();
        String insertData = "INSERT INTO ngo (name,email,password,contact,file,address) "+"VALUES(?,?,?,?,?,?)";
        String checkUsername = "SELECT email FROM ngo WHERE email = ?";
        
          try {
               if(model.getName().isEmpty() || model.getPassword().isEmpty() || model.getEmail().isEmpty() || model.getpath().isEmpty() || model.getpath()=="No Files Selected"|| model.getContact().isEmpty() || model.getAddress().isEmpty())
               {
                    JOptionPane.showMessageDialog(null,"Please fill all blank fields","Error Message",JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                   result = dbreq.checkExistUsername(model.getEmail(),checkUsername);
                   if(result.next())
                   {
                        JOptionPane.showMessageDialog(null,model.getEmail()+"was already taken","Error Message",JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                       dbreq.process_reg(model.getName(),model.getPassword(),model.getEmail(),model.getContact(),model.getFile(),model.getAddress(),insertData);
                       JOptionPane.showMessageDialog(null,"Successfully created a new NGO!","Information Message",JOptionPane.INFORMATION_MESSAGE);
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
