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
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 *
 * @author Rita
 */
public class CreateOrganizationUI implements Initializable {
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private TextField fieldDesignation;
    @FXML
    private TextField fieldNIF;
    @FXML
    private TextField fieldManagerName;
    @FXML
    private TextField fieldCollaboratorName;
    @FXML
    private TextField fieldManagerEmail;
    @FXML
    private TextField fieldCollaboratorEmail;
    @FXML
    private Label lblwarning;

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
            System.out.println("Error opening scene: MenuAdministrador.fxml");
        }
    }

    @FXML
    private void btnNext(ActionEvent event) {
        if (checkFields() == true) {
            try {
                OrganizationConfirmUI confirm = (OrganizationConfirmUI) this.mainApp.replaceSceneContent("/fxml/OrganizationConfirms.fxml");
                confirm.setMainApp(mainApp);
                confirm.setDesignation(this.fieldDesignation.getText());
                confirm.setNIF(this.fieldNIF.getText());
                confirm.setManagerName(this.fieldManagerName.getText());
                confirm.setManagerEmail(this.fieldManagerEmail.getText());
                confirm.setCollaboratorName(this.fieldCollaboratorName.getText());
                confirm.setCollaboratorEmail(this.fieldCollaboratorEmail.getText());
            } catch (Exception ex) {
                System.out.println("Error opening scene: OrganizationConfirms.fxml");
            }
        } else {
            lblwarning.setText("Some fields are invalid. Please try again.");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setDesignation(String txt) {
        this.fieldDesignation.setText(txt);
    }
    
    public void setNIF(String txt) {
        this.fieldNIF.setText(txt);
    }
    
    public void setManagerName(String txt) {
        this.fieldManagerName.setText(txt);
    }
    
    public void setManagerEmail(String txt) {
        this.fieldManagerEmail.setText(txt);
    }
    
    public void setCollaboratorName(String txt) {
        this.fieldCollaboratorName.setText(txt);
    }
    
    public void setCollaboratorEmail(String txt) {
        this.fieldCollaboratorEmail.setText(txt);
    }
    
    public boolean checkFields()  {
        return checkDesignation() == true 
                && checkNIF() == true
                && checkManagerName() == true
                && checkManagerEmail() == true
                && checkCollaboratorName() == true
                && checkCollaboratorEmail() == true;
    }
    
    public boolean checkDesignation() {
        String designation = this.fieldDesignation.getText();
        return !(designation == null || designation.isEmpty());
    }
    
    public boolean checkNIF() {
        Integer  nif = this.fieldNIF.getLength();
        return !(nif <=0);
    }
    
    public boolean checkManagerName() {
        String managerName = this.fieldManagerName.getText();
        return !(managerName == null || managerName.isEmpty());
    }
    
    public boolean checkManagerEmail() {
        String managerEmail = this.fieldManagerEmail.getText();
        return !(managerEmail == null || managerEmail.isEmpty());
    }
    
    public boolean checkCollaboratorName() {
        String collaboratorName = this.fieldCollaboratorName.getText();
        return !(collaboratorName == null || collaboratorName.isEmpty());
    }
    
    public boolean checkCollaboratorEmail() {
        String collaboratorEmail = this.fieldCollaboratorEmail.getText();
        return !(collaboratorEmail == null || collaboratorEmail.isEmpty());
    }
    
}
