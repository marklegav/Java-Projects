/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.controller.AutenticacaoController;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;

/**
 * FXML Controller class
 *
 * @author Rita
 */
public class MainUI implements Initializable {
    
    private MediaPlayer media;
    
    private MainApp mainApp;

    private AutenticacaoController controller;
    
    @FXML
    private TextField txtFieldEmail;
    
    
    @FXML
    private Label labelWarning;
    
    @FXML
    private PasswordField pwdField;
    @FXML
    private ImageView horse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new AutenticacaoController();
        this.horse.setVisible(false);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnLogin(ActionEvent event) throws Exception {
        verificaTexto();
        if (this.controller.doLogin(txtFieldEmail.getText(), pwdField.getText()) == true) {
            if (AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
                try {
                    MenuColaboradorUI menu = (MenuColaboradorUI) this.mainApp.replaceSceneContent("/fxml/MenuColaborador.fxml");
                    menu.setMainApp(mainApp);
                } catch (Exception ex) {
                    throw ex;
                }
            } else if (AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO)) {
                try {
                    MenuAdministradorUI menu = (MenuAdministradorUI) this.mainApp.replaceSceneContent("/fxml/MenuAdministrador.fxml");
                    menu.setMainApp(mainApp);
                } catch (Exception ex) {
                    throw ex;
                }
            }else if(AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_GESTOR_ORGANIZACAO)) {
                try {
                    MenuManagerUI menu = (MenuManagerUI) this.mainApp.replaceSceneContent("/fxml/MenuManager.fxml");
                    menu.setMainApp(mainApp);
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } else {
            labelWarning.setText("Invalid user and/or password.");
        }
    }

    @FXML
    private void btnRegister(ActionEvent event) {
        
    }
    
    public boolean verificaTexto() {
        String email = txtFieldEmail.getText();
        String pwd = pwdField.getText();
        if (email == null || email.isEmpty() || pwd == null || pwd.isEmpty()) {
            labelWarning.setText("Credentials can't be empty.");
            return false;
        } else {
            return true;
        }
    }

    @FXML
    private void btnHorse(ActionEvent event) throws InterruptedException {
        String musicFile = "src/horse.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        media = new MediaPlayer(sound);
        media.setStartTime(Duration.seconds(84));
        media.play();
        this.horse.setVisible(true);
    }
    
}
