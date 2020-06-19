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
 * @author Arcenio
 */
public class MenuEstatisticaUI implements Initializable {

    @FXML
    private Label lblUserName;
    
    private MainApp mainApp;

    
    @FXML
    private Button btnKPI;
    @FXML
    private Button btnSetPayDay;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        //this.btnSetPayday.setDisable(false);
        //this.btnKPI.setDisable(true);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private void btnSetPayday(ActionEvent event) throws Exception {
        try {
            PayDayUI payDay = (PayDayUI) this.mainApp.replaceSceneContent("/fxml/PayDay.fxml");
            payDay.setMainApp(mainApp);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @FXML
    private void btnLogout(ActionEvent event) {
    }
   
}
