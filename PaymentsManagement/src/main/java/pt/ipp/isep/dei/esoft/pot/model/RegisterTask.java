/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.RegistersDAO;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;

/**
 *
 * @author Matheus Aguiar
 */
public class RegisterTask extends RegistersDAO implements Serializable {

    private List<Task> listOfTasks = new ArrayList();

    public RegisterTask() {
    }

    public Task newTarefa(String strID, String strDescricaoBreve, int duracao, double custo, String strCategoriaTarefa, String orgNIF) {
        return new Task(strID, strDescricaoBreve, duracao, custo, strCategoriaTarefa, orgNIF);

    }

    public boolean registaTarefa(Task task) {
        if (this.validaTarefa(task)) {
            
            return addTarefa(task);

        }
        return false;
    }

    private boolean addTarefa(Task task) {

        listOfTasks.add(task);
        update();
        return true;
    }

    public boolean validaTarefa(Task task) {
        return true;
    }

    public List<Task> getListaTarefa() {
        List<Task> task = new ArrayList<>();
        task.addAll(this.listOfTasks);

        return task;
    }

    public Task getTaskByID(String id) {
        for (Task task : this.listOfTasks) {
            if (id.equals(task.getID())) {
                return task;
            }
        }
        return null;
    }
    
    /**
     * Recive an organizations's NIF and return the organization's task list
     * @param orgNIF organization's NIF
     * @return list of task
     */
    public List<Task> getTaskByOrganization(String orgNIF){
        List<Task> lst = new ArrayList();
        for(Task tsk : this.listOfTasks){
            if(tsk.getOrgNIF().equals(orgNIF)){
                lst.add(tsk);
            }
        }
        return lst;
    }
    
    /**
     * call super method to serialize the changes in list of tasks
     */
    public void update(){
        super.update(FactoryType.TASK.toString().toLowerCase()+".bin",this.listOfTasks);
    }

}
