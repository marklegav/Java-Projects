/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.CreateFreelancerController;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class FreelancerConfirmUI implements Initializable {
    
    private CreateFreelancerController controller;
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    
    @FXML
    private Label fieldNIF;
    
    @FXML
    private Label fieldName;
    
    @FXML
    private Label fieldIBAN;
    
    @FXML
    private Label fieldLevelOfExpertise;
    
    @FXML
    private Label fieldAddress;
    
    @FXML
    private Label fieldEmail;
    
    @FXML
    private Label fieldCountry;
    
    @FXML
    private Label lblwarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = new CreateFreelancerController();
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        lblwarning.setText("Do you confirm the introduced data?");
    }
    
    public LevelOfExpertise getLevel(String txt) {
        LevelOfExpertise level = null;
        if (txt.equalsIgnoreCase("JUNIOR")) {
            level = LevelOfExpertise.JUNIOR;
        } else if (txt.equalsIgnoreCase("SENIOR")) {
            level = LevelOfExpertise.SENIOR;
        }
        return level;
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setName(String txt) {
        this.fieldName.setText(txt);
    }
    
    public void setLevel(String txt) {
        this.fieldLevelOfExpertise.setText(txt);
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
        this.fieldCountry.setText(txt);
    }

    @FXML
    private void btnLogout(ActionEvent event) {
        AplicacaoPOT.getInstance().doLogout();
        try {
            MainUI main = (MainUI) this.mainApp.replaceSceneContent("/fxml/Main.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: Main.fxml");
        }
    }

    @FXML
    private void btnGoBack(ActionEvent event) throws Exception {
        try {
            CreateFreelancerUI back = (CreateFreelancerUI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer.fxml");
            back.setMainApp(mainApp);
            back.setName(this.fieldName.getText());
            back.setLevel(this.fieldLevelOfExpertise.getText());
            back.setEmail(this.fieldEmail.getText());
            back.setNIF(this.fieldNIF.getText());
            back.setIBAN(this.fieldIBAN.getText());
            back.setAddress(this.fieldAddress.getText());
            back.setCountry(this.fieldCountry.getText());
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnConfirm(ActionEvent event) throws IOException, Exception {
        this.controller.newFreelancer(this.fieldName.getText(), getLevel(this.fieldLevelOfExpertise.getText()), this.fieldEmail.getText(), this.fieldNIF.getText(), 
                this.fieldIBAN.getText(), this.fieldAddress.getText(), this.fieldCountry.getText());
        if (this.controller.registerFreelancer()) {
            try {
                FreelancerAlertUI alert = (FreelancerAlertUI) this.mainApp.replaceSceneContent("/fxml/FreelancerAlert.fxml");
                alert.setMainApp(this.mainApp);
            } catch (Exception ex) {
                    throw ex;
            }
        } else {
            this.lblwarning.setText("Freelancer is already registered, please try again.");
        }
    }
    
}
