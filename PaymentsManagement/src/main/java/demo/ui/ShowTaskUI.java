/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Task;

/**
 * FXML Controller class
 *
 * @author Matheus Aguiar
 */
public class ShowTaskUI implements Initializable {

    @FXML
    private Label lblUserName;
    @FXML
    private Label lblwarning;
    @FXML
    private ListView<String> listTasks;
    
    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> tasksToShow = new ArrayList<>();
        List<Task> tarefas = AplicacaoPOT.getInstance().getPlataforma().getRegistoTarefa().getListaTarefa();
        for (Task trf : tarefas) {
            tasksToShow.add(trf.toString());
        }
        ObservableList<String> items = FXCollections.observableArrayList(tasksToShow);
        listTasks.setItems(items);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnLogout(ActionEvent event) throws Exception {
        AplicacaoPOT.getInstance().doLogout();
        try {
            MainUI main = (MainUI) this.mainApp.replaceSceneContent("/fxml/Main.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnGoBack(ActionEvent event) throws Exception {
        try {
            MenuColaboradorUI menu = (MenuColaboradorUI) this.mainApp.replaceSceneContent("/fxml/MenuColaborador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }
    
}
