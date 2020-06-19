/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.objects.NativeString.trim;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 * FXML Controller class
 *
 * @author Matheus Aguiar
 */
public class CreateTaskUI implements Initializable {
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldCost;
    @FXML
    private TextField fieldDuration;
    @FXML
    private TextField fieldTaskCategory;
    @FXML
    private TextField fieldDescription;

    @FXML
    private Label lblwarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
/**
 * Action to logout
 * @param event
 * @throws Exception 
 */
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
/**
 * Action to get back to main 
 * @param event
 * @throws Exception 
 */
    @FXML
    private void btnCancel(ActionEvent event) throws Exception {
        try {
            MenuColaboradorUI menu = (MenuColaboradorUI) this.mainApp.replaceSceneContent("/fxml/MenuColaborador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
            throw ex;
        }
    }
/**
 * Action to 
 * @param event
 * @throws Exception 
 */
    @FXML
    private void btnNext(ActionEvent event) throws Exception {
        if (checkFields() == true) {
            try {
                TaskConfirmUI confirm = (TaskConfirmUI) this.mainApp.replaceSceneContent("/fxml/TaskConfirms.fxml");
                confirm.setMainApp(mainApp);
                confirm.setID(this.fieldID.getText());
                confirm.setCost(trim(this.fieldCost.getText()));
                confirm.setDuration(trim(this.fieldDuration.getText()));
                confirm.setDescription(this.fieldDescription.getText());
                confirm.setTaskCategory(this.fieldTaskCategory.getText());

            } catch (Exception ex) {
                throw ex;
            }
        } else {
            lblwarning.setText("Some fields are invalid. Please try again.");
        }
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

    public void setDescription(String txt) {
        this.fieldDescription.setText(txt);
    }

    public void setTaskCategory(String txt) {
        this.fieldTaskCategory.setText(txt);
    }

    private boolean checkFields() {
        return checkID() == true
                && checkCost() == true
                && checkDuration() == true
                && checkDescription() == true
                && checkTaskCategory() == true;
    }

    private boolean checkID() {
        String id = fieldID.getText();
        return !(id == null || id.isEmpty());
    }

    private boolean checkCost() {
        double cost = Double.parseDouble(fieldCost.getText());
        return !(cost <= 0 );
    }

    private boolean checkDuration() {
        int duration = Integer.parseInt(fieldDuration.getText());
        return !(duration <=0);
    }

    private boolean checkDescription() {
        String desc = fieldDescription.getText();
        return !(desc == null || desc.isEmpty());
    }

    private boolean checkTaskCategory() {
        String ct = fieldTaskCategory.getText();
        return !(ct == null || ct.isEmpty());
    }
}
