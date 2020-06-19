/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.LoadTransactionController;
import pt.ipp.isep.dei.esoft.pot.model.LoadTransaction;

/**
 *
 * @author Marcel - 1191396
 */
public class LoadTransactionUI implements Initializable{
    
    private LoadTransactionController controller;
    
    private File  fileName;
    
    private LoadTransaction oLoad;
    
    private MainApp mainApp;
    
    @FXML
    private Label lblOrganization;
    
    @FXML
    private Label lblColab;
    
    @FXML
    private Label lblLogID;
    
    @FXML
    private Label lblUserName;
    
    @FXML
    private AnchorPane achorPane;
    
    @FXML
    private Label lblFileName;
    
    @FXML
    private Label lblwarning;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        this.controller = new LoadTransactionController();
        this.oLoad = this.controller.newLoadTransaction();
        lblOrganization.setText(this.oLoad.getOrg());
        lblColab.setText(this.oLoad.getEmailColab());
        this.lblLogID.setText(this.oLoad.getLog());
        
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
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
    private void btnConfirm(ActionEvent event) throws Exception {
        if (checkFields()) {
            try {
                this.controller.addFile(this.lblFileName.getText());
                this.controller.createPaymentTransactionByFile();
                LoadTransactionAlertUI alert = (LoadTransactionAlertUI) this.mainApp.replaceSceneContent("/fxml/LoadTransactionAlert.fxml");
                alert.setMainApp(this.mainApp);
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            lblwarning.setText("Please select a valid file to proceed.");
        }
    }
    
    @FXML
    private boolean checkFields(){
        return this.fileName != null;
    }
    
    @FXML
    private void btnFileChooser(ActionEvent event) {
        this.lblwarning.setText("");
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load Payment Transaction by file");
            Stage stage = (Stage) achorPane.getScene().getWindow();
            this.fileName  = (File) fileChooser.showOpenDialog(stage);
            this.lblFileName.setText(fileName.getPath());   
        } catch (Exception ex) {
            lblwarning.setText("Please select a valid file to proceed.");
        }
    }
    
}
