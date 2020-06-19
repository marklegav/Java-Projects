/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.SetPaymentDayController;

/**
 * FXML Controller class
 *
 * @author Marcel Gavioli - 1191396
 */
public class PayDayUI implements Initializable {
    
    private SetPaymentDayController controller = new SetPaymentDayController();
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private TextField fieldPayDay;
    @FXML
    private Label lblwarning;
    @FXML
    private ChoiceBox<String> choiceBoxLevel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        fieldPayDay.setText(Integer.toString(controller.getPayDayofOrganization()));
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
    private void btnCancel(ActionEvent event) throws Exception {
        try {
            MenuColaboradorUI menu = (MenuColaboradorUI) this.mainApp.replaceSceneContent("/fxml/MenuColaborador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnConfirm(ActionEvent event) throws Exception {
        if (checkFields() == true) {
            try {
                PayDayConfirmUI confirm = (PayDayConfirmUI) this.mainApp.replaceSceneContent("/fxml/PayDayConfirm.fxml");
                confirm.setMainApp(mainApp);
                confirm.setPayDay(this.fieldPayDay.getText());
                
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            lblwarning.setText("Some fields are invalid. Please try again.");
        }
    }
    
    private boolean checkFields() {
        return checkPayDay() == true;
                
    }
    
    private boolean checkPayDay() {
        String payDay = fieldPayDay.getText();
        return !(payDay == null || payDay.isEmpty());
    }
    
}
