/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;

/**
 *
 * @author Rita
 */
public class RegisterFreelancer extends RegistersDAO implements Serializable{
    
    /**
     * The list of all freelancers created from RegisterFreelancer.
     */
    private List<Freelancer> listOfFreelancers;

    /**
     * Creates an instance of RegisterFreelancer.
     */
    public RegisterFreelancer() {
        listOfFreelancers = new ArrayList();
    }
    
    /**
     * Creates an instance of Freelancer from the RegisterFreelancer
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
     * @return freelancer an instance of Freelancer
     */
    public Freelancer newFreelancer(String name, LevelOfExpertise level, String email, String nif, String iban, String address, String country) {
        return new Freelancer(setId(name), name, level, email, nif, iban, address, country);
    }
    
    /**
     * Sets the id for each instance of freelancer created from RegisterFreelancer.
     * 
     * @param name the Freelancer's name
     * @return id the Freelancer's id
     */
    public String setId(String name) {
        int counter = 1;
        String initials = getInitials(name);
        if (!listOfFreelancers.isEmpty()) {
            for (Freelancer freel : listOfFreelancers) {
                if (freel.hasInitials(initials)) {
                    counter = Character.getNumericValue(freel.getId().charAt(2)) + 1;
                }
            }
        }
        return initials + counter;
    }
    
    /**
     * Sets the initials for each instance of freelancer created from RegisterFreelancer.
     * 
     * @param name the Freelancer's name
     * @return initials the Freelancer's initials
     */
    public String getInitials(String name) {
        String[] namex = name.split(" ");
        Character firstLetterName = namex[0].charAt(0);
        Character firstLetterLast = namex[namex.length - 1].charAt(0);
        String initials = "" + firstLetterName + firstLetterLast;
        return initials;
    }

    /**
     * Registers the Freelancer.
     * 
     * @param freel the instance of Freelancer to register
     * @return true if freelancer is registered successfully
     */
    public boolean registerFreelancer(Freelancer freel) {
        if (this.validateFreelancer(freel)) {
            return addFreelancer(freel);
        }
        return false;
    }

    /**
     * Adds the instance of Freelancer received by parameter 
     * to the list of freelancers of RegisterFreelancer.
     * 
     * @param freel the instance of Freelancer to add
     * @return true if freelancer is added successfully
     */
    private boolean addFreelancer(Freelancer freel) {
        boolean result = listOfFreelancers.add(freel);
        if(result)
            update();
        return result;
    }

    /**
     * Validates the instance of Freelancer received by parameter 
     * according to the applicable rules.
     * 
     * @param freel the instance of Freelancer to validate
     * @return true if freelancer is valid
     */
    public boolean validateFreelancer(Freelancer freel) {
        for (Freelancer freelx : listOfFreelancers) {
            if (freelx.equals(freel)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the list of Freelancers of RegisterFreelancer.
     * 
     * @return freelancers the list of Freelancers of RegisterFreelancer
     */
    public List<Freelancer> getFreelancers() {
        List<Freelancer> freelancers = new ArrayList<>();
        freelancers.addAll(this.listOfFreelancers);
        return freelancers;
    }

    /**
     * Returns the instance of Freelancer that 
     * corresponds to the id received by parameter.
     * 
     * @param id the Freelancer's id
     * @return freel the instance of Freelancer that corresponds to the id received by parameter
     */
    public Freelancer getFreelancerByID(String id) {
        for (Freelancer freel : this.listOfFreelancers) {
            if (id.equals(freel.getId())) {
                return freel;
            }
        }
        return null;
    }
    
    /**
     * Returns the instance of Freelancer that 
     * corresponds to the nif received by parameter.
     * 
     * @param nif the Freelancer's nif
     * @return freel the instance of Freelancer that corresponds to the nif received by parameter
     */
    public Freelancer getFreelancerByNIF(String nif) {
        for (Freelancer freel : this.listOfFreelancers) {
            if (nif.equals(freel.getNIF())) {
                return freel;
            }
        }
        return null;
    }

    /**
     * Returns the a list of strings each with the textual 
     * description of a freelancer.
     * 
     * @return freelancersString a list of strings each with the textual description of a freelancer
     */
    public List<String> getListFreelancer() {
        List<String> freelancersString = new ArrayList<>();
        for (Freelancer freel : listOfFreelancers) {
            freelancersString.add(freel.toString());
        }
        return freelancersString;
    }

//    public Freelancer 
    public void update(){
        super.update(FactoryType.FREELANCER.toString().toLowerCase()+".bin", listOfFreelancers);
    }
    
}
