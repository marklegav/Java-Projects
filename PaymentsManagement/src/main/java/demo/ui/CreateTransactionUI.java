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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.CreateTransactionController;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Task;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class CreateTransactionUI implements Initializable {
    
    private MainApp mainApp;
    
    private CreateTransactionController controller = new CreateTransactionController();

    @FXML
    private Label lblUserName;
    @FXML
    private TextField fieldDelay;
    @FXML
    private TextField fieldFinishDate;
    @FXML
    private TextField fieldDescription;
    @FXML
    private ChoiceBox<String> choiceBoxTaskID;
    @FXML
    private ChoiceBox<String> choiceBoxFreelancer;
    @FXML
    private Label lblwarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        List<Task> tasks = AplicacaoPOT.getInstance().getPlataforma().getRegistoTarefa().getListaTarefa();
        List<Freelancer> freelancers = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().getFreelancers();
        choiceBoxTaskID.setItems(FXCollections.observableArrayList(populateTaskBox(tasks)));
        choiceBoxFreelancer.setItems(FXCollections.observableArrayList(populateFreelancerBox(freelancers)));
        choiceBoxTaskID.getSelectionModel().selectFirst();
        choiceBoxFreelancer.getSelectionModel().selectFirst();
        //choiceBoxTaskID.setItems(FXCollections.observableArrayList());//
              // populateTaskBox(controller.getListTask());
//        choiceBoxLevel.setItems(FXCollections.observableArrayList("Junior", "Senior"));
//        choiceBoxLevel.getSelectionModel().selectFirst();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private List<String> populateTaskBox(List<Task> tasks){
        List<String> result = new ArrayList();
        for (Task task : tasks) {
            result.add(task.getID());
        }
        return result;
    }
    
    private List<String> populateFreelancerBox(List<Freelancer> freelancers){
        List<String> result = new ArrayList();
        for (Freelancer freel : freelancers) {
            result.add(freel.getId());
        }
        return result;
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
    private void btnConfirm(ActionEvent event) throws Exception {
        if (checkFields() == true) {
            try {
                TransactionConfirmUI confirm = (TransactionConfirmUI) this.mainApp.replaceSceneContent("/fxml/TransactionConfirm.fxml");
                confirm.setMainApp(mainApp);
                confirm.setDelay(this.fieldDelay.getText());
                confirm.setFinishDate(this.fieldFinishDate.getText());
                confirm.setBiefDesc(this.fieldDescription.getText());
                confirm.setTask(this.choiceBoxTaskID.getValue());
                confirm.setFreelancer(this.choiceBoxFreelancer.getValue());
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            lblwarning.setText("Some fields are invalid. Please try again.");
        }
    }
    
    public void setDelay(String txt) {
        this.fieldDelay.setText(txt);
    }
    
    public void setFinishDate(String txt) {
        this.fieldFinishDate.setText(txt);
    }
    
    public void setBiefDesc(String txt) {
        this.fieldDescription.setText(txt);
    }
    
    public void setTask(String txt) {
        this.choiceBoxTaskID.getSelectionModel().select(txt);
    }
    
    public void setFreelancer(String txt) {
        this.choiceBoxFreelancer.getSelectionModel().select(txt);
    }
    
    private boolean checkFields() {
        return checkDelay() == true && checkDate() == true && checkDescription() == true;
    }
    
    public boolean checkDelay() {
        return !(this.fieldDelay.getText().isEmpty()) || this.fieldDelay.getText() != null;
    }
    
    public boolean checkDate() {
        return true;
    }
    
    public boolean checkDescription() {
        return !(this.fieldDescription.getText().isEmpty()) || this.fieldDescription.getText() != null;
    }
    
}
