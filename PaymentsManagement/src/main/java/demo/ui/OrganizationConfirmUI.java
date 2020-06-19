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
import pt.ipp.isep.dei.esoft.pot.controller.RegistarOrganizacaoController;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class OrganizationConfirmUI implements Initializable {
    
    private RegistarOrganizacaoController controller;
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private Label lblDesignation;
    @FXML
    private Label lblNIF;
    @FXML
    private Label lblManagerName;
    @FXML
    private Label lblCollaboratorName;
    @FXML
    private Label lblManagerEmail;
    @FXML
    private Label lblCollaboratorEmail;
    @FXML
    private Label lblwarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = new RegistarOrganizacaoController();
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        lblwarning.setText("Do you confirm the introduced data?");
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setDesignation(String txt) {
        this.lblDesignation.setText(txt);
    }
    
    public void setNIF(String txt) {
        this.lblNIF.setText(txt);
    }
    
    public void setManagerName(String txt) {
        this.lblManagerName.setText(txt);
    }
    
    public void setManagerEmail(String txt) {
        this.lblManagerEmail.setText(txt);
    }
    
    public void setCollaboratorName(String txt) {
        this.lblCollaboratorName.setText(txt);
    }
    
    public void setCollaboratorEmail(String txt) {
        this.lblCollaboratorEmail.setText(txt);
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
    private void btnGoBack(ActionEvent event) {
        try {
            CreateOrganizationUI back = (CreateOrganizationUI) this.mainApp.replaceSceneContent("/fxml/CreateOrganization.fxml");
            back.setMainApp(mainApp);
            back.setDesignation(this.lblDesignation.getText());
            back.setNIF(this.lblNIF.getText());
            back.setManagerName(this.lblManagerName.getText());
            back.setManagerEmail(this.lblManagerEmail.getText());
            back.setCollaboratorName(this.lblCollaboratorName.getText());
            back.setCollaboratorEmail(this.lblCollaboratorEmail.getText());
        } catch (Exception ex) {
            System.out.println("Error opening scene: CreateOrganization.fxml");
        }
    }

  

    

  @FXML
    private void btnConfirm(ActionEvent event) {
controller.novaOrganizacao(lblDesignation.getText(), Integer.SIZE, lblManagerName.getText(), lblManagerEmail.getText(), lblCollaboratorName.getText(), lblCollaboratorEmail.getText());
       if(controller.registerOrganization()){    
try {
                OrganizationAlertUI alert = (OrganizationAlertUI) this.mainApp.replaceSceneContent("/fxml/OrganizationAlert.fxml");
                alert.setMainApp(this.mainApp);
            } catch (Exception ex) {
                System.out.println("Error opening scene: OrganizationAlert.fxml"+ex.getMessage());
            
            }
       }
    }
    
}
