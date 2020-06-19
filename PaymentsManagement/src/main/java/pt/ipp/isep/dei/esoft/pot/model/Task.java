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
import pt.ipp.isep.dei.esoft.pot.utils.Statistics;


/**
 *
 * @author Matheus Aguiar
 */
public class Task implements Serializable{

    private String m_strID;
    private String m_strDescricaoBreve;
    private int m_duracao;
    private double m_custo;
    private String m_strCategoriaTarefa;
    private String orgNIF;
    
   
/**
 * 
 * @param strID
 * @param strDescricaoBreve
 * @param duracao
 * @param custo
 * @param strCategoriaTarefa
 * @param orgNIF 
 */
    public Task(String strID, String strDescricaoBreve, int duracao, double custo, String strCategoriaTarefa, String orgNIF) {

        if ((strID == null) || (strDescricaoBreve == null) || (ifIntNull(duracao) == null)
                || (custo <= 0) || (strCategoriaTarefa == null)
                || (strID.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strCategoriaTarefa.isEmpty())
                || (orgNIF.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
     
        }

        this.m_strID = strID;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_duracao = duracao;
        this.m_custo = custo;
        this.m_strCategoriaTarefa = strCategoriaTarefa;
        this.orgNIF = orgNIF;
    
    }
/**
 * 
 * @return 
 */
    public int getM_duracao() {
        return m_duracao;
    }
/**
 * 
 * @return 
 */
    public double getM_custo() {
        return m_custo;
    }
    /**
     * 
     * @param strId
     * @return 
     */
    public boolean hasId(String strId) {
        return this.m_strID.equalsIgnoreCase(strId);
    }
    /**
     * 
     * @return 
     */
    public String getOrgNIF(){
        return this.orgNIF;
    }
/**
 * 
 * @return 
 */
    public String getID() {
        return this.m_strID;
    }
/**
 * 
 * @param num
 * @return 
 */
    public Integer ifIntNull(int num) {
        Integer a = num;

        return a;
    }
/**
 * 
 * @param o
 * @return 
 */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Task obj = (Task) o;
        return (Objects.equals(m_strID, obj.m_strID));
    }

    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return String.format("ID: %s\nBrief Description: %s\nTime duration: %d hours - Cost %.2f€\nTask Category: %s\n ", 
                this.m_strID, this.m_strDescricaoBreve, this.m_duracao, this.m_custo, this.m_strCategoriaTarefa);
        
        
        
    }


    
    
    
}
