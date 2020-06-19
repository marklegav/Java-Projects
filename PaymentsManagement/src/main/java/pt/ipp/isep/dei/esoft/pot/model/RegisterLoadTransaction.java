/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Marcel - 1191396
 */
public class RegisterLoadTransaction implements Serializable {
    
    private String designation;
    
    private LoadTransaction oLoadTr;
    
    private List<LoadTransaction> lstLog = new ArrayList<LoadTransaction>();
    
    public RegisterLoadTransaction(){
        this.designation="";
    }
    
    /**
     * 
     * @param log
     * @param emailColab
     * @param org
     * @param dtExec
    * @return 
     */
    public LoadTransaction createLoadTransaction(String emailColab, String org, Date dtExec) {
        String log = "log"+lstLog.size()+1;
        oLoadTr = new LoadTransaction(log, emailColab, org, dtExec);
        return oLoadTr;
    }

    public LoadTransaction getLoadTransaction() {
        return oLoadTr;
    }
    
    public List<LoadTransaction> getListLoadTransaction(){
        return this.lstLog;
    }
    
    public void addLoadTransaction(LoadTransaction oLoad){
        lstLog.add(oLoad);
    }
}