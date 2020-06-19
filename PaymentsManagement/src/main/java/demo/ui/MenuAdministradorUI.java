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
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class MenuAdministradorUI implements Initializable {

        
    private MainApp mainApp;
    @FXML
    private Label lblUserName;
    @FXML
    private Button btnCreateOrgan;
    
    @FXML 
    private Button btnAnalyze;
    @FXML
    private Button btnNotifyFreelancers;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        if (AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction().getFreelancers().isEmpty()) {
            this.btnAnalyze.setDisable(true);
        }
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
    private void onCreateOrgan(ActionEvent event) throws Exception {
         try {
            CreateOrganizationUI menu = (CreateOrganizationUI) this.mainApp.replaceSceneContent("/fxml/CreateOrganization.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }
    
    @FXML
    private void btnAnalyze(ActionEvent event) throws Exception {
        try {
            MenuStatisticsUI pay = (MenuStatisticsUI) this.mainApp.replaceSceneContent("/fxml/MenuStatistics.fxml");
            pay.setMainApp(mainApp);
        } catch (Exception ex) {
            throw ex;    
        }
    }

    @FXML
    private void btnNotifyFreelancers(ActionEvent event) {
        try {
            NotifyFreelancerUI main = (NotifyFreelancerUI) this.mainApp.replaceSceneContent("/fxml/NotifyFreelancer.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println();
        }
    }

 
    
}
