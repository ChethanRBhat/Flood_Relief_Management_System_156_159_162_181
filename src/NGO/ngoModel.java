/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author CSC
 */
class ngoModel {

    private  String ngoName;
    private  String ngoEmail;
    private  String ngoContact;
    private  String ngoPassword;
    private  String ngoAddress;
    private  String idProofPath;

    ngoModel(String ngoName, String ngoEmail, String ngoContact, String ngoPassword, String ngoAddress, String idProofPath) {
        this.ngoName=ngoName;
        this.ngoEmail=ngoEmail;
        this.ngoContact=ngoContact;
        this.ngoPassword=ngoPassword;
        this.ngoAddress=ngoAddress;
        this.idProofPath=idProofPath;
    }

    ngoModel(String ngoEmail, String ngoPassword) {
        this.ngoEmail=ngoEmail;
        this.ngoPassword=ngoPassword;
    }

    ngoModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setName(String name)
    {
        this.ngoName=name;
    }
    public void setPassword(String password)
    {
        this.ngoPassword=password;
    }
    public void setContact(String contact)
    {
        this.ngoContact=contact;
    }
    public void setEmail(String email)
    {
        this.ngoEmail=email;
    }
    public void setAddress(String address)
    {
        this.ngoAddress=address;
    }
    public void setpath(String path)
    {
        this.idProofPath=path;
    }
    
    
    public String getName()
    {
        return this.ngoName;
    }
    public String getPassword()
    {
        return this.ngoPassword;
    }
    public String getContact()
    {
        return this.ngoContact;
    }
    public String getEmail()
    {
        return this.ngoEmail;
    }
    public String getAddress()
    {
        return this.ngoAddress;
    }
    public String getpath() throws IOException
    {
        return this.idProofPath;
    }

    public byte[] getFile() throws IOException {
       Path path = Paths.get(this.idProofPath);
        byte[] data = Files.readAllBytes(path);
        return data;
    }
    
}
