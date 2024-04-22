/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserRequest;

import databaseConnection.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CSC
 */
class DB {
      private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    
    void addReq(String fullname, String mobno, String age, String gender, String location,String timestamp,String userId,String insertData) {
        connect = database.connectDB();
          try {
              prepare = connect.prepareStatement(insertData);
              prepare.setString(1,fullname);
              prepare.setString(2,age);
              prepare.setString(3,gender);
              prepare.setString(4,location);
              prepare.setString(5,String.valueOf(timestamp));
              //int user_id = Integer.parseInt(logged_username);
              prepare.setString(6,userId);
              prepare.setString(7,mobno);
              prepare.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
    }
    
     ResultSet getUserRequest(int index,String getReqQuery) {
        connect = database.connectDB();
        try {
            prepare = connect.prepareStatement(getReqQuery);
            prepare.setString(1,Integer.toString(index));
            result = prepare.executeQuery();
            return result;
        } catch (Exception ex) {
            System.out.println(ex);
        }
       return null;
        
    }
     
     
     void updateReq(String fullname, String mobno, String age, String gender, String location,String timestamp,String reqId,String updateData) {
        connect = database.connectDB();
          try {
              prepare = connect.prepareStatement(updateData);
              prepare.setString(1,fullname);
               prepare.setString(2,gender);
               prepare.setString(3,String.valueOf(timestamp));
              prepare.setString(4,age);
              prepare.setString(5,location);
              
              //int user_id = Integer.parseInt(logged_username);
              prepare.setString(6,mobno);
              prepare.setString(7,reqId);
              prepare.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
    }

    ResultSet showReq(String selectData, String userId) {
       connect = database.connectDB();
          try {
              
              prepare = connect.prepareStatement(selectData);
              prepare.setString(1,userId);
              result = prepare.executeQuery();
              return result;
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        return null;
    }

    void deleteReq(String id, String deleteData) {
          connect = database.connectDB();
          try {
              prepare = connect.prepareStatement(deleteData);
              prepare.setString(1,id);
              prepare.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
       
    }

    ResultSet showReqGovt( String request_status) {
        String selectData = "SELECT id,location,full_name,DATE(date_time) as date,TIME(date_time) as time,mob_no from user_request where request_status=?";
        connect = database.connectDB();
          try {
              
              prepare = connect.prepareStatement(selectData);
              prepare.setString(1,request_status);
              result = prepare.executeQuery();
              return result;
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        return null;
    }
     
     
     
     
    
}
