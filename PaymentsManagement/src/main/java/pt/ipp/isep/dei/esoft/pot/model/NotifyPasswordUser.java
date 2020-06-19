/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.utils.NotifyUser;

/**
 *
 * @author Marcel
 */
public class NotifyPasswordUser{
    
    

    public SendEmail getEmailAPI() {
        return AplicacaoPOT.getInstance().getPlataforma().getEmailAPI();
    }



    public String writeEmail(String[] info) {
        return String.format("Hello %s,"
            + "\nCongratulations! You're registred at T4J payment management!"
            + "\n user: %s"
            + "\n password: %s"
            + "\n", info[0], info[1], info[2]);
    }



    public void notifyUser(String[] info) {
        List<String> email = new ArrayList();
        List<String> messages = new ArrayList();
        SendEmail api =  getEmailAPI();

            email.add(writeEmail(info));
            System.out.println(email);
        api.sendEmails(email, messages);
    }
    
    
}
