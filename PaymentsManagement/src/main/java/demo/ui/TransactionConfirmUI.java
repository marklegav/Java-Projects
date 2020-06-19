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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.CreateFreelancerController;
import pt.ipp.isep.dei.esoft.pot.controller.CreateTransactionController;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class TransactionConfirmUI implements Initializable {
    
    private CreateTransactionController controller;
    
    private MainApp mainApp;

    @FXML
    private Label lblUserName;
    @FXML
    private Label fieldDelay;
    @FXML
    private Label fieldDescription;
    @FXML
    private Label choiceBoxTaskID;
    @FXML
    private Label choiceBoxFreelancer;
    @FXML
    private Label lblwarning;
    @FXML
    private Label finishDate;
    @FXML
    private Label lblPayment;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = new CreateTransactionController();
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        lblwarning.setText("Do you confirm the introduced data?");
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
            System.out.println("Error opening scene: Main.fxml");
        }
    }

    @FXML
    private void btnGoBack(ActionEvent event) throws Exception {
        try {
            CreateTransactionUI back = (CreateTransactionUI) this.mainApp.replaceSceneContent("/fxml/CreateTransaction.fxml");
            back.setMainApp(mainApp);
                back.setDelay(this.fieldDelay.getText());
                back.setFinishDate(this.finishDate.getText());
                back.setBiefDesc(this.fieldDescription.getText());
                back.setFreelancer(this.choiceBoxFreelancer.getText());
                back.setTask(this.choiceBoxTaskID.getText());
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnConfirm(ActionEvent event) throws IOException, Exception {
        this.controller.create(this.choiceBoxTaskID.getText(), 
                this.choiceBoxFreelancer.getText(), this.finishDate.getText(), 
                Integer.parseInt(this.fieldDelay.getText()), this.fieldDescription.getText());
        if (this.controller.regiterTransation()) {
            try {
                TransactionAlertUI alert = (TransactionAlertUI) this.mainApp.replaceSceneContent("/fxml/TransactionAlert.fxml");
                alert.setMainApp(this.mainApp);
            } catch (Exception ex) {
                    throw ex;
            }
        }
    }
    
    public void setDelay(String txt) {
        this.fieldDelay.setText(txt);
    }
    
    public void setFinishDate(String txt) {
        this.finishDate.setText(txt);
    }
    
    public void setBiefDesc(String txt) {
        this.fieldDescription.setText(txt);
    }
    
    public void setTask(String txt) {
        this.choiceBoxTaskID.setText(txt);
    }
    
    public void setFreelancer(String txt) {
        this.choiceBoxFreelancer.setText(txt);
    }    
}
