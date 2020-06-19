/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Rita
 */
public class Freelancer implements Serializable {
    
    /**
     * The Freelancer's id.
     */
    private String id;
    
    /**
     * The Freelancer's name.
     */
    private String name;
    
    /**
     * The Freelancer's level of expertise.
     */
    private LevelOfExpertise level;
    
    /**
     * The Freelancer's email.
     */
    private String email;
    
    /**
     * The Freelancer's NIF.
     */
    private String nif;
    
    /**
     * The Freelancer's IBAN.
     */
    private String iban;
    
    /**
     * The Freelancer's Adress.
     */
    private Address address;
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates an instance of Freelancer with the id, name, level of expertise, 
     * email, NIF, IBAN, address and country received by parameter. 
     *
     * @param id the Freelancer's id
     * @param name the Freelancer's name
     * @param level the Freelancer's level of expertise
     * @param email the Freelancer's email
     * @param nif the Freelancer's nif
     * @param iban the Freelancer's iban
     * @param address the Freelancer's address
     * @param country the Freelancer's country
     */
    public Freelancer(String id, String name, LevelOfExpertise level, String email, String nif, String iban, String address, String country) {
        if (id == null || id.isEmpty() || name == null || name.isEmpty() || 
                level == null || email == null || email.isEmpty() || 
                nif == null || nif.isEmpty() || iban == null || iban.isEmpty() || 
                address == null || address.isEmpty() || country == null || country.isEmpty()) {
            throw new IllegalArgumentException("No argument can be null or empty.");
        }
        this.id = id;
        this.name = name;
        this.level = level;
        this.email = email;
        this.nif = nif;
        this.iban = iban;
        String[] addressx = address.split("-");
        this.address = new Address(addressx[0], addressx[1], addressx[2], country);
    }
    
    /**
     * Returns the Freelancer's id.
     *
     * @return id the Freelancer's id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Returns the Freelancer's name.
     *
     * @return name the Freelancer's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the Freelancer's level of expertise.
     *
     * @return level the Freelancer's level of expertise
     */
    public LevelOfExpertise getLevel() {
        return level;
    }
    
    /**
     * Returns the Freelancer's email.
     *
     * @return email the Freelancer's email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Returns the Freelancer's NIF.
     *
     * @return nif the Freelancer's NIF
     */
    public String getNIF() {
        return nif;
    }
    
    /**
     * Returns the Freelancer's IBAN.
     *
     * @return iban the Freelancer's IBAN
     */
    public String getIBAN() {
        return iban;
    }
    
    /**
     * Returns the Freelancer's Address.
     *
     * @return address the Freelancer's Address
     */
    public Address getAdress(){
        return new Address(address);
    }
    
    /**
     * Returns the Freelancer's textual description.
     *
     * @return the Freelancer's textual description
     */
    @Override
    public String toString() {
        return String.format("ID: %s\nName: %s\nLevel of Expertise: %s\nEmail: %s\nNIF: %s\nIBAN: %s\nAddress: %s"
                , id, name, level, email, nif, iban, address);
    }
    
    /**
     * Returns true if it finds matching initials.
     *
     * @param initials the Freelancer's initials
     * @return true if it finds matching initials
     */
    public boolean hasInitials(String initials) {
        String initialsx = "" + this.id.charAt(0) + this.id.charAt(1);
        return initialsx.equalsIgnoreCase(initials);
    }
    
    /**
     * Returns true if it finds a matching id.
     *
     * @param id the Freelancer's id
     * @return true if it finds a matching id
     */
    public boolean hasId(String id) {
        return this.id.equalsIgnoreCase(id);
    }
    
    /**
     * Returns true if it finds a matching email.
     *
     * @param email the Freelancer's email
     * @return true if it finds a matching email
     */
    public boolean hasEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }
    
    
    /**
     * Compares the object received by parameter to the Freelancer instance.
     *
     * @param o object to compare
     * @return true if the object is the same as the Freelancer instance
     */
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Freelancer freel = (Freelancer) o;
        return (Objects.equals(this.nif, freel.getNIF())) ||
                (Objects.equals(this.iban, freel.getIBAN()));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.nif);
        hash = 11 * hash + Objects.hashCode(this.iban);
        return hash;
    }
    
}
