package ejemplointerfazhotel.controllers;

import ejemplointerfazhotel.utilidades.Utilidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ConfirmationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cerrar(ActionEvent event) {
        Node node = (Node) event.getSource();
        Utilidades.goIndex(node);
    }

}
