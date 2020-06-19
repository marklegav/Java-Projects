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
public class RegisterPerformanceIndicators extends RegistersDAO implements Serializable {

    private List<Task> listOfTasks = new ArrayList();

    public RegisterPerformanceIndicators() {
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
        System.out.println(task);

        return task;
    }

    public Task getTaskByID(String id) {

        for (Task task : this.listOfTasks) {
            if (id == task.getID()) {
                return task;
            }
        }

        return null;
    }
    
    public void update(){
        super.update(FactoryType.TASK.toString().toLowerCase()+".bin",this.listOfTasks);
    }

}
