/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.PerformanceIndicatorsController;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;

/**
 *
 * @author Rita
 */
public class FreelancerStatisticsPaymentUI implements Initializable {
    
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
    private TableView<Freelancer> tblView;
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

        List<Freelancer> listFreel = AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction().getFreelancers();

        TableColumn id = new TableColumn("ID");
        TableColumn name = new TableColumn("NAME");

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        tblView.getColumns().addAll(id, name);

        for (Freelancer freel : listFreel) {
            tblView.getItems().add(freel);
        }
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
            FreelancerStatisticsDelayUI delay = (FreelancerStatisticsDelayUI) this.mainApp.replaceSceneContent("/fxml/FreelancerStatisticsDelay.fxml");
            delay.setMainApp(mainApp);
        } catch (Exception ex) {
            System.out.println("Error opening scene: FreelancerStatisticsDelay.fxml" + ex.getMessage());
        }
    }
    
    @FXML
    private void getSelected(MouseEvent event) {
        Freelancer idFreel = (Freelancer) tblView.getSelectionModel().getSelectedItem();
        PerformanceIndicatorsController pic = new PerformanceIndicatorsController();
        XYChart.Series series = new XYChart.Series();
        series = pic.showFreelancerPayment(idFreel, "FreelancerPayment");
        barChart.getData().clear();
        barChart.getData().add(series);
        setFieldMean(String.valueOf(pic.getMean()));
        setFieldVariance(String.valueOf(pic.getVariance()));
        setFieldSDeviation(String.valueOf(pic.getSvariation()));
    }
    
}
