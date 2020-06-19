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
public class MenuColaboradorUI implements Initializable {

    @FXML
    private Label lblUserName;
    
    @FXML
    private Button btnCreateTask;
    
    private MainApp mainApp;
    @FXML
    private Button btnShowTasks;
    @FXML
    private Button btnShowFreelancers;
    @FXML
    private Button btnCreateTransaction;
    @FXML
    private Button btnShowTransactions;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        this.btnShowFreelancers.setDisable(AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().getFreelancers().isEmpty());
        this.btnShowTasks.setDisable(AplicacaoPOT.getInstance().getPlataforma().getRegistoTarefa().getListaTarefa().isEmpty());
        this.btnCreateTransaction.setDisable(AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().getFreelancers().isEmpty()
        || AplicacaoPOT.getInstance().getPlataforma().getRegistoTarefa().getListaTarefa().isEmpty());
        this.btnShowTransactions.setDisable(AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction().getPaymentOrders().isEmpty());
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnLoadTransaction(ActionEvent event) throws Exception {
        try {
            LoadTransactionUI loadTransaction = (LoadTransactionUI) this.mainApp.replaceSceneContent("/fxml/LoadTransaction.fxml");
            loadTransaction.setMainApp(mainApp);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @FXML
    private void btnCreateTransaction(ActionEvent event) throws Exception {
        try {
            CreateTransactionUI createTransaction = (CreateTransactionUI) this.mainApp.replaceSceneContent("/fxml/CreateTransaction.fxml");
            createTransaction.setMainApp(mainApp);
        } catch (Exception ex) {    
             throw ex;
        }
    }
    
    @FXML    
    private void tnShowTransactions(ActionEvent event) throws Exception {
        try {
            ShowTransactionsUI showTrans = (ShowTransactionsUI) this.mainApp.replaceSceneContent("/fxml/ShowTransactions.fxml");
            showTrans.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }
    
   @FXML
    private void btnCreateTask(ActionEvent event) throws Exception {
            try {
            CreateTaskUI createTask = (CreateTaskUI) this.mainApp.replaceSceneContent("/fxml/CreateTask.fxml");
            createTask.setMainApp(mainApp);
        } catch (Exception ex) {
                
                    throw ex;
                
        }
    }

    @FXML
    private void btnShowTasks(ActionEvent event) throws Exception {
           try {
            ShowTaskUI showTask = (ShowTaskUI) this.mainApp.replaceSceneContent("/fxml/ShowTask.fxml");
            showTask.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }



    @FXML
    private void btnCreateFreelancer(ActionEvent event) throws Exception {
        try {
            CreateFreelancerUI createFreel = (CreateFreelancerUI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer.fxml");
            createFreel.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnShowFreelancers(ActionEvent event) throws Exception {
        try {
            ShowFreelancersUI showFreel = (ShowFreelancersUI) this.mainApp.replaceSceneContent("/fxml/ShowFreelancers.fxml");
            showFreel.setMainApp(mainApp);
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
    private void btnAnalize(ActionEvent event) throws Exception {
           try {
            PP_UI main = (PP_UI) this.mainApp.replaceSceneContent("/fxml/FS_P.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnShowTransactions(ActionEvent event) throws Exception {
//        try {
            ShowTransactionsUI main = (ShowTransactionsUI) this.mainApp.replaceSceneContent("/fxml/ShowTransactions.fxml");
            main.setMainApp(mainApp);
//        } catch (Exception ex) {
//            System.out.println("Error opening scene: ShowTransactions.fxml" + ex.getMessage());
//        }
    }
    
}
