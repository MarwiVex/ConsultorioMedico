package consultorio.controller.admin;

import consultorio.admon.EspecialidadAdmon;
import consultorio.admon.UsuarioAdmon;
import consultorio.configuracion.Ventanas;
import consultorio.modelo.Especialidad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GestionEspecialidadesController implements Initializable {
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldDescripcion;
    @FXML
    private ComboBox<String> comboBoxEstado;
    @FXML
    private TableView<Especialidad> tableViewEspecialidades;
    @FXML
    private ListView<String> listViewMedicos;

    private TableColumn<Especialidad, Integer> tcId;
    private TableColumn<Especialidad, String> tcNombre;
    private TableColumn<Especialidad, String> tcDescripcion;
    private TableColumn<Especialidad, String> tcEstado;

    private UsuarioAdmon usuarioAdmon;
    private EspecialidadAdmon especialidadAdmon;

    public GestionEspecialidadesController(){
        usuarioAdmon = new UsuarioAdmon();
        especialidadAdmon = new EspecialidadAdmon();
    }

    public void clicTabla(MouseEvent event) {
        Especialidad especialidad = (Especialidad) tableViewEspecialidades.getSelectionModel().getSelectedItem();
        if (especialidad == null) {
            return;
        }

        textFieldID.setText(String.valueOf(especialidad.getId()));
        textFieldNombre.setText(especialidad.getNombre());
        textFieldDescripcion.setText(especialidad.getDescripcion());
        if(especialidad.getEstado()){
            comboBoxEstado.getSelectionModel().select("Activo");
        }else {
            comboBoxEstado.getSelectionModel().select("Inactivo");
        }


        LinkedList<String> nombres = new LinkedList<>();
        nombres = usuarioAdmon.obtenerNombresMedicosPorEspecialidad(especialidad.getId());
        listViewMedicos.getItems().setAll(nombres);
        if(nombres.isEmpty()){
            listViewMedicos.getItems().setAll(String.format("No hay medicos en %s", especialidad.getNombre()));
        }
    }

    public void clicAgregar(ActionEvent event) {
        if(camposEstanLlenos(textFieldNombre, textFieldDescripcion) && comboBoxEstado.getSelectionModel().getSelectedItem()!=null){
            Especialidad especialidad = new Especialidad(textFieldNombre.getText(), textFieldDescripcion.getText());
            Boolean estado = true;
            if (comboBoxEstado.getSelectionModel().getSelectedItem().equalsIgnoreCase("Inactivo")){
                estado = false;
            }
            especialidad.setEstado(estado);

            Boolean registrado = especialidadAdmon.registrarEspecialidad(especialidad);
            if(registrado){
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Especialidad agregada correctamente");
            }else {
                Ventanas.mostrarError("No se pudo agregar al usuario");
            }
        } else{
            Ventanas.mostrarError("Llene todos los campos");
        }
    }

    public void clicModificar(ActionEvent event) {
        if(camposEstanLlenos(textFieldNombre, textFieldDescripcion, textFieldID) && comboBoxEstado.getSelectionModel().getSelectedItem()!=null){

            Boolean estado = true;
            if (comboBoxEstado.getSelectionModel().getSelectedItem().equalsIgnoreCase("Inactivo")){
                estado = false;
            }
            Especialidad especialidad = new Especialidad(Integer.valueOf(textFieldID.getText()), textFieldNombre.getText(), textFieldDescripcion.getText(), estado);

            Boolean registrado = especialidadAdmon.editarEspecialidad(especialidad);
            if(registrado){
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Especialidad editada correctamente");
            }else {
                Ventanas.mostrarError("No se pudo editar La especialidad");
            }
        } else{
            Ventanas.mostrarError("Llene todos los campos");
        }
    }

    public void clicActivarDesactivar(ActionEvent event) {
        if (!textFieldID.getText().isEmpty()) {
            Boolean editado = especialidadAdmon.cambiarEstadoEspecialidad(Integer.valueOf(textFieldID.getText()));
            if (editado) {
                cargarTabla();
                clicLimpiar(null);
                Ventanas.mostrarInfo("Estado actualizado correctamente");
            }
        }
    }

    public void clicLimpiar(ActionEvent event) {
        textFieldID.clear();
        textFieldDescripcion.clear();
        textFieldNombre.clear();
        comboBoxEstado.getSelectionModel().clearSelection();
        listViewMedicos.getItems().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabla();
        cargarTabla();
        comboBoxEstado.getItems().setAll("Activo", "Inactivo");
    }

    public void inicializarTabla() {
        tcId = new TableColumn<>("ID");
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));

        tcNombre = new TableColumn<>("Nombre");
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tcDescripcion = new TableColumn<>("Descripcion");
        tcDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        tcEstado = new TableColumn<>("Estado");
        tcEstado.setCellValueFactory(new PropertyValueFactory<>("estadoTexto"));

        tableViewEspecialidades.getColumns().setAll(tcId, tcNombre, tcDescripcion, tcEstado);
    }

    public void cargarTabla(){
        try{
            tableViewEspecialidades.getItems().setAll(especialidadAdmon.obtenerEspecialidadesActivas());
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
