package demo.ui;

import pt.ipp.isep.dei.esoft.pot.model.RegisterFreelancer;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;
import pt.ipp.isep.dei.esoft.pot.model.NotifyFreelancerTask;


public class MainApp extends Application {

    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 400.0;
    private final double MINIMUM_WINDOW_HEIGHT = 300.0;
    private final double SCENE_WIDTH = 450.0;
    private final double SCENE_HEIGHT = 350.0;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Payments Management");
        toMainScene();
        stage.setResizable(false);
        this.stage.show();
    }

    public Stage getStage() {
        return this.stage;
    }
    
    public void toMainScene() {
        try {
            MainUI mainUI = (MainUI) replaceSceneContent("/fxml/Main.fxml");
            mainUI.setMainApp(this);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page);
        scene.getStylesheets().add("/styles/Styles.css");
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        AplicacaoPOT.getInstance().setContext();
//        RegisterFreelancer regfreel = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer();
//        Freelancer freel1 = AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().newFreelancer("Rita Carneiro", LevelOfExpertise.JUNIOR, "rc@esoft.pt", "123", "123", "1-1-1", "1");
//        if (AplicacaoPOT.getInstance().getPlataforma().getRegisterFreelancer().registerFreelancer(freel1)) { System.out.println("freel1 sucesso"); }
//        Freelancer freel2 = regfreel.newFreelancer("Arsenio Uate", LevelOfExpertise.JUNIOR, "au@esoft.pt", "456", "456", "1-1-1", "1");
//        if (regfreel.registerFreelancer(freel2)) { System.out.println("freel2 sucesso"); }
//        Freelancer freel3 = regfreel.newFreelancer("Matheus Aguiar", LevelOfExpertise.SENIOR, "ma@esoft.pt", "789", "789", "1-1-1", "1");
//        if (regfreel.registerFreelancer(freel3)) { System.out.println("freel3 sucesso"); }
//        Freelancer freel4 = regfreel.newFreelancer("Marcel Gavioli", LevelOfExpertise.JUNIOR, "mg@esoft.pt", "321", "321", "1-1-1", "1");
//        if (regfreel.registerFreelancer(freel4)) { System.out.println("freel4 sucesso"); }
//        regfreel.registerFreelancer(freel4);
        NotifyFreelancerTask notfreel = new NotifyFreelancerTask();
        launch(args);
        AplicacaoPOT.getInstance().getPlataforma().schedulesNotifyFreelancer();

    }
        public Alert filterAlert(){
        Alert filter = new Alert(Alert.AlertType.INFORMATION);
        
        
        filter.setTitle("Information");
        filter.setHeaderText("Filter by Freelancer");
        filter.setContentText("If you wish to filter by FREELANCERS, select a name in the right table.");
        
        return filter;
    }
}
