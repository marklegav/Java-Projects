/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.NotifyFreelancerController;

/**
 *
 * @author Rita
 */
public class ScheduleNotificationUI implements Initializable {

    private MainApp mainApp;
    
    private NotifyFreelancerController controller;
    
    @FXML
    private Label lblUserName;
    @FXML
    private Label lblWarning;
    @FXML
    private TextField date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            System.out.println("Error opening scene Main.fxml");
        }
    }

    private void btnCancel(ActionEvent event) {
        try {
            MenuAdministradorUI menu = (MenuAdministradorUI) this.mainApp.replaceSceneContent("/fxml/MenuAdministrador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene MenuAdministrador.fxml");
        }
    }
    
    public boolean checkDate(String[] datex) {
        return datex.length == 5;
    }

    @FXML
    private void btnGoBack(ActionEvent event) {
        try {
            NotifyFreelancerUI menu = (NotifyFreelancerUI) this.mainApp.replaceSceneContent("/fxml/NotifyFreelancer.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene NotifyFreelancer.fxml");
        }
    }

    @FXML
    private void btnNext(ActionEvent event) {
        String[] datex = date.getText().split("-");
        if (checkDate(datex)) {
            try {
                ScheduleNotificationConfirmUI confirm = (ScheduleNotificationConfirmUI) this.mainApp.replaceSceneContent("/fxml/ScheduleNotificationConfirm.fxml");
                confirm.setMainApp(mainApp);
                confirm.setDate(this.date.getText());
            } catch (Exception ex) {
                System.out.println("Error opening scene ScheduleNotificationConfirm.fxml");
            }
        }
    }
    
}
