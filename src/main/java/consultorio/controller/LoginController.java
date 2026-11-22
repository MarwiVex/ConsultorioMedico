package consultorio.controller;
import consultorio.configuracion.SesionUsuario;
import consultorio.configuracion.Ventanas;
import consultorio.modelo.Usuario;
import consultorio.servicios.Autenticacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField textFieldContrasenia;
    private Autenticacion autentica;
    private Usuario usuario;
    private SesionUsuario sesionUsuario;

    public LoginController(){
        autentica = new Autenticacion();
        sesionUsuario = SesionUsuario.getInstance();
    }

    public void clicLogin(ActionEvent actionEvent) {
        usuario = autentica.autenticar(textFieldUsuario.getText(), textFieldContrasenia.getText());
        if(usuario==null){
            System.err.println("Datos incorrectos");
            Ventanas.mostrarError("Datos incorrectos");
            return;
        }
        Stage stage = (Stage) textFieldUsuario.getScene().getWindow();
        sesionUsuario.setUsuarioLogueado(usuario);
        Ventanas.cambiarContenidoVentana(stage, usuario.getRutaFxml(), String.format("Panel de %s", usuario.getRol()));

    }
}
