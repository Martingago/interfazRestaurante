package ejemplointerfazhotel.vistas;

import ejemplointerfazhotel.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;

public class SalonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Utilidades utils = new Utilidades(); //Utilidades generales de la aplicacion;
     @FXML private Pane containerPane;
     @FXML private ComboBox inputTypeEvento;
     @FXML private ComboBox inputTypeCocina;
     @FXML private ComboBox inputRooms;
     @FXML private Spinner inputNumAsistentes;
     @FXML private Spinner inputNumJornadas;
     @FXML private DatePicker inputFechaEvento;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializar lista de tipos de evento:
        
        inputTypeEvento.getItems().addAll("Boda/Bautizo/Comunión", "Cumpleaños", "Reunión de empresa");
        inputTypeCocina.getItems().addAll("Menú cerrado", "Menú a la carta", "Propuesto por el cliente", "Por concretar");
        inputRooms.getItems().addAll("NO", "SI");
        inputRooms.setValue("NO");
        //Spinners:
        SpinnerValueFactory<Integer> numAsistentes = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        SpinnerValueFactory<Integer> numJornadas = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30);
        inputNumAsistentes.setValueFactory(numAsistentes);
        inputNumJornadas.setValueFactory(numJornadas);
        //Por defecto estos valores están deshabilitados, cuando se selecciona una opción se gestiona su accesibilidad:
        inputRooms.setDisable(true);
        inputNumJornadas.setDisable(true);
        
        //DatePicker => Limitar y bloquear fechas pasadas
        utils.limitarFechaAnterior(inputFechaEvento);
    }    
    //Llamada a la funcion de utilidades closeWindow
    public void cerrar(ActionEvent event) throws IOException{
    Node node = (Node) event.getSource();
    Utilidades.goIndex(node);
    }
    
    public void handleTipoEvento(ActionEvent event){
    
        String value = (String) inputTypeEvento.getValue();
        switch(value){
            case "Boda/Bautizo/Comunión":
                inputRooms.setDisable(false);
                inputNumJornadas.setDisable(true);
                break;
            case "Reunión de empresa" :
                inputRooms.setDisable(true);
                inputNumJornadas.setDisable(false);
                
                break;
            default :
                inputRooms.setDisable(true);
                inputNumJornadas.setDisable(true);
                break;
        
        }
    }
    
    
}
