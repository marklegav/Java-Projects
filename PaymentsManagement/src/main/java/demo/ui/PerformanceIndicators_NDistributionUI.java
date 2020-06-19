/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.PerformanceIndicatorsController;

/**
 * FXML Controller class
 *
 * @author Matheus Aguiar
 */
public class PerformanceIndicators_NDistributionUI implements Initializable {

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnSubmit;
    @FXML
    private TextField sampleNumber;
    @FXML
    private Label probability;
    @FXML
    private Label fieldMean;
    @FXML
    private Label fieldSDeviation;
    @FXML
    private Label fieldVariance;
    @FXML
    private Label tasksNumber;
   
    private MainApp mainApp;
    @FXML
    private Label lblUserName;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
            PerformanceIndicatorsController pic = new PerformanceIndicatorsController();
            
            String nTasks = String.valueOf(pic.getNumberOfTasks());
            
            sampleNumber.setText(nTasks);
            fieldMean.setText(String.valueOf(2));
            fieldSDeviation.setText(String.valueOf(1.5));
            fieldVariance.setText(String.valueOf(Math.pow(1.5, 2)));
            tasksNumber.setText(nTasks);
            double prob = pic.showProbabilities(2, 1.5, Integer.parseInt(nTasks), 3);

            setLblProbability(String.valueOf(prob));
        } catch (MathException ex) {
            Logger.getLogger(PerformanceIndicators_NDistributionUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setFieldSDeviation(String a) {
        this.fieldSDeviation.setText(a);
    }

    public void setTasksNumber(String a) {
        this.tasksNumber.setText(a);
    }
    public String getTasksNumber() {
       return this.getTasksNumber();
       
    }
    public void setFieldVariance(String a) {
        this.fieldVariance.setText(a);
    }

    public void setFieldMean(String a) {
        this.fieldMean.setText(a);
    }

    public void setLblUserName(String a) {
        this.lblUserName.setText(a);
    }

    public void setLblProbability(String a) {
        this.probability.setText(a);
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
    private void btnSubmit(ActionEvent event) throws Exception {

      setTasksNumber(sampleNumber.getText());
      int sample = Integer.parseInt(sampleNumber.getText());
        
        PerformanceIndicatorsController pic = new PerformanceIndicatorsController();
        
            double prob = pic.showProbabilities(2, 1.5, sample, 3);
        
            setLblProbability(String.valueOf(prob));
    }
    
    @FXML
    private void btnGoBack(ActionEvent event) {
        try {
            MenuStatisticsUI main = (MenuStatisticsUI) this.mainApp.replaceSceneContent("/fxml/MenuStatistics.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: MenuStatistics.fxml" + ex.getMessage());
        }
    }

}
