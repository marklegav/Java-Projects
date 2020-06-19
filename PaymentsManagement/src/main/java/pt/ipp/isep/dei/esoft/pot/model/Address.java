/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;

/**
 *
 * @author Rita
 */
public class Address implements Serializable {
    
    /**
     * The Address' street name.
     */
    private String streetname;
    
    /**
     * The Address' zone.
     */
    private String zone;
    
    /**
     * The Address' zip-code.
     */
    private String zipCode;
    
    /**
     * The Address' country.
     */
    private String country;
    
    /**
     * Creates an instance of Address with the streetname, zone, 
     * zip-code and country received by parameter. 
     *
     * @param streetname the Address' streetname
     * @param zone the Address' zone
     * @param zipCode the Address' zip-code
     * @param country the Freelancer's country
     */
    public Address(String streetname, String zone, String zipCode, String country) {
        if (streetname == null || streetname.isEmpty() || zone == null || zone.isEmpty() || 
                zipCode == null || zipCode.isEmpty() || country == null || country.isEmpty()) {
            throw new IllegalArgumentException("No argument can be null of empty.");
        }
        this.streetname = streetname;
        this.zone = zone;
        this.zipCode = zipCode;
        this.country = country;
    }
    
    /**
     * Creates an instance of Address from another instance of Address. 
     *
     * @param add another instance of Address
     */
    public Address(Address add) {
        this.streetname = add.getStreetName();
        this.zone = add.getZone();
        this.zipCode = add.getZipCode();
        this.country = add.getCountry();
    }
    
    /**
     * Returns the Address' street name.
     *
     * @return streetname the Address' street name
     */
    public String getStreetName(){
        return streetname;
    }
    
    /**
     * Returns the Address' zone.
     *
     * @return zone the Address' zone
     */
    public String getZone(){
        return zone;
    }
    
    /**
     * Returns the Address' zip-code.
     *
     * @return zipCode the Address' zip-code
     */
    public String getZipCode(){
        return zipCode;
    }
    
    /**
     * Returns the Address' country.
     *
     * @return country the Address' country
     */
    public String getCountry(){
        return country;
    }
    
    /**
     * Returns the Address' textual description.
     *
     * @return the Address' textual description
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", streetname, zone, zipCode, country);
    }
    
}
