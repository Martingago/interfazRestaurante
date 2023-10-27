/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplointerfazhotel.controllers;

import ejemplointerfazhotel.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Agustin
 */
public class FXMLDocumentController implements Initializable {

    Utilidades utils = new Utilidades();
    @FXML
    private Label label;
    @FXML
    private ComboBox comboBox;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label labelAviso;

    @FXML
    private Button btnConfirm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox.getItems().addAll("Doble de uso individual", "Doble", "Junior Suite", "Suite");
        labelAviso.setVisible(false);

    }

    public void handleCheckBox() {
        if (checkBox.isSelected()) {
            //etiqueta será visible
            labelAviso.setVisible(true);
        } else {
            labelAviso.setVisible(false);
        }
    }

    public void cerrar(ActionEvent event) {
        Node node = (Node) event.getSource();
        utils.goIndex(node);
    }

    public void confirm(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnConfirm.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ejemplointerfazhotel/vistas/Confirmation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
