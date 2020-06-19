/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryProvider;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryUpStream;
import pt.ipp.isep.dei.esoft.pot.model.utils.filereader.ReadType;
import pt.ipp.isep.dei.esoft.pot.model.utils.filereader.ReaderProvider;
import pt.ipp.isep.dei.esoft.pot.model.utils.filereader.StrategyRead;



/**
 *
 * @author Marcel
 */
public class LoadTransaction {
    
    /**
     * This class implements load transaction by file, for this was adopted
     * the Strategy Pattern, to read CSV or TXT file, and Abtract Facthory
     * Pattern, to instanciate the objects and reuse code from serialization
     * process.
     * This class create an object that has details of operation (log)
     * 
     */
    
    private String org;
    private String log;
    private String emailColab;
    private Date dtExec;
    private String status;
    private List<List<?>> lstLoaded = new ArrayList();
    private List<String[]> lstFile = new ArrayList();


    /**
     * Initialize a Load Transaction object
     * @param log ID number of operation
     * @param emailColab email of collaborator that execute the operation
     * @param org Colaborator's organization
     * @param dtExec  Execute date
     */
    public LoadTransaction(String log, String emailColab, String org, Date dtExec){
        if(log == null || emailColab == null || org ==null || dtExec == null){
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }else{
            this.log = log;
            this.org = org;
            this.emailColab = emailColab;
            this.dtExec = dtExec;
        }
    }

    public String getLog(){
        return this.log;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getEmailColab(){
        return this.emailColab;
    }
    public String getOrg(){
        return this.org;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    /**
     * Process to load transaction for a file
     * @param fileName
     * @param orgNIF 
     */
    public void loadTransaction(File fileName, String orgNIF){
        try {
            this.lstFile=this.addFile(fileName);
            this.lstLoaded = this.factory(this.lstFile, orgNIF);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    
    /**
     * This add informations from the file to a list of array of strings
     * @param fileName File Name
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     */

    public List<String[]> addFile(File fileName) throws FileNotFoundException{
        String extension = fileName.getName().substring(fileName.getName().lastIndexOf(".")+1);
        return this.setStrategyReader(extension).setListFromFile(fileName);
    }
    
    /**
     * Contextualize the strategy reader based in type of file.
     * For now, the application just suport read from text file 
     * and csv (comma-separated-value) file.
     * @param extension type of file
     * @return the Strategy to read file
     */
    public StrategyRead setStrategyReader(String extension){
        return ReaderProvider.getType(ReadType.valueOf(extension.toUpperCase()));
    }
    
    /**
     * Fabricate the Freelancers and Tasks
     * @param lstFile list that was getted from a file
     * @param orgNIF Organization's NIF
     * @return a list 2D of generic objects
     */
    public List<List<?>> factory(List<String[]> lstFile, String orgNIF){
        List<List<?>> lst = new ArrayList();
        FactoryType[] types = FactoryType.values();
        for(FactoryType type :  FactoryType.values()){
            if(type.equals(FactoryType.TRANSACTION)){ //don't fabricate Transactions because this needs Freelancer and Task exist in platform as Requiriments Engineering
                break;
            }
            lst.add(this.getFactory(type).fabricate(lstFile, type.getRegister(), orgNIF));
        }
        return lst;
    }
    
    /**
     * Provide the right factory for each object
     * @param type enum of type of objects
     * @return the factory class that is responsible to initialize the object
     */
    public FactoryUpStream getFactory(FactoryType type){
        return FactoryProvider.getType(type);
    }
    
    /**
     * Register Freelancers and Tasks thast was fabricated
     * @param orgNIF Organization's NIF
     */
    public void register(String orgNIF){
        FactoryType[] types = FactoryType.values();
        int i = 0;
        for(FactoryType type :  FactoryType.values()){
            if(type.equals(FactoryType.TRANSACTION)){
                break;
            }
            this.getFactory(type).register(this.lstLoaded.get(i), type.getRegister());
            i++;
        }
        this.factoryTransaction(orgNIF);
    }  

    /**
     * Fabricate Transactions
     * @param orgNIF Organization's NIF 
     */
    private void factoryTransaction(String orgNIF){
        FactoryType type = FactoryType.TRANSACTION;
        List<Transaction> lst = this.getFactory(type).fabricate(lstFile,type.getRegister(), orgNIF);
        System.out.println(lst);
        this.getFactory(type).register(lst,type.getRegister() );
    }
    
    @Override
    public String toString(){
        return String.format("Log: %s | E-mail: %s | Company: %s" , 
                    this.log, this.emailColab, this.org);
    }

}
