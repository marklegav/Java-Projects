package demo.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.PIController;
import pt.ipp.isep.dei.esoft.pot.controller.PerformanceIndicatorsController;
import pt.ipp.isep.dei.esoft.pot.controller.PerformanceIndicatorsController;
import pt.ipp.isep.dei.esoft.pot.utils.Filter;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;

/**
 * FXML UI class
 *
 * @author Matheus Aguiar
 */
public class PD_UI implements Initializable {

    @FXML
    private Label fieldMean;
    @FXML
    private Label fieldSDeviation;
    @FXML
    private Label fieldVariance;
    @FXML
    private TableView tblView;
    private MainApp mainApp;
    @FXML
    private Label lblUserName;
    @FXML
    private CategoryAxis xAxis = new CategoryAxis();
    @FXML
    private NumberAxis yAxis = new NumberAxis();
    @FXML
    private BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

    @FXML
    private ComboBox<String> comboBox;

    ObservableList<String> sort = FXCollections.observableArrayList("Freelancer", "Organization");
    @FXML
    private Button btnPayment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUserName.setText(AplicacaoPOT.getInstance().getSessaoAtual().getNomeUtilizador());
        comboBox.setItems(sort);
        barChart.setAnimated(false);

        List<Freelancer> listFreel = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().getFreelancers();

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
    private void btnPayment(ActionEvent event) throws Exception {
        try {
            PP_UI payUI = (PP_UI) this.mainApp.replaceSceneContent("/fxml/FS_P.fxml");
            payUI.setMainApp(mainApp);
        } catch (Exception ex) {

            throw ex;

        }
    }

    @FXML
    private void comboBox(ActionEvent event) throws Exception {
        if ("Freelancer".equals(comboBox.getValue())) {

            mainApp.filterAlert().show();

        } else {

            PIController pic = new PIController();
            XYChart.Series series = new XYChart.Series();
            series = pic.showPlatformDelays("PlatformD");
            barChart.getData().clear();
            barChart.getData().add(series);

            setFieldMean(String.valueOf(pic.getMean()));
            setFieldVariance(String.valueOf(pic.getVariance()));
            setFieldSDeviation(String.valueOf(pic.getSvariation()));

        }
    }

    @FXML
    private void getSelected(MouseEvent event) {

        Freelancer idFreel = (Freelancer) tblView.getSelectionModel().getSelectedItem();

        PIController pic = new PIController();
        XYChart.Series series = new XYChart.Series();
        series = pic.showFreelancerDelays(idFreel, "FreelancerDelay");
        barChart.getData().clear();
        barChart.getData().add(series);

        setFieldMean(String.valueOf(pic.getMean()));
        setFieldVariance(String.valueOf(pic.getVariance()));
        setFieldSDeviation(String.valueOf(pic.getSvariation()));

    }

}
