/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

/**
 *
 * @author paulomaio
 */
public class Constantes
{
    public static final String PAPEL_ADMINISTRATIVO = "ADMINISTRATIVO";
    public static final String PAPEL_COLABORADOR_ORGANIZACAO = "COLABORADOR_ORGANIZACAO";
    public static final String PAPEL_GESTOR_ORGANIZACAO = "GESTOR_ORGANIZACAO";
    public static final String PAPEL_FREELANCER = "FREELANCER";
    
    public static final String PARAMS_FICHEIRO = "src/main/resources/config/config.properties";
    public static final String PARAMS_PLATAFORMA_DESIGNACAO = "Plataforma.Designacao";
    
    public static final String PARAMS_LOAD_TRANSACTION = "TransID;TaskID;TaskDescription;TaskAssignDuration(h);TaskCostPerHour(euros);TaskCategory;ExecutionFinishDate;ExecutionDelay (hours);ExecutionBriefDescription;FreelancerID;FreelancerName;FreelancerExpertise;FreelancerEMail;FreelancerNIF;FreelancerBanckAccout;FreelancerAddress;FreeLancerCountry";
    //public static final String PARAMS_LOAD_TRANSACTION = "Plataforma.LayoutLoadFile.Designation";
    
    //localização das variáveis na matriz
    public static final int TASK_ID = 1;
    public static final int TASK_DESCRIPTION = 2;
    public static final int TASK_ASSIGNDURATION = 3;
    public static final int TASK_COST = 4;
    public static final int TASK_CATEGORY = 5;
    
    //localização das variáveis na matriz
    public static final int FREELANCER_RANGE_START = 9;
    public static final int FREELANCER_RANGE_END = 16;
    public static final int FREELANCER_ID = 9;
    public static final int FREELANCER_NAME = 10;
    public static final int FREELANCER_EXPERTISE = 11;
    public static final int FREELANCER_EMAIL = 12;
    public static final int FREELANCER_NIF = 13;
    public static final int FREELANCER_BANKACCT = 14;
    public static final int FREELANCER_ADDRESS = 15;
    public static final int FREELANCER_CONTRY = 16;
    
    //localização das variáveis na matriz
    public static final int TRANSACTION_ID = 0;
    public static final int TRANSACTION_FINISHDATE = 6;
    public static final int TRANSACTION_EXECDELAY = 7;
    public static final int TRANSACTION_DESCRIPTION = 8;
    
}
