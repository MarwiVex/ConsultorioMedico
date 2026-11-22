package consultorio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PerfilUsuarioController implements Initializable {
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldCorreo;
    @FXML
    private PasswordField passwordFieldActual;
    @FXML
    private PasswordField passwordFieldNueva;
    @FXML
    private PasswordField passwordFieldConfirmar;

    public void clicGuardarDatos(ActionEvent event) {
    }

    public void clicCambiarContrasenia(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
