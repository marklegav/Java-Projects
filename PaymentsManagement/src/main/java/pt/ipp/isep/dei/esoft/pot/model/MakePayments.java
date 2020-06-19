/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 *
 * @author Rita
 */
public class MakePayments { 
    
    private RegisterTransaction registerTran;
    private RegisterOrganisation registerOrg;
    
    public MakePayments () {
        this.registerTran = AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction();
        this.registerOrg = AplicacaoPOT.getInstance().getPlataforma().getRegisterOrganisation();
    }
    
    public List<Organization> checkPaymentDates(int day) {
        List<Organization> orgs = new ArrayList<>();
        for (Organization org : registerOrg.getOrganization()) {
            if (org.getPayDay() == day) {
                orgs.add(org);
            }
        }
        return orgs;
    }
    
    public List<Transaction> getTransactions(List<Organization> lstOrg){
        List<Transaction> lstTrans = new ArrayList();
        for(Organization org : lstOrg){
            lstTrans.addAll(this.registerTran.getListTransactioByOrg(org.getNIF()));
        }
        return lstTrans;
    }
    
    public String makePayment(List<Transaction> lstTrans){
        String result = "================";
        for(Transaction trans : lstTrans){
            if(trans.getStatus().equals("to pay")){
                trans.setStatus("paid");
                result += trans.toString();
            }
        }
        return result;
    }
    
}
