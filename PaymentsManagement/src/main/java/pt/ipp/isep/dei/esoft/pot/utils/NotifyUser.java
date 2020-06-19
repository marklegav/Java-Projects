package pt.ipp.isep.dei.esoft.pot.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.SendEmail;

/**
 *
 * @author Marcel
 */
public interface NotifyUser {
        
    
    public SendEmail getEmailAPI();
    
    public String writeEmail(String[] info);
    
    public void notifyUser(List<String[]> users);
    
}
