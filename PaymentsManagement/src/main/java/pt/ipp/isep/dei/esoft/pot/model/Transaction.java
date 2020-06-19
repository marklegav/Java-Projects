/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.exchange.CalculateAmout;
import pt.ipp.isep.dei.esoft.pot.model.exchange.CalculateAmoutEuro;

/**
 *
 * @author Marcel
 */
public class Transaction implements Serializable {
     
    //Default algorithm to calculate amount for payment
    transient private CalculateAmoutEuro amountOrg = new CalculateAmoutEuro();
    
    //Task associate to this transaction
    private Task task;
    
    //Freelancer that execute the task and will be paid
    private Freelancer oFree;
    
    //ID from transaction
    private String TransID;
    
    //Finish date of execute transaction
    private String executionFinishDate;
    
    //Delay from execution
    private int executionDelayHours;
    
    //A brief description about the quality of the work
    private String executionBriefDescription;
    
    //NIF of organization that this transaction is associate
    private String orgNIF;
    
    //Status of payment;
    private String status;
    
    private static final String STATUS_DEFAULT = "to pay";

    //for serialize
    private static final long serialVersionUID = 1L;

    /**
     * Intantiate a transaction
     * @param task
     * @param oFree
     * @param TransID
     * @param execFinishDate
     * @param execDelay
     * @param execBriefDescription
     * @param orgNIF 
     */
    public Transaction(Task task, Freelancer oFree, String TransID, String execFinishDate, int execDelay, String execBriefDescription, String orgNIF) {
        this.task = task;
        this.oFree = oFree;
        this.TransID = TransID;
        this.executionFinishDate = execFinishDate;
        this.executionDelayHours = execDelay;
        this.executionBriefDescription = execBriefDescription;
        this.orgNIF = orgNIF;
        this.status = STATUS_DEFAULT;
    }

    /**
     * get NIF of organization that this transaction is associate
     * @return oganization's NIF
     */
    public String getOrgNIF() {
        return orgNIF;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    /**
     * get transaction's task
     * @return task
     */
    public Task getTask() {
        return task;
    }
    
    /**
     * get transaction's freelancer
     * @return freelancer
     */
    public Freelancer getFreelancer() {
        return this.oFree;
    }
    
    /**
     * get delay in hours 
     * @return delay in hours, that is a integer value as client documentation
     */
    public double getDelay() {
        return (double) this.executionDelayHours;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    /**
     * Seniors freelancers receive the double of juniors receive as client documentation
     * @return 1 - Junior, 2 - for Senior
     */
    public int factorLevel() {
        int factor=1;
        if(this.oFree.getLevel().toString().toUpperCase().equals("SENIOR")){
            factor =2;
        }
        return factor;
    }
    

    /**
     * Calculate the amount that will be paid:
     * M_custo - cost of a task
     * M_duracao - assignment
     * @return M_custo * M_duracao * factorLevel
     */
    public double calculateAmountPay() {
        return (double)this.task.getM_custo() * (double) this.task.getM_duracao() * this.factorLevel();
    }
    
    /**
     * Get alcgorithm to calculate amount to freelancer's local currency 
     * on the basis of freelancers country and proprities file
     * @return a object that implements CalculateAmount interface
     */
    public CalculateAmout getExchangeAlg(){
        CalculateAmout oAlg = null;
        try {
            Class<?> oClass = Class.forName("pt.ipp.isep.dei.esoft.pot.model.exchange.CalculateAmoutEuro");
            oAlg =  (CalculateAmout) oClass.newInstance();
            return oAlg;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CalculateAmout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oAlg;
    }

    /**
     * Calculate value to pay for freel
     * @return 
     */  
    public double calculateFreelancerPayment() { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return this.amountOrg.calculate((double)this.task.getM_custo(),
//                (double) this.task.getM_duracao(), factorLevel(), this.oFree.getAdress().getCountry());
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Transaction){
            Transaction otherTrans = (Transaction) o;
            
            return otherTrans.TransID.equals(this.TransID);
        }
        return false;
    
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nPayment Amount: %s\n"
                + "Task ID: %s\nFreelancer ID: %s\nStatus: %s", this.TransID, this.amountOrg, 
                this.task.getID(), this.oFree.getId(), this.status);
    }
}
