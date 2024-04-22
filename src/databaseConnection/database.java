/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseConnection;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author CSC
 */
public class database {
    public static Connection connectDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded11111");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_proj_1","root","");
            System.out.println("Connection Established");
            return con;
        }catch(Exception e){e.printStackTrace();}
        return null;
        
        
    }
}
