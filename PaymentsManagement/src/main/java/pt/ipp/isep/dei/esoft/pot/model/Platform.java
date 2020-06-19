/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.autorizacao.model.password.PasswordAlgorithm;
import pt.ipp.isep.dei.esoft.pot.utils.NotifyUser;
import pt.ipp.isep.dei.esoft.pot.utils.Statistics;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform {

    private String m_strDesignacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private final Set<Organization> m_lstOrganizacoes;
    private RegisterOrganisation m_rOrgan;
    private RegisterFreelancer registoFreelancer;
    private RegisterTask registoTarefa;
    private RegisterTransaction registerTransaction;
    private RegisterLoadTransaction rLoadTransaction;
    private PasswordAlgorithm pwdAlg;
    private SendEmail apiEmail;
    
    
    public Platform(String strDesignacao) {
        
        if ((strDesignacao == null) || (strDesignacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        
        this.registoFreelancer = new RegisterFreelancer();
        this.m_strDesignacao = strDesignacao;
        this.m_oAutorizacao = new AutorizacaoFacade();
        this.m_lstOrganizacoes = new HashSet<>();
        this.m_rOrgan = new RegisterOrganisation(m_oAutorizacao);
        this.registoTarefa = new RegisterTask();
        this.registoTarefa = new RegisterTask();
        this.rLoadTransaction = new RegisterLoadTransaction();
        this.registerTransaction = new RegisterTransaction();

    }
    
    public Statistics getStatistics() {
        return new Statistics();
    }
    
    public void scheduleMakePayments() {
        TimerTask makePayments = new MakePaymentsTask();
        Timer timer = new Timer();
        Date today = Calendar.getInstance().getTime();
        timer.schedule(makePayments, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
    
    public void schedulesNotifyFreelancer() {
        TimerTask notifyFreel = new NotifyFreelancerTask();
        Timer timer = new Timer();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        Date date = new Date(year, 12, 31);
        
        int days = 365;
        
        if (year % 4 == 0) {
            days = 366;
        }
        
        timer.schedule(notifyFreel, date, TimeUnit.DAYS.toMillis(days));
    }
    
    public SendEmail getEmailAPI() {
        return this.apiEmail;
    }
    public void setEmailAPI(String classe) {
        System.out.println(classe);
        SendEmail api = null;
        try {
            Class<?> oClass = Class.forName(classe);
            api =  (SendEmail) oClass.newInstance();
            this.apiEmail=api;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.apiEmail=api;
    }
    public PasswordAlgorithm getPwdAlgorithm(){
        return this.pwdAlg;
    }
    
    public void setPwdAlgorithm(String classe){
        this.pwdAlg = null;
        try {
            Class<?> oClass = Class.forName(classe);
            this.pwdAlg =  (PasswordAlgorithm) oClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RegisterOrganisation  getRegisterOrganisation(){
        return m_rOrgan;
    }
    
    public RegisterLoadTransaction getRegisterLoad() {
        return this.rLoadTransaction;
    }

    public AutorizacaoFacade getAutorizacaoFacade() {
        return this.m_oAutorizacao;
    }

    public Organization getCompanyByUserEmail(String email) {
        for (Organization org : m_lstOrganizacoes) {
            if (org.hasCollaboratorWithEmail(email)) {
                return org;
            }
        }
        return null;
    }
    
    public RegisterFreelancer getRegisterFreelancer() {
        return this.registoFreelancer;
    }
    
   public RegisterTask getRegistoTarefa() {
        return this.registoTarefa;
    }
   
      //Transaction
   // <editor-fold defaultstate="collapsed">
    public RegisterTransaction getRegisterTransaction(){
        return this.registerTransaction;
    }
    
    // </editor-fold>
   
//    // Tarefas
//    // <editor-fold defaultstate="collapsed">
//
//    public Task novaTarefa(String strID, String strDescricaoBreve, int duracao, double custo, String strCategoriaTarefa) {
//        return new Task(strID, strDescricaoBreve, duracao, custo, strCategoriaTarefa);
//    }
//
//    public boolean registaTarefa(Task oTarefa) {
//        if (this.validaTarefa(oTarefa)) {
//            return addTarefa(oTarefa);
//        }
//        return false;
//    }
//
//    private boolean addTarefa(Task oTarefa) {
//        return m_lstTarefa.add(oTarefa);
//    }
//
//    public boolean validaTarefa(Task oTarefa) {
//        boolean bRet = true;
//
//        //Criar Validação por ID 
//        
//        
//        return bRet;
//    }
//
//    public List<Tarefa> getTarefa() {
//        List<Tarefa> trf = new ArrayList<>();
//        trf.addAll(this.m_lstTarefa);
//        return trf;
//    }
//
//    // </editor-fold>

   
}
