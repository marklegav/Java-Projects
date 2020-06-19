/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.exchange;

/**
 *
 * @author Marcel - 1191396
 */
public interface CalculateAmout {
    
    /**
     * This implements the Protected variation Pattern to calculate amount that 
     * Freelancers will recive in their local currency, as specified in FURPS+
     * 
     */
    
    /**
     * Cacuçate the amount
     * @param costPerHour cost per hour
     * @param taskDuration task Assignament duration
     * @param factor Seniors freelancers receive the double of a Junior
     * @param currencyFreelancer the name of the freelancer's currency
     * @return amount that freelancer will receive
     */
    public double calculate(double costPerHour, double taskDuration, int factor, String currencyFreelancer);
    
    
    /**
     * get the exchange rate from external API
     * @param currencyOrg currency ID from organization
     * @param currencyFreelancer currency ID from Freelancer
     * @return the exchange rate
     */
    public double getExchanceRate(String currencyOrg, String currencyFreelancer);
    
}
