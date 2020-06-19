/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.TimerTask;

/**
 *
 * @author Rita
 */
public class NotifyFreelancerTask extends TimerTask {
    
    private NotifyFreelancer notifyFreelancer;
    
    public NotifyFreelancerTask() {
        notifyFreelancer = new NotifyFreelancer();
    }

    @Override
    public void run() {
        notifyFreelancer.getFreelancersThatApply();
        notifyFreelancer.notifyFreelancers();
    }
    
}
