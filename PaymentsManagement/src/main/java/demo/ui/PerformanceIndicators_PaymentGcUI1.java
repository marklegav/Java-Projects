package demo.ui;

import demo.ui.ListFreelancersUI;
import demo.ui.MainApp;
import demo.ui.MainUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.PerformanceIndicatorsController;
import pt.ipp.isep.dei.esoft.pot.utils.Filter;

/**
 * FXML UI class
 *
 * @author Matheus Aguiar
 */
public class PerformanceIndicators_PaymentGcUI1 implements Initializable {

    private MainApp mainApp;
    @FXML
    private Label lblUserName;
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private Button btnDelay;
    @FXML
    private ComboBox<String> comboBox;

   ObservableList<String> sort = FXCollections.observableArrayList("Freelancer", "Platform"); 
    @FXML
    private Button btnLogout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        comboBox.setItems(sort);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
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
    private void btnDelay(ActionEvent event) {
        try {
            PerformanceIndicators_FreelancerUI1 payUI = (PerformanceIndicators_FreelancerUI1) 
                    this.mainApp.replaceSceneContent("/fxml/CGFreelancerStatistics_Perfo.fxml");
            payUI.setMainApp(mainApp);
        } catch (Exception ex) {

            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(PerformanceIndicators_PaymentGcUI1.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }

    }

    @FXML
    private void comboBox(ActionEvent event) throws Exception {
        if ("Freelancer".equals(comboBox.getValue())) {
            try {
                ListFreelancersUI alert = (ListFreelancersUI) this.mainApp.replaceSceneContent("/fxml/ListFreelancers.fxml");
                alert.setMainApp(this.mainApp);
            } catch (Exception ex) {

                throw ex;

            }

        } else {

            PerformanceIndicatorsController pic = new PerformanceIndicatorsController();
            XYChart.Series<String, Integer> series = pic.showPlatformPayments("PlatformP");
            barChart.getData().add(series);
        }
    }
}
