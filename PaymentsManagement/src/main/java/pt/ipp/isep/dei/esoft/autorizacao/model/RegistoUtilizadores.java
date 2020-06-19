/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pt.ipp.isep.dei.esoft.pot.model.RegistersDAO;
import pt.ipp.isep.dei.esoft.pot.utils.Empacotamento;

/**
 *
 * @author paulomaio
 */
public class RegistoUtilizadores extends RegistersDAO implements Serializable {
    private List<Utilizador> m_lstUtilizadores = new ArrayList();
    
    
    public RegistoUtilizadores(){
        this.m_lstUtilizadores.addAll((List<Utilizador>)(Object)Empacotamento.lerArquivoBinario("users.bin"));
    }
    public Utilizador novoUtilizador(String strNome, String strEmail, String strPassword)
    {
        return new Utilizador(strNome,strEmail,strPassword);
    }
    
    public boolean addUtilizador(Utilizador utlz)
    {
        if (utlz != null){
            boolean result = this.m_lstUtilizadores.add(utlz);
            if(result){
                Empacotamento.gravarArquivoBinario((List<Object>)(Object) this.m_lstUtilizadores, "users.bin");
                return result;
            }
        }
        return false;
    }
    
    public boolean removeUtilizador(Utilizador utlz)
    {
        if (utlz != null)
            return this.m_lstUtilizadores.remove(utlz);
        return false;
    }
    
    public Utilizador procuraUtilizador(String strId)
    {
        for(Utilizador utlz: this.m_lstUtilizadores)
        {
            if(utlz.hasId(strId))
                return utlz;
        }
        return null;
    }
    
    public boolean hasUtilizador(String strId)
    {
        Utilizador utlz = procuraUtilizador(strId);
        if (utlz != null)
            return this.m_lstUtilizadores.contains(utlz);
        return false;
    }
    
    public boolean hasUtilizador(Utilizador utlz)
    {
        return this.m_lstUtilizadores.contains(utlz);
    }
    
}
