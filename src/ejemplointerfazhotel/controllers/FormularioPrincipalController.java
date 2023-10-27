/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplointerfazhotel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author
 */
public class FormularioPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnReservas;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnSalon;
    
    @FXML private MenuItem submenuSalon;
    @FXML private MenuItem submenuReservas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handlebtnReservas(ActionEvent event) throws IOException {
        Stage stage = null;
        //Parent root = FXMLLoader.load(getClass().getResource("/ejemplointerfazhotel/vistas/FormularioPrincipal.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/ejemplointerfazhotel/vistas/FXMLDocument.fxml")); 
        Scene scene = new Scene(root);
        if (event.getSource() == btnReservas) {
            //Obtener referencia a la Escena del botón         
            stage = (Stage) btnReservas.getScene().getWindow();
        } else if(event.getSource() == submenuReservas){
            //Ya que un MenuItem no permite abrir una scena lo hacemos con la referencia de btnReservas
            stage = (Stage) btnReservas.getScene().getWindow();
        }
        //Crear una nueva escena con raíz y establecer el escenario
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void handleBtnSalon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ejemplointerfazhotel/vistas/Salon.fxml"));
        Scene scene = new Scene(root);
        Stage stage = null;
        if(event.getSource() == btnSalon){
           stage = (Stage) btnSalon.getScene().getWindow();
        } else if(event.getSource() == submenuSalon){
            stage = (Stage) btnSalon.getScene().getWindow();
        }
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void handlebtnSalir(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }
}
