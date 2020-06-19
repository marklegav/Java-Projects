/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.RegisterOrganisation;

/**
 *
 * @author Marcel
 */
public class OrganizationFactory implements FactoryUpStream<Organization, RegisterOrganisation>{

    @Override
    public List<Organization> fabricate(List<String[]> lst, RegisterOrganisation register, String orgNIF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void register(List<Organization> lst, RegisterOrganisation register) {
        for(Organization org : lst){
            register.addOrganizacao(org);
        }
    }
    
}
