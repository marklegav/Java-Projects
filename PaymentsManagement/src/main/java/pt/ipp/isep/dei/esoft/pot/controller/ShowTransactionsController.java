/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.Transaction;

/**
 *
 * @author Marcel
 */
public class ShowTransactionsController {
    
    private Platform oPlat;
    private Organization org;
    
    public ShowTransactionsController(){
        this.oPlat = AplicacaoPOT.getInstance().getPlataforma();
        String emailColab = AplicacaoPOT.getInstance().getSessaoAtual().getEmailUtilizador();
        this.org = this.oPlat.getRegisterOrganisation().getCompanByLogin(emailColab);
    }
    
    public List<Transaction> getTransactionsByLogin(){
        System.out.println(this.oPlat.getRegisterTransaction().getPaymentOrders());
        return this.oPlat.getRegisterTransaction().getPaymentOrders();
    }
    
}
