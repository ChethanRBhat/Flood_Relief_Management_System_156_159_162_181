/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Govt.Official;
import databaseConnection.database;
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
    
    
    public ResultSet processLog(String username,String password){
         
        try {
            String selectData = "SELECT username FROM govt_official WHERE username=? and password = ?";
            connect = database.connectDB();
            prepare = connect.prepareStatement(selectData);
            prepare.setString(1,username);
            prepare.setString(2,password);
            result = prepare.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    
}
