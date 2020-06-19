/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;

/**
 *
 * @author Marcel
 */
public class RegisterTransaction extends RegistersDAO implements Serializable{
    
    private List<Transaction> lstPayment = new ArrayList();  

    public RegisterTransaction() {
    }
    
//    public Transaction newTransaction(Task task, Freelancer oFree, String FinishDate, int execDelay, String briefDescription, String orgNIF){
//        return new Transaction(task, oFree, createNewID(), FinishDate, execDelay, briefDescription, orgNIF);
//    }
    
    public Transaction newTransaction(Task task, Freelancer oFree, String FinishDate, int execDelay, String briefDescription, String orgNIF){
        return new Transaction(task, oFree, createNewID(), FinishDate, execDelay, briefDescription, orgNIF);
    }
    
    private String createNewID(){
        
        return String.valueOf(this.lstPayment.size())+1;
    }
    
    public boolean addTransaction(Transaction pay){
       this.lstPayment.add(pay);
       update();
            return true;

    }
    
    public boolean validateTransaction(Transaction pay){
        return true;// this.lstPayment.contains(pay);
    }
     public void createPaymentTransation(Freelancer fre, Task task, String dateC, int dilay, String breDescQ) {
    }

    public boolean RegisterTransition(Transaction pay) {
        if(this.validateTransaction(pay)){
            addTransaction( pay);
            update();
            return true;
        }
        return false;
    }

    public List<Transaction> getPaymentOrders() {
        return this.lstPayment;
    }

    public double getOverallPercentageOfDelays() {
        int counter = 0;
        for (Transaction paymentOrder : lstPayment) {
            if (paymentOrder.getDelay() >= 1) {
                counter++;
            }
        }
        return counter / lstPayment.size() * 100;
    }
    
    /**
     * Recive an organizations's NIF and return the organization's task list
     * @param orgNIF organization's NIF
     * @return list of task
     */
    public List<Transaction> getListTransactioByOrg(String orgNIF){
        List<Transaction> lst = new ArrayList();
        for(Transaction trans : lstPayment){
            if(trans.getOrgNIF().equals(orgNIF)){
                lst.add(trans);
            }
        }
        return lst;
    }
//     public List<Transaction> getPaymentOrders() {
//        return this.lstPayment;
//    }
    
    /**
     * send this list of type to the super update method that will serialize 
     * the changes in list
     */
     public void update(){
         super.update(FactoryType.TRANSACTION.toString().toLowerCase()+".bin", this.lstPayment);
     }
     
    public List<Freelancer> getFreelancers() {
        List<Freelancer> freelancers = new ArrayList<>();
        for (Transaction transaction : this.lstPayment) {
            if (!freelancers.contains(transaction.getFreelancer())) {
                freelancers.add(transaction.getFreelancer());
            }
        }
        return freelancers;
    }
    
}
