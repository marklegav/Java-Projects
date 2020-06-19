/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel
 * @param <T>
 */
public interface FactoryUpStream<T,E> {
    
    /**
     * Should be implemented for all class that will create new instance by upstream
     */
    
    /**
     * @param lst list with informations to initialize the object
     * @param register the register that manager the informations about the type of object
     * @param orgNIF Organization NIF
     * @return List of types that was created
     */
    
    public List<T> fabricate(List<String[]> lst, E register, String orgNIF);
    
    /**
     * Recive a list of type and register at the element
     * @param lst list of type
     * @param register element that have a list of type
     */
    public void register(List<T> lst, E register);
}
