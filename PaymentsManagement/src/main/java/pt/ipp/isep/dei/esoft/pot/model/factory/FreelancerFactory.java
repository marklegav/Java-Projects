/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;
import pt.ipp.isep.dei.esoft.pot.model.RegisterFreelancer;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTask;
import pt.ipp.isep.dei.esoft.pot.model.Task;

/**
 *
 * @author Marcel
 */
public class FreelancerFactory implements FactoryUpStream<Freelancer, RegisterFreelancer>{
    
    /**
     * Factory of objects from type Freelancer
     */
    
    /**
     *Fabricate instances of freelancer 
     * @param lst
     * @param rFreela
     * @return
     */
    @Override
    public List<Freelancer> fabricate(List<String[]> lst, RegisterFreelancer rFreela, String orgNIF){
        List<Freelancer> lstFreelancer = new ArrayList();
        
        for(String[] line : lst){
            
            try{
                Freelancer freela = rFreela.newFreelancer(
                        line[Constantes.FREELANCER_NAME],
                        LevelOfExpertise.valueOf(line[Constantes.FREELANCER_EXPERTISE].toUpperCase()), 
                        line[Constantes.FREELANCER_EMAIL], 
                        line[Constantes.FREELANCER_NIF],
                        line[Constantes.FREELANCER_BANKACCT],
                        line[Constantes.FREELANCER_ADDRESS],
                        line[Constantes.FREELANCER_CONTRY]);
                lstFreelancer.add(freela);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return lstFreelancer;
    }

    @Override
    public void register(List<Freelancer> lst, RegisterFreelancer register) {
        
        for(Freelancer freela : lst){
            register.registerFreelancer(freela);
        }
    }

}
