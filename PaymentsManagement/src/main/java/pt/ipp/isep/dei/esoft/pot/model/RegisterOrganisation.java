package pt.ipp.isep.dei.esoft.pot.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;
import pt.ipp.isep.dei.esoft.autorizacao.model.password.GeneretePassword;
import pt.ipp.isep.dei.esoft.autorizacao.model.password.PasswordAlgorithm;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
/**
 * this class will register organization
 * @author arccenio
 */
public class RegisterOrganisation extends RegistersDAO implements Serializable {

    /**
     * generate the password automatically
     */
         private GeneretePassword m;
          private sendEmailMC data;
    private List<Collaborators> lstColl = new ArrayList();   

    /** 
     * Designation
     */
    private String m_strDesignacao;
    /**
     * Autorizacao Facade
     */
    private final AutorizacaoFacade m_oAutorizacaoF;
    /**
     * Set list of organization
     */
    private final List<Organization> m_lstOrganizacoes;
    
  /**
   *     Build an instance of  Register Organization  receiving as parameter
   * @param m_oAutorizacao  Autorization
   */
    public RegisterOrganisation(AutorizacaoFacade m_oAutorizacao) {
        this.m_oAutorizacaoF = m_oAutorizacao;
           this.m=new GeneretePassword();
           this.m_lstOrganizacoes = new ArrayList<>();
            this.data=new sendEmailMC();
            


        this.m=new GeneretePassword();
        this.data=new sendEmailMC(); 
    }
    

     /**
      * On this meth we create a new organization
      * @param strNome Name of organization
      * @param strNIF Nif og organization
      * @param oColaborador name Of collaborator 
      * @param oManger name of manager
      * @return new organization
      */
    public Organization novaOrganizacao(String strNome, Integer strNIF, Collaborator oColaborador, Manager oManger) {
        return new Organization(strNome, strNIF, oColaborador, oManger);
    }
/**
 * Registe organization wthim 
 * @param oOrganizacao Organization
 * @return  add organization
 */
    public boolean registaOrganizacao(Organization oOrganizacao) {
        if (this.validaOrganizacao(oOrganizacao)) {
            Collaborator colabor = oOrganizacao.getM_Colaborador();
            String strNameC = colabor.getName();
            String strEmailCo = colabor.getEmail();
            Manager manager = oOrganizacao.getM_manager();
            String strNameM = manager.getName();
            String strEmailM = manager.getEmail();
            String pwdM=m.pwd();
             String pwdC=m.pwd();

            if (this.m_oAutorizacaoF.registaUtilizadorComPapeis(strNameC, strEmailCo, pwdC,
                    new String[]{Constantes.PAPEL_COLABORADOR_ORGANIZACAO})) {
                if (this.m_oAutorizacaoF.registaUtilizadorComPapeis(strNameM, strEmailM, pwdM,
                        new String[]{Constantes.PAPEL_GESTOR_ORGANIZACAO})) {
                                        data.sendEmail(strEmailM,pwdM, strEmailCo,pwdC);
                                                getOrganization();
                                        
                            return       m_lstOrganizacoes.add( oOrganizacao);
                }

            
    }
        }
          return false;
    }
    
//    public boolean registerEmployeeAsUser(Collaborators colab, String paper, String pwd){
//        return this.m_oAutorizacaoF.registaUtilizadorComPapel(colab.getName(), colab.getEmail(), pwd, paper);
//    }
/**
 * add organization onList of organization
 * @param oOrganizacao organization
 * @return  add organization
 */
    public boolean addOrganizacao(Organization oOrganizacao) {
        boolean result = m_lstOrganizacoes.add(oOrganizacao);
        if(result)
            update();
        return result;
    }
/**
 * Validate of organization
 * @param oOrganizacao organization
 * @return  true of false 
 */
    public boolean validaOrganizacao(Organization oOrganizacao) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        if (this.m_lstOrganizacoes.contains(oOrganizacao)) {
            bRet = false;
        }
        update();
        return bRet;
    }
    
    public Organization getCompanByLogin(String userEmail) {
        Organization oCompany = getCompanyByUserEmail(userEmail);
        return oCompany;
    }

    public Organization getCompanyByUserEmail(String email) {
        for (Organization org : m_lstOrganizacoes) {

            if (org.hasCollaboratorWithEmail(email)) {
                return org;
            }
        }
        return null;
    }
    public boolean registerOrganisation(Organization orga) {
        if (this.validaOrganizacao(orga)) {
            return addOrganizacao( orga);
        }
        return false;
    }


    public List<Organization> getOrganization() {
        List<Organization> organizations = new ArrayList();
        organizations.addAll(m_lstOrganizacoes);
        System.out.println("----");
        System.out.println(m_lstOrganizacoes.size());
        return organizations;
    }
    
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        for (Organization org : m_lstOrganizacoes) {
            for (Transaction transaction : org.getListTransaction()) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    
    
    public void update(){
        super.update(FactoryType.ORGANIZATION.toString().toLowerCase()+".bin", m_lstOrganizacoes);
    }
    
}
