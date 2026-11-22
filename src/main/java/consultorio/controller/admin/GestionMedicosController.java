package consultorio.controller.admin;

import consultorio.admon.EspecialidadAdmon;
import consultorio.admon.UsuarioAdmon;
import consultorio.configuracion.Ventanas;
import consultorio.modelo.Asistente;
import consultorio.modelo.Especialidad;
import consultorio.modelo.Medico;
import consultorio.modelo.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GestionMedicosController implements Initializable {
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldCorreo;
    @FXML
    private ComboBox<Especialidad> comboBoxEspecialidad;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField textFieldContrasenia;
    @FXML
    private ComboBox<String> comboBoxEstado;
    @FXML
    private TableView<Medico> tableViewMedicos;

    private TableColumn<Medico, Integer> tcId;
    private TableColumn<Medico, String> tcNombre;
    private TableColumn<Medico, String> tcTelefono;
    private TableColumn<Medico, String> tcCorreo;
    private TableColumn<Medico, String> tcUsuario;
    private TableColumn<Medico, String> tcEstado;
    private TableColumn<Medico, String> tcEspecialidad;

    private EspecialidadAdmon especialidadAdmon = new EspecialidadAdmon();
    private UsuarioAdmon usuarioAdmon = new UsuarioAdmon();
    LinkedList<Especialidad> especialidades;

    public GestionMedicosController(){
        especialidadAdmon= new EspecialidadAdmon();
        usuarioAdmon= new UsuarioAdmon();
        especialidades = especialidadAdmon.obtenerEspecialidades();
    }

    public void clicTabla(MouseEvent event) {
        Medico medico = (Medico) tableViewMedicos.getSelectionModel().getSelectedItem();
        if (medico == null){
            return;
        }
        textFieldID.setText(String.valueOf(medico.getId()));
        textFieldNombre.setText(medico.getNombre());
        textFieldTelefono.setText(medico.getTelefono());
        textFieldUsuario.setText(medico.getUsername());
        textFieldContrasenia.clear();
        textFieldCorreo.setText(medico.getCorreo());
        if (medico.getEstado()) {
            comboBoxEstado.getSelectionModel().select("Activo");
        } else {
            comboBoxEstado.getSelectionModel().select("Inactivo");
        }
        for(Especialidad especialidad : especialidades){
            if(especialidad.getId() == medico.getEspecialidadID()){
                comboBoxEspecialidad.getSelectionModel().select(especialidad);
                break;
            }
        }
    }

    public void clicAgregar(ActionEvent event) {
        if (camposEstanLlenos(textFieldNombre, textFieldTelefono, textFieldUsuario, textFieldContrasenia, textFieldCorreo) && comboBoxEspecialidad.getSelectionModel().getSelectedItem() != null && comboBoxEstado.getSelectionModel().getSelectedItem() != null) {
            Boolean estado = true;
            if (comboBoxEstado.getValue().equalsIgnoreCase("Inactivo")) {
                estado = false;
            }

            Medico nuevoMedico = new Medico(textFieldNombre.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), textFieldUsuario.getText(), textFieldContrasenia.getText(), comboBoxEspecialidad.getSelectionModel().getSelectedItem().getId());
            nuevoMedico.setEstado(estado);

            Boolean registrado = usuarioAdmon.registrarUsuario(nuevoMedico);

            if (registrado) {
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Usuario agregado correctamente");
            } else {
                Ventanas.mostrarError("No se pudo agregar al usuario");
            }
        } else{
            Ventanas.mostrarError("Llene todos los campos");
        }
    }

    public void clicActivarDesactivar(ActionEvent event) {
        if (!textFieldID.getText().isEmpty()) {
            Boolean editado = usuarioAdmon.cambiarEstadoUsuario(Integer.valueOf(textFieldID.getText()));
            if (editado) {
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Estado actualizado correctamente");
            }
        }
    }

    public void clicLimpiar(ActionEvent event) {
        textFieldID.clear();
        textFieldNombre.clear();
        textFieldTelefono.clear();
        textFieldCorreo.clear();
        textFieldUsuario.clear();
        textFieldContrasenia.clear();
        comboBoxEstado.getSelectionModel().clearSelection();
        comboBoxEspecialidad.getSelectionModel().clearSelection();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabla();
        cargarTabla();
        comboBoxEspecialidad.getItems().setAll(especialidades);
        comboBoxEstado.getItems().setAll("Activo", "Inactivo");
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

        tcUsuario = new TableColumn<>("Usuario");
        tcUsuario.setCellValueFactory(new PropertyValueFactory<>("username"));

        tcEstado = new TableColumn<>("Estado");
        tcEstado.setCellValueFactory(new PropertyValueFactory<>("estadoTexto"));

        tcEspecialidad = new TableColumn<>("Especialidad");
        tcEspecialidad.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Medico, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Medico, String> param) {
                Integer especialidadID = ((Medico) param.getValue()).getEspecialidadID();
                String especialidad = especialidadAdmon.obtenerNombrePorId(especialidadID);
                return new SimpleStringProperty(especialidad);
            }
        });

        tableViewMedicos.getColumns().setAll(tcId, tcNombre, tcTelefono, tcCorreo, tcUsuario, tcEstado, tcEspecialidad);
    }

    public void cargarTabla(){
        try {
            tableViewMedicos.getItems().setAll(usuarioAdmon.obtenerMedicos());
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
