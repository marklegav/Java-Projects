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

/**
 *
 * @author arcenio
 */
public class OrganizationAlertUI implements Initializable {

    private MainApp mainApp;
    
    /**
     * Initializes the  controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void btnyay(ActionEvent event) throws Exception {
        try {
            MenuAdministradorUI menu = (MenuAdministradorUI) this.mainApp.replaceSceneContent("/fxml/MenuAdministrador.fxml");
            menu.setMainApp(this.mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }
}
