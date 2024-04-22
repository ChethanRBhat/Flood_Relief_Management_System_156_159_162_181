/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO.Donator;

import databaseConnection.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    void processTransaction(String orgaization, String name, String amount,String phoneNumber) {
       connect = database.connectDB();
        String insertData = "INSERT INTO moneyDonation (organizationId,name,amount,ph_no) "+"VALUES(?,?,?,?)";
        try{
            prepare = connect.prepareStatement(insertData);
            prepare.setString(1,orgaization);
            prepare.setString(2,name);
            prepare.setString(3,amount);
            prepare.setString(4,phoneNumber);
            prepare.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    ResultSet showReq() {
        String selectData = "SELECT id,name from ngo";
       connect = database.connectDB();
          try {
              
              prepare = connect.prepareStatement(selectData);
              result = prepare.executeQuery();
              return result;
          } catch (Exception ex) {
             System.out.println(ex);
          }
        return null;
    }
    
    ResultSet showDonator(String orgId) {
        String selectData = "SELECT name,amount,ph_no from moneydonation where organizationId=?";
       connect = database.connectDB();
          try {
              
              prepare = connect.prepareStatement(selectData);
              prepare.setString(1,orgId);
              result = prepare.executeQuery();
              return result;
          } catch (Exception ex) {
             System.out.println(ex);
          }
        return null;
    }
}
