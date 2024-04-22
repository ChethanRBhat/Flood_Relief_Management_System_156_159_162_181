/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO.Donator;

/**
 *
 * @author CSC
 */
public class moneyModel {

    private  String organization;
    private  String name;
    private  String amount;
    private String phoneNumber;
    
    public moneyModel(String organization, String name, String Amount, String phoneNumber)
    {
        this.organization=organization;
        this.name=name;
        this.amount=Amount;
        this.phoneNumber = phoneNumber;
    }

    
    public moneyModel(String organization) {
        this.organization=organization;
    }

    moneyModel() {
       
    }

   
    
     public void setOrgaization(String organization) {
       this.organization = organization;
    }

    public void  setName(String name) {
        this.name=name;
    }

    public void  setAmount(String amount) {
       this.amount=amount;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    public String getOrgaization() {
       return this.organization;
    }

    public String  getName() {
        return this.name;
    }

    public String  getAmount() {
       return this.amount;
    }
    
}
