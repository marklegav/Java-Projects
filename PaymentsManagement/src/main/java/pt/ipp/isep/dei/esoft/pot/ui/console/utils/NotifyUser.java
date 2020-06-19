/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.utils;

import pt.ipp.isep.dei.esoft.pot.model.SendEmail;

/**
 *
 * @author Marcel
 */
public interface NotifyUser {
        
    
    public SendEmail getEmailAPI();
    
    public void getEmailListThatApply();
    
    public String writeEmail(String freelName);
    
    public void notifyUser();
    
}
