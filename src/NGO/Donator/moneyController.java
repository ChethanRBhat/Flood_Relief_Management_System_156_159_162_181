/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO.Donator;


import Landing.LandingPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CSC
 */
public class moneyController {
    private ResultSet result;
    private  moneyModel model;
    
    public moneyController(moneyModel model)
    {
        this.model=model;
    }
    
    public boolean processTransaction(){
        DB dbreq = new DB();
       
        
          try {
               if(model.getOrgaization().isEmpty() || model.getName().isEmpty() || model.getAmount().isEmpty()||model.getPhoneNumber().isEmpty())
               {
                    JOptionPane.showMessageDialog(null,"Please fill all blank fields","Error Message",JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                   
                       dbreq.processTransaction(model.getOrgaization(),model.getName(),model.getAmount(),model.getPhoneNumber());
                       JOptionPane.showMessageDialog(null,"Successfully Donated Account,Thank You!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                       LandingPage dPage = new LandingPage();
                       dPage.setFocusable(true);
                       dPage.show();
                       return true;
                }  
              
          } catch (Exception ex) {
              System.out.println(ex);
          }
          return false;
    }

    public ResultSet showOrganization() {
        DB dbreq = new DB();
      
    
        
    
   
    
    try{
      
        result=dbreq.showReq();
        return result;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return null;
    }

    public ResultSet showDonator() {
        DB dbreq = new DB();
    try{
        result=dbreq.showDonator(model.getOrgaization());
        return result;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return null;
    }
    
 
}
