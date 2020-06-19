/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;
 



/**
 *
 * @author Matheus Aguiar
 */
public class ListFreelancersUI implements Initializable {

    private MainApp mainApp;
    
    @FXML
    private TableView tblFreelancer;
    
    @FXML
//    private TableView<Freelancer> tblFreelancer;
    private TableColumn<Freelancer, String> freelaID;
    private TableColumn<Freelancer, String> freelaName;
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Freelancer> listFreel = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().getFreelancers();

        TableColumn id = new TableColumn("ID");
        TableColumn name = new TableColumn("NAME");
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        tblFreelancer.getColumns().addAll(id, name);
        
        for (Freelancer freel : listFreel) {
            tblFreelancer.getItems().add(freel);
        }
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void tblFreelancer (ActionEvent event) throws Exception {
        
        
        try {
            PerformanceIndicators_Payment_UI main = 
                    (PerformanceIndicators_Payment_UI) this.mainApp.replaceSceneContent("/fxml/PerformanceIndicators_Payment_UI.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            throw ex;
        } 
    }
}
