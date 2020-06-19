 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;


/**
 This class represents the organization
 * @author arcenio
 */
public class Organization implements Serializable {
    /**
     * name of organization
     */
    private String m_strNome;
    /***
     * Nif of organization
     */
    private Integer m_strNIF;
    /**
     * Collaborator of organization
     */
    private Collaborator m_Colaborador;
    /**
     * Manger of organizatiion
     */
    private Manager m_manager;
    /**
     * Set list of employees (collaborator and manger)
     */
    private List<Collaborators> m_lstCollaborators= new ArrayList();
    
    //Organization's task list
    private List<Task> lstTask = new ArrayList();
    
    //Organization's transaction list
    private List<Transaction> lstTransaction = new ArrayList();
    
    //Deafault payment day
    private int payday;
    
    private static final int PAYDAY_DEFAULT = 1;
    
    private RegisterTransaction rTrans = new RegisterTransaction();

    /**
     * Build an instance of Organization  receiving as parameter
     * @param strNome name of Organization
     * @param strNIF nif of organization
     * @param oColaborador colaborator of organization
     * @param oManager  manager of colaborator
     */

    public Organization(String strNome, Integer strNIF, Collaborator oColaborador,Manager oManager)
    {
        if ( (strNome == null) || (strNIF == null)  || (oColaborador == null) ||(oManager==null)||
                ( (strNome.isEmpty()) || (strNIF)<=0))
            //TODO Validate of the number  important
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_Colaborador = oColaborador;
        this.m_manager = oManager;
        this.m_lstCollaborators.add(oColaborador) ;
        this.m_lstCollaborators.add(oManager);
        this.payday = PAYDAY_DEFAULT;
    }
    
    public String getOrgName(){
        return this.m_strNome;
    }
    
 /**
  * advisory method of colaborator
  * @return  colaborator
  */
    public Collaborator getM_Colaborador() {
        return m_Colaborador;
    }
   /**
    * advisory method of manager
    * @return 
    */
    public Manager getM_manager() {
        return m_manager;
    }
    /**
     * advisory method payDay
     * @return 
     */
    
    public int getPayDay(){
        return this.payday;
    }
    
    public String getNIF(){
        return this.m_strNIF.toString();
    }
    
    public List<Transaction> getListTransaction(){
        return this.lstTransaction;
    }
    
      public List<Task> getListTask() {
        return this.lstTask;
    }
    
    public boolean addTask(Task tsk){
        return this.lstTask.add(tsk);
    }
    
    /**
     * advisory method od payDy
     * @param payDay 
     */
    public void setPayDay(int payday){
        this.payday = payday;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
        return hash;
    }
/**
 * Compare the receved object 
 * @param o objet 
 * @return return true or false 
 */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        Organization obj = (Organization) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    @Override
    public String toString()
    {
        return "========ORGANIZACAO=========\n" +
                "Name : " + m_strNome  +
                "\n NIF : " + m_strNIF + '\'' +
                "\nColaborator\n"
                + m_Colaborador +

                "\n" + m_manager ;
    }

    /**
     * create new Collaorator
     * @param strNome name  of collaborator
     * @param strEmail email do colaborador
     * @return new  Colaborator
     */
    public static Collaborator novoColaborador(String strNome,  String strEmail)
    {
        return new Collaborator(strNome,strEmail);
    }
    public static Manager newManager(String strNome,  String strEmail)
    {
        return new Manager(strNome,strEmail);
    }
/****
 * check if there is a collaborator with that email
 * @param email email  to check
 * @return 
 */
    public boolean hasCollaboratorWithEmail(String email) {
        boolean found = false;
        for (Collaborators colab : this.m_lstCollaborators){
            found= email.equals(colab.getEmail());
            if(found){
                return found;
            }
        }
        return found;
    }
    
    public boolean validatePayDay(int payDay){
        return payDay > 0 && payDay <=28;
    }

    public List<String > getListTaskForPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
