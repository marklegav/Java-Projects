/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.utils.Empacotamento;
import pt.ipp.isep.dei.esoft.pot.utils.Empacotamento;


/**
 *
 * @author Marcel
 * @param <T>
 */
public abstract class RegistersDAO<T> {
    
    /**
     * This class that be extended to all registers class that will register 
     * informations about model class as HC+LC.
     * 
     * This was design based in Data Access Object Pattern just for serialization,
     * and have just the method update from stand DAO Pattern
     * 
     */
    
    //Determine if the changes will be serialized or not
    private Boolean bUpadte = false;
   
    public RegistersDAO(){
        
    }
    
    /**
     * Turn on/off the serialization
     * it's usefull to don't serialize changes that happen in test environment
     * or load objects by upstream
     * 
     * @param bUpdate true or false
     */
    public void setUpdate(Boolean bUpdate){
        this.bUpadte = bUpdate;
    }
    
    /**
     * Serialize the list of types from subclasses
     * @param nameFile type of object
     * @param lst list of types to serialize
     */
    protected void update(String nameFile, List<T> lst){
        if(this.bUpadte == true){
            Empacotamento.gravarArquivoBinario((List<Object>)(Object)lst, nameFile);
        }
    }
    
}

