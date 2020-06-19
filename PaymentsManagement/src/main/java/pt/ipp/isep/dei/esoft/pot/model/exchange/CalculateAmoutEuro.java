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
public class CalculateAmoutEuro implements CalculateAmout {
    
    private static final String currency = "EURO";
    
    /**
     *
     * @param costPerHour
     * @param taskDuration
     * @param factor
     * @param currencyFreelancer
     * @return
     */
    @Override
    //@SuppressWarnings("empty-statement")
    public double calculate(double costPerHour, double taskDuration, int factor, String currencyFreelancer){
        System.out.println(costPerHour+","+taskDuration+","+factor+","+getExchanceRate(currency,currencyFreelancer));
        return costPerHour*taskDuration*factor*1;
    }

    @Override
    public double getExchanceRate(String currencyOrg, String currencyFreelancer) {
        return 1;
    }
    
}
