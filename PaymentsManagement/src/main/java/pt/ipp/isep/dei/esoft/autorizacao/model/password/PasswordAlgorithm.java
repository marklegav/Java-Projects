/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model.password;

/**
 *
 * @author Marcel
 */
public interface PasswordAlgorithm {
    
    
    /**
     * 
     * @param qtChar password's characters number
     * @param rangeChar characters's range to generate password ramdom 
     * @return 
     */
    public String generatePassword(int qtChar, String rangeChar);
    
    
    public String pwd();
    
    
}
