/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTask;
import pt.ipp.isep.dei.esoft.pot.model.Task;

/**
 *
 * @author Marcel
 */
public class TaskFactory implements FactoryUpStream<Task, RegisterTask>{
    
    
    @Override
    public List<Task> fabricate(List<String[]> lst, RegisterTask rTask, String orgNIF){
        List<Task> lstTask = new ArrayList<>();
        for(int i = 0; i< lst.size();i++){
            String[] line = lst.get(i);            
            Task task =rTask.newTarefa(line[Constantes.TASK_ID], line[Constantes.TASK_DESCRIPTION],
                    Integer.parseInt(line[Constantes.TASK_ASSIGNDURATION]), 
                    Double.parseDouble(line[Constantes.TASK_COST]), 
                    line[Constantes.TASK_CATEGORY],orgNIF);
            lstTask.add(task);
        }
        return lstTask;
    }

    @Override
    public void register(List<Task> lst, RegisterTask register) {
        register.setUpdate(false); //Turn off serialization for more eficient load
        for(Task tsk : lst){
            register.registaTarefa(tsk);
        }
        register.setUpdate(true);//Turn on serialization 
        register.update();//Call serialization to save changes
    }
}
