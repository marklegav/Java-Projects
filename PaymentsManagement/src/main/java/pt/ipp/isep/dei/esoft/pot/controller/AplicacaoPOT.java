/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.model.Collaborator;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Manager;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.factory.CoreApp;


/**
 *
 * @author paulomaio
 */
public class AplicacaoPOT
{
       
    private final Platform m_oPlataforma;
    private final AutorizacaoFacade m_oAutorizacao;
    
    private AplicacaoPOT()
    {
        Properties props = getProperties();
        this.m_oPlataforma = new Platform(props.getProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO));
        this.m_oAutorizacao = this.m_oPlataforma.getAutorizacaoFacade();
        bootstrap();
        System.out.println(props.getProperty("API.sendEmail.Class").replaceAll("\"", ""));
        this.m_oPlataforma.setEmailAPI(props.getProperty("API.sendEmail.Class").replaceAll("\"", ""));
    }
    
    public Platform getPlataforma()
    {
        return this.m_oPlataforma;
    }
    

    public SessaoUtilizador getSessaoAtual()
    {
        return this.m_oAutorizacao.getSessaoAtual();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
       return this.m_oAutorizacao.doLogin(strId,strPwd) != null;
    }
    
    public void doLogout()
    {
        this.m_oAutorizacao.doLogout();
    }
    
    private Properties getProperties()
    {
        Properties props = new Properties();
        
        // Adiciona propriedades e valores por omissão
        props.setProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO, "Task for Joe");

        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constantes.PARAMS_FICHEIRO);
            System.out.println(in);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {
            
        }
        return props;
    }

    public void setContext(){
        CoreApp context = new CoreApp();
        context.setContext(this.m_oPlataforma);
    }
    private void bootstrap()
    {
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_GESTOR_ORGANIZACAO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_COLABORADOR_ORGANIZACAO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 1", "adm1@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaUtilizadorComPapel("Administrativo 2", "adm2@esoft.pt", "123456",Constantes.PAPEL_ADMINISTRATIVO);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 1", "free1@esoft.pt", "123456",Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaUtilizadorComPapel("Freelancer 2", "free2@esoft.pt", "123456",Constantes.PAPEL_FREELANCER);
        
        this.m_oAutorizacao.registaUtilizadorComPapel("MA ADM", "ma1@esoft.pt", "123",Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaUtilizadorComPapel("MA Col", "ma2@esoft.pt", "123",Constantes.PAPEL_COLABORADOR_ORGANIZACAO);
        this.m_oAutorizacao.registaUtilizadorComPapel("Marcel Gavioli", "mkg@esoft.pt", "123",Constantes.PAPEL_GESTOR_ORGANIZACAO);
        
        this.m_oAutorizacao.registaUtilizadorComPapeis("Martim", "martim@esoft.pt", "123456",new String[] {Constantes.PAPEL_FREELANCER, Constantes.PAPEL_ADMINISTRATIVO});
        
        Organization org = new Organization("BangBang Software Engineering Inc.", 123456789, new Collaborator("MA Col", "ma2@esoft.pt"), new Manager("Marcel Gavioli","mkg@esoft.pt"));
        this.m_oPlataforma.getRegisterOrganisation().registerOrganisation(org);
        
        
        Organization org2 = this.m_oPlataforma.getRegisterOrganisation().getCompanByLogin("ma2@esoft.pt");
        System.out.println(org);
    }
    
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static AplicacaoPOT singleton = null;
    public static AplicacaoPOT getInstance() 
    {
        if(singleton == null) 
        {
            synchronized(AplicacaoPOT.class) 
            { 
                singleton = new AplicacaoPOT();
            }
        }
        return singleton;
    }
    



    
}
