/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class CreateFreelancerUI implements Initializable {
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private TextField fieldNIF;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldIBAN;
    @FXML
    private TextField fieldAddress;
    @FXML
    private TextField fieldEmail;
    @FXML
    private ChoiceBox<String> choiceBoxCountry;
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
        choiceBoxCountry.setItems(FXCollections.observableArrayList("Brasil", "China", "Japan", "UK", "USA"));
        choiceBoxCountry.getSelectionModel().selectFirst();
        choiceBoxLevel.setItems(FXCollections.observableArrayList("Junior", "Senior"));
        choiceBoxLevel.getSelectionModel().selectFirst();
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
    private void btnCancel(ActionEvent event) throws Exception {
        try {
            MenuColaboradorUI menu = (MenuColaboradorUI) this.mainApp.replaceSceneContent("/fxml/MenuColaborador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnNext(ActionEvent event) throws Exception {
        if (checkFields() == true) {
            try {
                FreelancerConfirmUI confirm = (FreelancerConfirmUI) this.mainApp.replaceSceneContent("/fxml/FreelancerConfirms.fxml");
                confirm.setMainApp(mainApp);
                confirm.setName(this.fieldName.getText());
                confirm.setLevel(this.choiceBoxLevel.getValue());
                confirm.setEmail(this.fieldEmail.getText());
                confirm.setNIF(this.fieldNIF.getText());
                confirm.setIBAN(this.fieldIBAN.getText());
                confirm.setAddress(this.fieldAddress.getText());
                confirm.setCountry(this.choiceBoxCountry.getValue());
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            lblwarning.setText("Some fields are invalid. Please try again.");
        }
    }
    
    public void setName(String txt) {
        this.fieldName.setText(txt);
    }
    
    public void setLevel(String txt) {
        this.choiceBoxLevel.getSelectionModel().select(txt);
    }
    
    public void setEmail(String txt) {
        this.fieldEmail.setText(txt);
    }
    
    public void setNIF(String txt) {
        this.fieldNIF.setText(txt);
    }
    
    public void setIBAN(String txt) {
        this.fieldIBAN.setText(txt);
    }
    
    public void setAddress(String txt) {
        this.fieldAddress.setText(txt);
    }
    
    public void setCountry(String txt) {
    }
    
    private boolean checkFields() {
        return checkName() == true 
                && checkEmail() == true
                && checkNIF() == true
                && checkIBAN() == true
                && checkAddress() == true;
    }
    
    private boolean checkName() {
        String name = fieldName.getText();
        return !(name == null || name.isEmpty());
    }
    
    private boolean checkEmail() {
        String email = fieldEmail.getText();
        return !(email == null || email.isEmpty());
    }
    
    private boolean checkNIF() {
        String nif = fieldNIF.getText();
        if (!(nif == null || nif.isEmpty())) {
            return !nif.contains("[a-zA-Z]+");
        } else {
            return false;
        }
    }
    
    private boolean checkIBAN() {
        String iban = fieldIBAN.getText();
        return !(iban == null || iban.isEmpty());
    }
    
    private boolean checkAddress() {
        String address = fieldAddress.getText();
        if (!(address == null || address.isEmpty())) {
            String[] addressx = address.split("-");
            return addressx.length == 3;
        } else {
            return false;
        }
    }
    
}
