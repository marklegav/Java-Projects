/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.utils.Statistics;

/**
 *
 * @author Rita
 */
public class NotifyFreelancer {
    
    /**
     * The list of freelancers that apply to be notified in NotifyFreelancer.
     */
    private List<Freelancer> freelancersThatApply;
    
    /**
     * Creates an instance of NotifyFreelancer.
     */
    public NotifyFreelancer() {
        freelancersThatApply = new ArrayList<>();
    }
    
    /**
     * Adds to the list of freelancers that apply in NotifyFreelancer all 
     * freelancers that have a mean task delay higher than 3 hours 
     * and have a percentage of delays that is higher than the 
     * overall percentage of delays.
     */
    public void getFreelancersThatApply() {
        Statistics statistics = AplicacaoPOT.getInstance().getPlataforma().getStatistics();
        List<Freelancer> totalFreelancers = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().getFreelancers();
        List<Transaction> transactions = AplicacaoPOT.getInstance().getPlataforma().getRegisterOrganisation().getAllTransactions();
        double overallPercentageOfDelays = statistics.calculateOverallPercentageOfDelays(transactions);
        for (Freelancer freel : totalFreelancers) {
            if (statistics.calculateFreelancerMeanTaskDelay(freel, transactions) > 3 
                    && statistics.calculateFreelancerPercentageOfDelays(freel, transactions) > overallPercentageOfDelays) {
                freelancersThatApply.add(freel);
            }
        }
    }
    
    /**
     * Writes an email with the freelancer name received by parameter.
     * 
     * @param freelName the name of the Freelancer
     * @return an email with the name of the Freelancer
     */
    public String writeEmail(String freelName) {
        return String.format("Hello %s,"
                + "\nDuring this past year you had a mean task delay time higher "
                + "than 3 hours and your percentage of delays is currently "
                + "higher than the overall percentage of delays."
                + "\nThis means your performance is bellow expectations.", freelName);
    }
    
    /**
     * Sends an email to all freelancers
     * that have a mean task delay higher than 3 hours 
     * and have a percentage of delays that is higher than the 
     * overall percentage of delays.
     */
    public void notifyFreelancers() {
        List<String> emails = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        SendEmail api = AplicacaoPOT.getInstance().getPlataforma().getEmailAPI();
        if (!freelancersThatApply.isEmpty()) {
            for (Freelancer freel : freelancersThatApply) {
                emails.add(freel.getEmail());
                messages.add(writeEmail(freel.getName()));
            }
            api.sendEmails(emails, messages);
        }
    }
    
}
