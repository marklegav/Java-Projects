/**
 * That is the controlling class of the organization registration
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.Collaborator;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Manager;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.RegisterOrganisation;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author arcio
 */
public class RegistarOrganizacaoController
{ 
    /**
     * aplication POT
     */
    private AplicacaoPOT m_oApp;
    /**
     * Plataform
     */
    private Platform m_oPlataforma;
    /**
     * Organization
     */
    private Organization m_oOrganization;
    /**
     * the password of Colaborator
     */
    private String m_strPwd;
    /**
     * The password of manager 
     */
    private String m_strPwdM;
    /**
     * Register of organization
     */
   private RegisterOrganisation m_registe;

 /**
  * That is the controlling class of the organization registration
  */
    public RegistarOrganizacaoController()
    {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO)) {
            throw new IllegalStateException("Unauthorized User.");
        }
        this.m_registe = AplicacaoPOT.getInstance().getPlataforma().getRegisterOrganisation();
    }
    
    /**
     * Build an instance of registration Organization controller receiving as parameter
     * @param strNome  name of organization
     * @param strNIF nif of organization
     * @param nameMan name of Manager
     * @param emailMan email of manager
     * @param strPwdM password of manager
     * @param nameCol name of colaborator
     * @param emailCo email of colaborator
     * @param strpwdC passwor of colaborator
     * @return  validation
     */
    public boolean novaOrganizacao(String strNome, Integer  strNIF ,String nameMan,String emailMan,String nameCol,String emailCo)
    {
        try
        {
           
            Manager oManager=Organization.newManager(nameMan,emailMan);
            Collaborator oColab = Organization.novoColaborador( nameCol,emailCo);

            m_oOrganization = this.m_registe.novaOrganizacao(strNome, strNIF,  oColab,oManager);
            return this.m_registe.validaOrganizacao(m_oOrganization);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganization = null;
            return false;
        }
    }
    
    
    
    /**
     *  Register Organizatuon
     * @return  organization
     */
    public boolean registerOrganization()
    {
        return m_registe.registaOrganizacao(m_oOrganization);
    }
/**
 *  organization advisor with to String 
 * @return  organization
 */
    public String getOrganizationString()
    {
        return this.m_oOrganization.toString();
    }
    public List<Organization> getListOrganization() {
        List<Organization> organization = m_registe.getOrganization();
        return organization;
    }
}
