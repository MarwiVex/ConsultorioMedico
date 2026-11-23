package consultorio.controller.asistente;

import consultorio.modelo.Cita;
import consultorio.modelo.Medico;
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

public class GestionCitasController implements Initializable {
    @FXML
    private TextField textFieldID;
    @FXML
    private ComboBox<Paciente> comboBoxPaciente;
    @FXML
    private ComboBox<Medico> comboBoxMedico;
    @FXML
    private DatePicker datePickerFecha;
    @FXML
    private ComboBox<String> comboBoxHora;
    @FXML
    private ComboBox<String> comboBoxEstado;
    @FXML
    private TextField textFieldObservaciones;
    @FXML
    private DatePicker datePickerFiltroFecha;
    @FXML
    private ComboBox<String> comboBoxFiltroPeriodo;
    @FXML
    private ComboBox<String> comboBoxFiltroEstado;
    @FXML
    private TextField textFieldBuscarPaciente;
    @FXML
    private TableView<Cita> tableViewCitas;

    public void clicTabla(MouseEvent event) {
    }

    public void clicFiltrar(ActionEvent event) {
    }

    public void clicVerTodas(ActionEvent event) {
    }

    public void clicAgendar(ActionEvent event) {
    }

    public void clicModificar(ActionEvent event) {
    }

    public void clicRegistrarLlegada(ActionEvent event) {
    }

    public void clicCancelar(ActionEvent event) {
    }

    public void clicLimpiar(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
