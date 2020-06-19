/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.NotifyFreelancer;

/**
 *
 * @author Rita
 */
public class NotifyFreelancerController {
    
    private NotifyFreelancer notifyFreelancers;
    
    public NotifyFreelancerController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO)) {
            throw new IllegalStateException("Unauthorized User.");
        }
        notifyFreelancers = new NotifyFreelancer();
    }
    
    public void notifyFreelancersNow() {
        //notifyFreelancers.getFreelancersThatApply();
        notifyFreelancers.notifyFreelancers();
    }
    
}
