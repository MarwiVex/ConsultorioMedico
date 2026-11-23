package consultorio.controller.asistente;

import consultorio.admon.PacienteAdmon;
import consultorio.configuracion.Ventanas;
import consultorio.modelo.Especialidad;
import consultorio.modelo.Medico;
import consultorio.modelo.Paciente;
import consultorio.modelo.enums.Sexo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
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

    private TableColumn<Paciente, Integer> tcId;
    private TableColumn<Paciente, String> tcNombre;
    private TableColumn<Paciente, LocalDate> tcFechaNacimiento;
    private TableColumn<Paciente, String> tcTelefono;
    private TableColumn<Paciente, String> tcCorreo;
    private TableColumn<Paciente, Sexo> tcSexo;

    private PacienteAdmon pacienteAdmon;

    public GestionPacientesController(){
        pacienteAdmon = new PacienteAdmon();
    }

    public void clicTabla(MouseEvent event) {
        Paciente paciente = (Paciente) tableViewPacientes.getSelectionModel().getSelectedItem();
        if(paciente == null){
            return;
        }

        textFieldID.setText(String.valueOf(paciente.getId()));
        textFieldNombre.setText(paciente.getNombre());
        datePickerFechaNacimiento.setValue(paciente.getFechaNacimiento());
        comboBoxSexo.getSelectionModel().select(paciente.getSexo().ordinal());
        textFieldTelefono.setText(paciente.getTelefono());
        textFieldCorreo.setText(paciente.getCorreo());

    }

    public void clicAgregar(ActionEvent event) {
        if(camposEstanLlenos(textFieldNombre, textFieldTelefono, textFieldCorreo) && comboBoxSexo.getSelectionModel().getSelectedItem() != null && datePickerFechaNacimiento.getValue()!=null)  {
            Sexo sexo = Sexo.values()[comboBoxSexo.getSelectionModel().getSelectedIndex()];
            Paciente paciente = new Paciente(textFieldNombre.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), datePickerFechaNacimiento.getValue(), sexo);

            Boolean registrado = pacienteAdmon.registrarPaciente(paciente);

            if(registrado){
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Paciente agregado correctamente");
            } else {
                Ventanas.mostrarError("No se pudo agregar al paciente");
            }
        } else{
            Ventanas.mostrarError("Llene todos los campos");
        }
    }

    public void clicModificar(ActionEvent event) {
        if(camposEstanLlenos(textFieldID, textFieldNombre, textFieldTelefono, textFieldCorreo) && comboBoxSexo.getSelectionModel().getSelectedItem() != null && datePickerFechaNacimiento.getValue()!=null)  {
            Sexo sexo = Sexo.values()[comboBoxSexo.getSelectionModel().getSelectedIndex()];
            Paciente paciente = new Paciente(Integer.valueOf(textFieldID.getText()), textFieldNombre.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), datePickerFechaNacimiento.getValue(), LocalDate.now(), sexo);

            Boolean editado = pacienteAdmon.editarPaciente(paciente);

            if(editado){
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Paciente editado correctamente");
            } else {
                Ventanas.mostrarError("No se pudo editar al paciente");
            }
        } else{
            Ventanas.mostrarError("Llene todos los campos");
        }
    }

    public void clicBuscar(ActionEvent event) {
        LinkedList<Paciente> pacientes = new LinkedList<>();
        pacientes = pacienteAdmon.buscarPacientes(textFieldBuscar.getText());

        if (pacientes.isEmpty()) {
            Ventanas.mostrarInfo("No se encontraron pacientes con ese criterio");
            return;
        }
        tableViewPacientes.getItems().setAll(pacientes);
    }

    public void clicLimpiar(ActionEvent event) {
        textFieldID.clear();
        textFieldNombre.clear();
        textFieldTelefono.clear();
        textFieldCorreo.clear();
        textFieldBuscar.clear();
        datePickerFechaNacimiento.setValue(null);
        comboBoxSexo.getSelectionModel().clearSelection();
        cargarTabla();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabla();
        cargarTabla();

        comboBoxSexo.getItems().setAll("Masculino", "Femenino", "Otro", "No especificado");
    }

    public void inicializarTabla(){
        tcId = new TableColumn<>("ID");
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));

        tcNombre = new TableColumn<>("Nombre");
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tcTelefono = new TableColumn<>("Teléfono");
        tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tcCorreo = new TableColumn<>("Correo");
        tcCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));


        tcSexo = new TableColumn<>("Sexo");
        tcSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        tcFechaNacimiento = new TableColumn<>("Fecha Nacimiento");
        tcFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        tableViewPacientes.getColumns().setAll(tcId, tcNombre, tcTelefono, tcCorreo, tcSexo, tcFechaNacimiento);
    }

    public void cargarTabla(){
        try {
            tableViewPacientes.getItems().setAll(pacienteAdmon.obtenerPacientes());
        }catch (Exception e){
            System.err.println("error al cargar tabla");
        }
    }

    public Boolean camposEstanLlenos(TextField ... textos){
        for (TextField textField: textos){
            if (textField.getText().equalsIgnoreCase("") || textField.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }
}
