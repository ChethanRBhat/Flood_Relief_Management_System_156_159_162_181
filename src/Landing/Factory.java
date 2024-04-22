package Landing;

import Govt.Official.*;
import User.*;
import NGO.Donator.*;
import NGO.*;

public class Factory {
    public static void init_type(int usertype){
        System.out.println("UserType****"+usertype);
        switch(usertype){
            case 1: {
                
                 System.out.println("hello user");
                 User.userModel kmodel = new User.userModel();
                 User.userController uCont = new User.userController(kmodel);
                 uCont.initRegController();
                //NGO.Donator.MoneyPage fi1 = new NGO.Donator.MoneyPage();
                //fi1.setFocusable(true);
                //fi1.show();
                
                break;
            }
            case 2: {
                 System.out.println("hello donation");
                NGO.Donator.MoneyPage fi1 = new NGO.Donator.MoneyPage();
                fi1.setFocusable(true);
                fi1.show();
                break;
            }
            case 3: {
                 System.out.println("hello govt");
                 /*NGO.Donator.MoneyPage fi1 = new NGO.Donator.MoneyPage();
                 fi1.setFocusable(true);
                fi1.show();*/
               Govt.Official.loginForm fi1 = new Govt.Official.loginForm();
              fi1.setFocusable(true);
                fi1.show();
                break;
            }
            case 4: {
                 System.out.println("hello ngo");
                NGO.registerForm fi1 = new NGO.registerForm();
                fi1.setFocusable(true);
                fi1.show();
                break;
            }
            default: ;
            
        }
        
    }
}
