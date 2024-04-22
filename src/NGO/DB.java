/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO;
import User.*;
import databaseConnection.database;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author CSC
 */
class DB {
    
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    
    public ResultSet process_log(String username,String password,String query){
         System.out.println("hello_outer_try_catch");
        try {
             System.out.println("hello_before_connect");
            connect = database.connectDB();
             System.out.println("hello_after_connect");
            prepare = connect.prepareStatement(query);
            prepare.setString(1,username);
            prepare.setString(2,password);
            result = prepare.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         System.out.println("hello_before_return");
        return result;
    }

    ResultSet process_reg(String name, String password, String email, String contact, byte[] fileContent,String address,String insertData) {
        connect = database.connectDB();
        try{
            prepare = connect.prepareStatement(insertData);
            prepare.setString(1,name);
            prepare.setString(2,email);
            prepare.setString(3,password);
            prepare.setString(4,contact);
            prepare.setBytes(5, fileContent);
            prepare.setString(6,address);
            prepare.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }

    ResultSet checkExistUsername(String email, String checkUsername) {
         connect = database.connectDB();
        try {
            prepare = connect.prepareStatement(checkUsername);
            prepare.setString(1,email);
            result = prepare.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
        
    }
    
}
