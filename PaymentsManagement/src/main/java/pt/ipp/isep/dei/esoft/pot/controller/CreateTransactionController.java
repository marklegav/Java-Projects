/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Transaction;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.RegisterFreelancer;
import pt.ipp.isep.dei.esoft.pot.model.RegisterOrganisation;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTransaction;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTask;
import pt.ipp.isep.dei.esoft.pot.model.Task;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;


/**
 *
 * @author arccenio
 */
public class CreateTransactionController {
     private Platform plataform;
    private Organization org;
    private RegisterTask rTask; 
    

    private Transaction trans;
    private RegisterTransaction m_registerP;

    public CreateTransactionController() {
        this.plataform = AplicacaoPOT.getInstance().getPlataforma();
        this.rTask = plataform.getRegistoTarefa();
        this.m_registerP = plataform.getRegisterTransaction();
        String emailColab = AplicacaoPOT.getInstance().getSessaoAtual().getEmailUtilizador();
        this.org = this.plataform.getRegisterOrganisation().getCompanyByUserEmail(emailColab);
    }
    
    public List<Task >getListTask(){
        return plataform.getRegistoTarefa().getTaskByOrganization(this.org.getNIF());
    }
        
    public List<String>getListFreelancer(){
         return plataform.getRegisterFreelancer().getListFreelancer();
     }

     public   boolean create(String idTask, String idFreelancer, String finishDate, int delay, String briefDesc){
         try {
            Task task =rTask.getTaskByID(idTask);
            Freelancer freela=plataform.getRegisterFreelancer().getFreelancerByID(idFreelancer);
            this.trans = m_registerP.newTransaction(task,freela,finishDate,delay,briefDesc,this.org.getNIF());
            return this.m_registerP.validateTransaction(trans);
        } catch (RuntimeException ex) {

            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.trans = null;
            return false;
        }        
    }
     
    public boolean regiterTransation(){
        return m_registerP.RegisterTransition(trans);
    }
    

    
    
}
