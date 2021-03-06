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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.PerformanceIndicatorsController;

/**
 *
 * @author Rita
 */
public class PlatformStatisticsPaymentUI implements Initializable {
    
    private MainApp mainApp;
    @FXML
    private Label lblUserName;
    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnDelay;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis yAxis1;
    @FXML
    private Label fieldMean;
    @FXML
    private Label fieldSDeviation;
    @FXML
    private Label fieldVariance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        barChart.setBarGap(0);
        barChart.setCategoryGap(0);
        barChart.setAnimated(false);
        PerformanceIndicatorsController pic = new PerformanceIndicatorsController();
        XYChart.Series series = pic.showPlatformPayments("PlatformP");
        barChart.getData().clear();
        barChart.getData().add(series);

        setFieldMean(String.valueOf(pic.getMean()));
        setFieldVariance(String.valueOf(pic.getVariance()));
        setFieldSDeviation(String.valueOf(pic.getSvariation()));
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setFieldSDeviation(String a) {
        this.fieldSDeviation.setText(a);
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

    @FXML
    private void btnLogout(ActionEvent event) {
        AplicacaoPOT.getInstance().doLogout();
        try {
            MainUI main = (MainUI) this.mainApp.replaceSceneContent("/fxml/Main.fxml");
            main.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: Main.fxml" + ex.getMessage());
        }
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


    @FXML
    private void btnDelay(ActionEvent event) {
        try {
            PlatformStatisticsDelayUI delay = (PlatformStatisticsDelayUI) this.mainApp.replaceSceneContent("/fxml/PlatformStatisticsDelay.fxml");
            delay.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: FreelancerStatisticsDelay.fxml" + ex.getMessage());
        }
    }
    
}
