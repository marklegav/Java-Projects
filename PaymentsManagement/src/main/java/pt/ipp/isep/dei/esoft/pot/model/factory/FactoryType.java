/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;


import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.RegistersDAO;

/**
 *
 * @author Marcel
 */
public enum FactoryType {
    
    /**
     * CONTROL PAINEL OF SERIALIZATION
     * 
     * Read the comments after enum before any change!
     */
    
    TASK {@Override public boolean switchFactory() {return true;}

        @Override
        public RegistersDAO getRegister() {
            return AplicacaoPOT.getInstance().getPlataforma().getRegistoTarefa();
        }
    },
    FREELANCER  {@Override public boolean switchFactory(){return true;}

        @Override
        public RegistersDAO getRegister() {
            return AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer();
        }
    },
    TRANSACTION {@Override public boolean switchFactory(){return true;}

        @Override
        public RegistersDAO getRegister() {
            return AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction();
        }
    },
    ORGANIZATION{@Override public boolean switchFactory(){return false;}

        @Override
        public RegistersDAO getRegister() {
            return AplicacaoPOT.getInstance().getPlataforma().getRegisterOrganisation();
        }
    };
    
    /**
     * Determine with the object will be serialized and persisted or not
     * @return true - the object will be persisted | false - the object will not be persisted
     */
    public abstract boolean switchFactory(); 
    
    /**
     * Determine the apropriate RegisterDAO to the object. This limit the use os reflecions
     * methods at the application.
     * @return apropriate RegisteDAO to the object.
     */
    public abstract RegistersDAO getRegister();

}

