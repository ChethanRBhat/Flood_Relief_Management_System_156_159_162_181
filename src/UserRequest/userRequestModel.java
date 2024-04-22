/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserRequest;

import java.util.Date;

/**
 *
 * @author CSC
 */
public class userRequestModel {
    
    String fullname;
    String mobno;
    String age;
    String gender;
    String location;
    String Date;
    String userId;
    String id;
    String reqStatus;
    String reqDate;
    String reqTime;

    public userRequestModel(String fullname, String mobno, String age, String gender, String location, String userId) {
        this.fullname=fullname;
        this.mobno=mobno;
        this.age=age;
        this.gender=gender;
        this.location=location;
        this.userId=userId;
    }

    public userRequestModel(String reqStatus) {
        this.reqStatus=reqStatus;
    }

    public userRequestModel() {
        
    }

    

    
    
    public void setStatus(String reqStatus)
    {
        this.reqStatus=reqStatus;
    }
    
    public String getStatus()
    {
        return reqStatus;
    }
    
     public void setFullname(String fullname){
       this.fullname = fullname;
   }
   
   public void setMobno (String mobno){
       this.mobno = mobno;
   }
   
   public void setId (String id){
       this.id = id ;
   }
   
   public void setAge (String age){
       this.age = age;
   }
   
   public void setRegDate (){
      java.util.Date date = new Date();
      java.sql.Timestamp param = new java.sql.Timestamp(date.getTime());
      this.Date=String.valueOf(param);
   }
   
   public void setGender (String gender){
        this.gender = gender;
   }
   
   public void setLocation (String location){
        this.location = location;
   }
   
   public void setUserId(String userId)
   {
       this.userId=userId;
   }
   
   public String getUserId()
   {
       return userId;
   }
   
   public String getFullname(){
       return fullname;
   }
   
   public String getMobno(){
       return mobno;
   }
    
    public String getAge(){
       return age;
   }
    
    public String getTimestamp()
    {
        return Date;
    }
   
   public String getGender(){
       return gender;
   }
   
   public String getLocation()
   {
       return location;
   }
   
   public String getId()
   {
       return id;
   }

    public String getDate() {
        return this.reqDate;
    }

   

    public String getTime() {
        return this.reqTime;
    }

    void setDate(String reqDate) {
        this.reqDate=reqDate;
    }

    void setTime(String reqTime) {
        this.reqTime=reqTime;
    }
}
