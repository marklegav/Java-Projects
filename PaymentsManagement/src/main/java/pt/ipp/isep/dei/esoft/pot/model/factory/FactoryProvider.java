/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

/**
 *
 * @author Marcel
 */
public class FactoryProvider {
    
    /**
     * Create a new instance of Factory for each type of object
     * @param name
     * @return 
     */
    
    public static FactoryUpStream getType(FactoryType name) {
        switch (name){
            case TASK:
                return new TaskFactory();
            case FREELANCER:
                return new FreelancerFactory();
            case TRANSACTION:
                return new TransactionFactory();
            case ORGANIZATION:
                return new OrganizationFactory();
            default:
                return null;
        }
    }
}
