/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Platform;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTask;
import pt.ipp.isep.dei.esoft.pot.model.Task;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Matheus Aguiar
 */
public class CriarTarefaController {
    
    private RegisterTask registoTarefa;
    private Task task;
    private Organization org;
    private Platform oPlatform;
    
    public CriarTarefaController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Unauthorized User.");
        }
        this.oPlatform = AplicacaoPOT.getInstance().getPlataforma();
        this.registoTarefa = this.oPlatform.getRegistoTarefa();
    }
    
    public boolean newTask(String strID, String strDescricaoBreve, int duracao, double custo,String strCategoriaTarefa) {
        try {
            String emailColab = AplicacaoPOT.getInstance().getSessaoAtual().getEmailUtilizador();
            this.org = this.oPlatform.getRegisterOrganisation().getCompanByLogin(emailColab);
            task = registoTarefa.newTarefa(strID, strDescricaoBreve, duracao, custo, strCategoriaTarefa, org.getNIF());
            return this.registoTarefa.validaTarefa(task);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.task = null;
            return false;
        }
    }
    
    public boolean registaTarefa() {
        return  this.registoTarefa.registaTarefa(task);
    }

    public String getTarefaString() {
        return this.task.toString();
    }
    
    public List<Task> getListTarefa() {
        
        List<Task> listTarefa = registoTarefa.getListaTarefa();
        return listTarefa;
    }
    
}
