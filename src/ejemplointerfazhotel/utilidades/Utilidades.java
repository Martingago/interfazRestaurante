package ejemplointerfazhotel.utilidades;

import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Utilidades {

    @FXML
    private Button btnCancel;

    /**
     * Cierra la ventana
     *
     * @param node
     */
    public static void closeWindow(Node node) {
        // Obtener la ventana (Stage) del nodo
        Stage stage = (Stage) node.getScene().getWindow();
        // Cerrar la ventana
        stage.close();
    }

    /**
     * Cierra la ventana actual y abre la ventana del index
     * (FormularioPrincipal)
     *
     * @param node
     */
    public static void goIndex(Node node) {
        try {
            // Cargar la escena de Scene Builder
            Parent root = FXMLLoader.load(Utilidades.class.getResource("/ejemplointerfazhotel/FormularioPrincipal.fxml"));
            // Crear una nueva escena con la escena cargada
            Scene scene = new Scene(root);
            // Obtener la ventana (Stage) del nodo
            Stage stage = (Stage) node.getScene().getWindow();
            // Establecer la nueva escena en la ventana actual
            stage.setScene(scene);

            // Mostrar la ventana con la nueva escena
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Función que recibe un objeto DatePicker y limita sus fechas anteriores
     * @param datePicker objeto sobre el que se va a realizar la limitacion y comprobación de fechas
     * No entiendo NADA de cómo funciona el Callback, pero el código funciona :D!
     */
    public void limitarFechaAnterior(DatePicker datePicker) {
        final Callback<DatePicker, DateCell> callB = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        LocalDate today = LocalDate.now();
                        if(empty || item.compareTo(today) < 0){
                            setDisable(true);
                            setStyle("-fx-background-color: #ff0000;");
                        }
                    }
                };
            }
        };
        datePicker.setDayCellFactory(callB);
    }

}
