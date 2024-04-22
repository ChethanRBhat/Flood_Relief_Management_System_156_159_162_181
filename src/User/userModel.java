/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import java.util.Date;
import java.sql.ResultSet;
/**
 *
 * @author CSC
 */
public class userModel {
    
     String username;
    String password;
    String emailId;
    String Date;
    String Id;
    ResultSet result;
    
    
   
    
    public userModel(String username, String password,String emailId,String Id) {
        this.username = username;
        this.password = password;
        this.emailId=emailId;
        this.Id=Id;
    }
    
    public userModel(String log_username, String log_password) {
        this.username = log_username; //changed from username
        this.password = log_password;
       
    }
    
    public userModel(String email,String username,String password)
    {
        this.emailId=email;
        this.password=password;
        this.username=username;
    }

    public userModel() {
       //
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

    ResultSet logInPerformed() {
        DB dbreq = new DB();
        result = dbreq.process_log(getUsername(),getPassword());
        return result;
    }
    
    int signUpPerformed() {
        DB dbreq = new DB();
        int code=1;
        try{
           dbreq.process_reg(getemailId(), getUsername(),getPassword(),getCurDate());
        }
        catch(Exception e)
        {
            System.out.println(e);
            code=0;
        }
        return code;
    }

    ResultSet checkExistingUsername() {
       DB dbreq = new DB();
       result = dbreq.checkExistUsername(getUsername());
       return result;
    }
    
}
