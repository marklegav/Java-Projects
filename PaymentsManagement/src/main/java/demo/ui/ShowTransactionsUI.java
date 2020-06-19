/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.ShowTransactionsController;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Transaction;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class ShowTransactionsUI implements Initializable {
    
    private ShowTransactionsController controller;
    @FXML
    private Label lblUserName;
    @FXML
    private Label lblwarning;
    
    private MainApp mainApp;
    @FXML
    private ListView<String> listTransactions;
    @FXML
    private ChoiceBox<String> choicheBoxTransaction;
    @FXML
    private Button btnSeeTransactions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Transaction> transactions = AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction().getPaymentOrders();
        choicheBoxTransaction.setItems(FXCollections.observableArrayList(populateOrgBox(transactions)));
//        choicheBoxTransaction.setItems(FXCollections.observableArrayList("teste1", "teste2", "teste3"));
        choicheBoxTransaction.getSelectionModel().selectFirst();
//        List<String> transactions = new ArrayList<>();
//        
//        
//        for (Transaction trans : controller.getTransactionsByLogin()) {
//            transactions.add(trans.toString());
//        }
//        ObservableList<String> items = FXCollections.observableArrayList(transactions);
//        listFreelancers.setItems(items);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private List<String> populateOrgBox(List<Transaction> transactions) {
        List<String> result = new ArrayList();
        for (Transaction transaction : transactions) {
            if (!result.contains(transaction.getOrgNIF())) {
                result.add(transaction.getOrgNIF());
            }
        }
        return result;
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
    private void btnGoBack(ActionEvent event) throws Exception {
        try {
            MenuColaboradorUI menu = (MenuColaboradorUI) this.mainApp.replaceSceneContent("/fxml/MenuColaborador.fxml");
            menu.setMainApp(mainApp);
        } catch (Exception ex) {
                throw ex;
        }
    }

    @FXML
    private void btnSeeTransactions(ActionEvent event) {
        List<String> result = new ArrayList<>();
        List<Transaction> transactionsByOrg = AplicacaoPOT.getInstance().
                getPlataforma().getRegisterTransaction().getListTransactioByOrg(this.choicheBoxTransaction.getValue());
        for (Transaction transaction : transactionsByOrg) {
            result.add(transaction.toString());
        }
        this.listTransactions.setItems(FXCollections.observableArrayList(result));
    }
    
}
