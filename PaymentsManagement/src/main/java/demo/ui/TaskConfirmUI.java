/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.CriarTarefaController;

/**
 * FXML Controller class
 *
 * @author Matheus
 */
public class TaskConfirmUI implements Initializable {
    
    private CriarTarefaController controller;
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    
    @FXML
    private Label fieldID;
    
    @FXML
    private Label fieldCost;
    
    @FXML
    private Label fieldDuration;
    
    @FXML
    private Label fieldTaskCategory;
    
    @FXML
    private Label fieldDescription;
    

    @FXML
    private Label lblwarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = new CriarTarefaController();
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        lblwarning.setText("Do you confirm the introduced data?");
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setID(String txt) {
        this.fieldID.setText(txt);
    }
    
    public void setCost(String txt) {
        this.fieldCost.setText(txt);
    }
    
    public void setDuration(String txt) {
        this.fieldDuration.setText(txt);
    }
    
    public void setTaskCategory(String txt) {
        this.fieldTaskCategory.setText(txt);
    }
    
    public void setDescription(String txt) {
        this.fieldDescription.setText(txt);
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
            CreateTaskUI back = (CreateTaskUI) this.mainApp.replaceSceneContent("/fxml/CreateTask.fxml");
            back.setMainApp(mainApp);
            back.setID(this.fieldID.getText());
            back.setCost(this.fieldCost.getText());
            back.setDuration(this.fieldDuration.getText());
            back.setTaskCategory(this.fieldTaskCategory.getText());
            back.setDescription(this.fieldDescription.getText());
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnConfirm(ActionEvent event) throws IOException, Exception {
        this.controller.newTask(this.fieldID.getText(),this.fieldDescription.getText(), Integer.parseInt(this.fieldDuration.getText()),
                                Double.parseDouble(this.fieldCost.getText()),  this.fieldTaskCategory.getText() );
        
        
        if (this.controller.registaTarefa()) {
            try {
                TaskAlertUI alert = (TaskAlertUI) this.mainApp.replaceSceneContent("/fxml/TaskAlert.fxml");
                alert.setMainApp(this.mainApp);
            } catch (Exception ex) {
                    throw ex;
            }
        }
    }
    
}
