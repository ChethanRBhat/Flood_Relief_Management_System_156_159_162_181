/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserRequest;
import databaseConnection.database;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author CSC
 */
public class userController {
    private ResultSet result ;
    userRequestModel model;
    public userController(userRequestModel model) {
        this.model = model;
    }
    
    public boolean addEvacReq(){
        DB dbreq = new DB();
        String insertData = "INSERT into user_request (full_name,age,gender,location,date_time,user_id,mob_no)"+"values (?,?,?,?,?,?,?)";
        System.out.println("hello");
          try {
                 if(model.getFullname().isEmpty()|| model.getMobno().isEmpty()||model.getAge().isEmpty()|| model.getGender().isEmpty() || model.getLocation().isEmpty())
                 {
                    JOptionPane.showMessageDialog(null,"Please fill all necessary information","Error Message",JOptionPane.ERROR_MESSAGE);
                 }
                 else
                 {
                    
                   model.setRegDate();
                   dbreq.addReq(model.getFullname(),model.getMobno(),model.getAge(),model.getGender(),model.getLocation(), model.getTimestamp(),model.getUserId(),insertData);
                   JOptionPane.showMessageDialog(null,"Successfully sent the Request","inforamtion message",JOptionPane.INFORMATION_MESSAGE);
                   return true;
                  }
               } 
          catch(HeadlessException e){
            System.out.println(e);
          }
           return false;
    }
    
    
     public void fillReqTable(int index){
         String selectData = "SELECT * from user_request where id=?";
        DB dbreq = new DB();
        System.out.println("********Index:"+index);
        
              result= dbreq.getUserRequest(index,selectData);
              System.out.println("********result:"+result);
             try {
                 while(result.next())
                 {
                     System.out.println("********result.getString(2):"+result.getString(2));
                     model.setFullname(result.getString(2));
                     System.out.println("********result.getString(2):"+result.getString(2));
                     model.setLocation(result.getString(5));
                      System.out.println("********result.getString(9):"+result.getString(9));
                     model.setMobno(result.getString(9));
                      System.out.println("********result.getString(3):"+result.getString(3));
                     model.setAge(result.getString(3));
                      System.out.println("********result.getString(4):"+result.getString(4));
                     model.setGender(result.getString(4));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
     
     
    public boolean updateEvacReq(String reqId){
        DB dbreq = new DB();
        String updateData = "UPDATE user_request SET full_name = ? ,gender = ?,date_time=?,age=?,location=?,mob_no=? WHERE id = ?";
        System.out.println("hello");
       try
        {
            System.out.println("hello_in_try");
            if(model.getFullname().isEmpty()|| model.getMobno().isEmpty()||model.getAge().isEmpty()|| model.getGender().isEmpty()|| model.getLocation().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill all necessary information","Error Message",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                System.out.println("hello_in_else");
                int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to update Request","Confirmation Message",JOptionPane.YES_NO_OPTION);
                System.out.println("hello_after_message");
                if(option == JOptionPane.YES_OPTION)
                {
                    model.setRegDate();
                    dbreq.updateReq(model.getFullname(), model.getMobno(), model.getAge(), model.getGender(), model.getLocation(),model.getTimestamp(),reqId,updateData);
                     JOptionPane.showMessageDialog(null,"Successfully updated the Request","inforamtion message",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please fill all necessary information","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Could not update Request,Try again","Error Message",JOptionPane.ERROR_MESSAGE);
        }
           return false;
    }
    
    
    public ResultSet showEvacReq(){
        DB dbreq = new DB();
      
    
    String selectData = "SELECT id,location,DATE(date_time) as date,TIME(date_time) as time,request_status from user_request where user_id=?";
    
   
    
    try{
      
        result=dbreq.showReq(selectData,model.getUserId());
        return result;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return null;
    }
    
    public ResultSet showEvacReqGovt(){
        DB dbreq = new DB();
        try{
            result=dbreq.showReqGovt(model.getStatus());
            return result;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteRequest() {
        
        DB dbreq = new DB();
        String deleteData= "delete from user_request where id =?";
        System.out.println("hello");
       try
        {
             System.out.println("hello_in_else");
                int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete Request","Confirmation Message",JOptionPane.YES_NO_OPTION);
                System.out.println("hello_after_message");
                if(option == JOptionPane.YES_OPTION)
                {
                   
                    dbreq.deleteReq(model.getId(),deleteData);
                     JOptionPane.showMessageDialog(null,"Successfully deleted the Request","inforamtion message",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please fill all necessary information","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Could not delete Request,Try again","Error Message",JOptionPane.ERROR_MESSAGE);
        }
           return false;
    }
     
}
