/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.Date;
import pt.ipp.isep.dei.esoft.pot.model.LoadTransaction;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.RegisterLoadTransaction;
import pt.ipp.isep.dei.esoft.pot.model.RegisterOrganisation;

/**
 *
 * @author Marcel
 */
public class SetPaymentDayController {
    
    private RegisterOrganisation regiterOrg;
    private Organization org;
    private String emailColab;
    private Platform oPlataforma;
    private AplicacaoPOT oApp;
    
    
    public SetPaymentDayController(){
        this.oApp = AplicacaoPOT.getInstance();
        this.oPlataforma = oApp.getPlataforma();
        String emailColab =  this.oApp.getSessaoAtual().getEmailUtilizador();
        this.org = this.oPlataforma.getRegisterOrganisation().getCompanByLogin(emailColab);
    }
    
    
    public int getPayDayofOrganization(){    
        return this.org.getPayDay();
    }
    
    public boolean validatePayDay(int day){
        return org.validatePayDay(day);
    }
    
    public void registerPayDay(int day){
        org.setPayDay(day);
    }
}
