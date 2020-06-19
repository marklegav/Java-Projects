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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class NotifyFreelancerUI implements Initializable {

    private MainApp mainApp;
    
    @FXML
    private Label lblUserName;
    private TextField date;
    @FXML
    private Button btnNotifyFreelancersNow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            System.out.println("Error opening scene Main.fxml");
        }
    }

    @FXML
    private void btnCancel(ActionEvent event) {
        try {
            MenuAdministradorUI menu = (MenuAdministradorUI) this.mainApp.replaceSceneContent("/fxml/MenuAdministrador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene MenuAdministrador.fxml");
        }
    }

    @FXML
    private void btnNotifyFreelancersNow(ActionEvent event) {
        try {
            NotifyFreelancersNowUI menu = (NotifyFreelancersNowUI) this.mainApp.replaceSceneContent("/fxml/NotifyFreelancersNow.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene NotifyFreelancersNow.fxml");
        }
    }
    
}
