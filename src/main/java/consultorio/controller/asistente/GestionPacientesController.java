package consultorio.controller.asistente;

import consultorio.modelo.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionPacientesController implements Initializable {
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private DatePicker datePickerFechaNacimiento;
    @FXML
    private ComboBox<String> comboBoxSexo;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldCorreo;
    @FXML
    private TextField textFieldBuscar;
    @FXML
    private TableView<Paciente> tableViewPacientes;

    public void clicTabla(MouseEvent event) {
    }

    public void clicAgregar(ActionEvent event) {
    }

    public void clicModificar(ActionEvent event) {
    }

    public void clicBuscar(ActionEvent event) {
    }

    public void clicLimpiar(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
