/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;
import pt.ipp.isep.dei.esoft.pot.model.RegisterFreelancer;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Rita
 */
public class CreateFreelancerController {
    
    /**
     * The CreateFreelancerController's RegisterFreelancer.
     */
    private RegisterFreelancer registerFreelancer;
    
    /**
     * The CreateFreelancerController's Freelancer.
     */
    private Freelancer freel;
    
    /**
     * Creates an instance of CreateFreelancerController.
     */
    public CreateFreelancerController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Unauthorized User.");
        }
        this.registerFreelancer = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer();
    }
    
    /**
     * Creates an instance of Freelancer from the CreateFreelancerController
     * with the name, level of expertise, email, NIF, IBAN, 
     * address and country received by parameter. 
     *
     * @param name the Freelancer's name
     * @param level the Freelancer's level of expertise
     * @param email the Freelancer's email
     * @param nif the Freelancer's nif
     * @param iban the Freelancer's iban
     * @param address the Freelancer's address
     * @param country the Freelancer's country
     * @return true if the instance of Freelancer was successfully created
     */
    public boolean newFreelancer(String name, LevelOfExpertise level, String email, String nif, String iban, String address, String country) {
        try {
            this.freel = this.registerFreelancer.newFreelancer(name, level, email, nif, iban, address, country);
            return this.registerFreelancer.validateFreelancer(this.freel);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.freel = null;
            return false;
        }
    }
    
    /**
     * Registers the Freelancer.
     * 
     * @return true if freelancer is registered successfully
     */
    public boolean registerFreelancer() {
        return this.registerFreelancer.registerFreelancer(this.freel);
    }

    /**
     * Returns the Freelancer's textual description.
     *
     * @return the Freelancer's textual description
     */
    public String getFreelancerString() {
        return this.freel.toString();
    }
    
    /**
     * Returns the list of Freelancers of RegisterFreelancer.
     * 
     * @return listFreelancers the list of Freelancers of RegisterFreelancer
     */
    public List<Freelancer> getListFreelancers() {
        List<Freelancer> listFreelancers = registerFreelancer.getFreelancers();
        return listFreelancers;
    }
    
}
