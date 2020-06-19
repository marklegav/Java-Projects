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
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.NotifyFreelancerController;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class NotifyFreelancersNowUI implements Initializable {

    private MainApp mainApp;
    
    private NotifyFreelancerController controller;
    
    @FXML
    private Label lblUserName;
    @FXML
    private Label lblWarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.controller = new NotifyFreelancerController();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnLogout(ActionEvent event) {
        AplicacaoPOT.getInstance().doLogout();
        try {
            MainUI main = (MainUI) this.mainApp.replaceSceneContent("/fxml/Main.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene Main.fxml" + ex.getMessage());
        }
    }

    @FXML
    private void btnGoBack(ActionEvent event) {
        try {
            NotifyFreelancerUI menu = (NotifyFreelancerUI) this.mainApp.replaceSceneContent("/fxml/NotifyFreelancer.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene NotifyFreelancer.fxml" + ex.getMessage());
        }
    }

    @FXML
    private void btnConfirm(ActionEvent event) {
        this.controller.notifyFreelancersNow();
        try {
            NotifyAlertUI alert = (NotifyAlertUI) this.mainApp.replaceSceneContent("/fxml/NotifyAlert.fxml");
                alert.setMainApp(this.mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene NotifyAlert.fxml" + ex.getMessage());
        }
    }
    
}
