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
import javafx.scene.input.MouseEvent;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 *
 * @author Rita
 */
public class MenuStatisticsUI implements Initializable {
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private Button btnPlatform;
    @FXML
    private Button btnFreelancers;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void OnStatistic(MouseEvent event) {
    }

    @FXML
    private void btnLogout(ActionEvent event) {
        AplicacaoPOT.getInstance().doLogout();
        try {
            MainUI main = (MainUI) this.mainApp.replaceSceneContent("/fxml/Main.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: Main.fxml" + ex.getMessage());
        }
    }

    @FXML
    private void btnPlatform(ActionEvent event) {
        try {
            PlatformStatisticsPaymentUI main = (PlatformStatisticsPaymentUI) this.mainApp.replaceSceneContent("/fxml/PlatformStatisticsPayment.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: PlatformStatistics.fxml" + ex.getMessage());
        }
    }

    @FXML
    private void btnFreelancers(ActionEvent event) {
        try {
            FreelancerStatisticsPaymentUI main = (FreelancerStatisticsPaymentUI) this.mainApp.replaceSceneContent("/fxml/FreelancerStatisticsPayment.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: FreelancerStatistics.fxml" + ex.getMessage());
        }
    }

    @FXML
    private void btnCancel(ActionEvent event) {
        try {
            MenuAdministradorUI main = (MenuAdministradorUI) this.mainApp.replaceSceneContent("/fxml/MenuAdministrador.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: MenuAdministrador.fxml" + ex.getMessage());
        }
    }
    
}
