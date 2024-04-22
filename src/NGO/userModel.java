/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO;

import User.*;
import java.util.Date;

/**
 *
 * @author CSC
 */
class user_Model {
    
    String username;
    String password;
    String emailId;
    String Date;
    String Id;
   
    
    public user_Model(String username, String password,String emailId,String Id) {
        this.username = username;
        this.password = password;
        this.emailId=emailId;
        this.Id=Id;
    }
    
    public user_Model(String username, String log_password) {
        this.username = username;
        this.password = log_password;
       
    }
    
    public user_Model(String email,String username,String password)
    {
        this.emailId=email;
        this.password=password;
        this.username=username;
    }
    
    public void set_username(String username){
       this.username = username;
   }
   
   public void set_password (String password){
       this.password = password;
   }
   
   public void set_email (String emailId){
       this.emailId = emailId;
   }
   
   public void setRegDate (){
        Date date = new Date();
       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      this.Date=String.valueOf(sqlDate);
   }
   
   public void set_Id (String Id){
        this.Id = Id;
   }
   
   public String getUsername(){
       return username;
   }
   
   public String getPassword(){
       return password;
   }
    
    public String getemailId(){
       return emailId;
   }
   
   public String getCurDate(){
       return Date;
   }
   
   public String getId()
   {
       return Id;
   }
    
}
