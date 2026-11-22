package consultorio.controller.admin;

import consultorio.admon.UsuarioAdmon;
import consultorio.configuracion.ConexionBD;
import consultorio.configuracion.Ventanas;
import consultorio.modelo.Asistente;
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

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GestionAsistentesController implements Initializable {
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldCorreo;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField textFieldContrasenia;
    @FXML
    private ComboBox<String> comboBoxEstado;
    @FXML
    private TableView<Asistente> tableViewAsistentes;

    private TableColumn<Asistente, Integer> tcId;
    private TableColumn<Asistente, String> tcNombre;
    private TableColumn<Asistente, String> tcTelefono;
    private TableColumn<Asistente, String> tcCorreo;
    private TableColumn<Asistente, String> tcUsuario;
    private TableColumn<Asistente, String> tcEstado;

    private UsuarioAdmon usuarioAdmon;

    public GestionAsistentesController(){
        usuarioAdmon = new UsuarioAdmon();
    }

    public void clicTabla(MouseEvent event) {
        Asistente asistente = (Asistente) tableViewAsistentes.getSelectionModel().getSelectedItem();
        if (asistente == null) {
            return;
        }

        textFieldID.setText(String.valueOf(asistente.getId()));
        textFieldNombre.setText(asistente.getNombre());
        textFieldTelefono.setText(asistente.getTelefono());
        textFieldUsuario.setText(asistente.getUsername());
        textFieldContrasenia.clear();
        textFieldCorreo.setText(asistente.getCorreo());
        if (asistente.getEstado()) {
            comboBoxEstado.getSelectionModel().select("Activo");
        } else {
            comboBoxEstado.getSelectionModel().select("Inactivo");
        }
    }

    public void clicAgregar(ActionEvent event) {
        if (camposEstanLlenos(textFieldNombre, textFieldTelefono, textFieldUsuario, textFieldContrasenia, textFieldCorreo) && comboBoxEstado.getSelectionModel().getSelectedItem() != null) {
            Boolean estado = true;
            if (comboBoxEstado.getValue().equalsIgnoreCase("Inactivo")) {
                estado = false;
            }

            Asistente nuevoAsistente = new Asistente(textFieldNombre.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), textFieldUsuario.getText(), textFieldContrasenia.getText());
            nuevoAsistente.setEstado(estado);

            Boolean registrado = usuarioAdmon.registrarUsuario(nuevoAsistente);

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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabla();
        cargarTabla();
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

        tableViewAsistentes.getColumns().setAll(tcId, tcNombre, tcTelefono, tcCorreo, tcUsuario, tcEstado);
    }

    public void cargarTabla(){
        try{
        tableViewAsistentes.getItems().setAll(usuarioAdmon.obtenerAsistentes());
        } catch (Exception e) {
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
