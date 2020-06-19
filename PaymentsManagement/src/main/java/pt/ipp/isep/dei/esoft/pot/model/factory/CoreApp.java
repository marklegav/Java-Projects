/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;



import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryProvider;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryUpStream;
import pt.ipp.isep.dei.esoft.pot.utils.Empacotamento;

/**
 *
 * @author Marcel - 1191396
 */
public class CoreApp {
    /**
     * This class contextualize the Application when this starts. For this was implemented 
     * Abstract Factory Pattern
     * 
     * 
     * 
     */
    
    //Have all objects to be contextualized
    private Platform oplat;
    
    
    public void setContext(Platform oplat){
        this.oplat = oplat;

        factoryContext();
        this.oplat.scheduleMakePayments();
        this.oplat.schedulesNotifyFreelancer();
    }
    
    /**
     * Load objects from binary file, register then at the aproprieted DAO class
     * and set serialization on.
     */
    private void factoryContext(){
        FactoryType[] types = FactoryType.values();
        for(FactoryType type :  FactoryType.values()){
            if(type.switchFactory()){
                List<?> lst = (List<?>)(Object) Empacotamento.lerArquivoBinario(type.toString().toLowerCase()+".bin"); //get objects 
                this.getFactory(type).register(lst, type.getRegister());
                type.getRegister().setUpdate(true); //set serialization on
            }
        }
    }
       
    
    /**
     * Get the factory for fabricate the objects
     * @param type
     * @return the aproprieted factory for the type of object
     */
    private FactoryUpStream getFactory(FactoryType type){
        return FactoryProvider.getType(type);
    }

}
