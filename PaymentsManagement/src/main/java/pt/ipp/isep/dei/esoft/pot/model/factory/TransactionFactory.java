/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Transaction;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTransaction;
import pt.ipp.isep.dei.esoft.pot.model.Task;

/**
 *
 * @author Marcel
 */
public class TransactionFactory implements FactoryUpStream<Transaction, RegisterTransaction>{
    
    @Override
    public List<Transaction> fabricate(List<String[]> lst, RegisterTransaction register, String orgNIF) {
        List<Transaction> lstPaymentOrder = new ArrayList();
        
        for(String[] line : lst){
            try{
                Freelancer freela = this.getFreelancerByNIF(line[Constantes.FREELANCER_NIF]);
                Task task = this.getTarefaByID(line[Constantes.TASK_ID]);
                Transaction transaction = register.newTransaction(task, freela,
                        line[Constantes.TRANSACTION_FINISHDATE], 
                        Integer.parseInt(line[Constantes.TRANSACTION_EXECDELAY]), 
                        line[Constantes.TRANSACTION_DESCRIPTION], orgNIF);
                lstPaymentOrder.add(transaction);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return lstPaymentOrder;        
    }

    @Override
    public void register(List<Transaction> lst, RegisterTransaction register) {
        register.setUpdate(false);
        for(Transaction trans : lst){
            register.addTransaction(trans);
            System.out.println(trans);
        }
        register.setUpdate(true);
        register.update();
    }
    
    private Freelancer getFreelancerByNIF(String NIF){
        return AplicacaoPOT.getInstance().getPlataforma()
                        .getRegisterFreelancer().getFreelancerByNIF(NIF);
    }    
        
    private Task getTarefaByID(String ID){
        return AplicacaoPOT.getInstance().getPlataforma()
                        .getRegistoTarefa().getTaskByID(ID);
    }   
}
