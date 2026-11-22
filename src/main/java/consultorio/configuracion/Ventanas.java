package consultorio.configuracion;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

//toda esta clase esta vibecodeada jajajaja
public class Ventanas {
    public static void cambiarContenidoVentana(Stage stage, String rutaFxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(Ventanas.class.getResource(rutaFxml));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void abrirVentanaModal(String rutaFxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(Ventanas.class.getResource(rutaFxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(titulo);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static boolean mostrarConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        Optional<ButtonType> respuesta = alert.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }

    public static void cerrarSesion(ActionEvent actionEvent) {
        if (Ventanas.mostrarConfirmacion("Confirmar cierre de sesion")) {
            SesionUsuario.getInstance().cerrarSesion();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Ventanas.cambiarContenidoVentana(stage, "/fxml/login.fxml", "Iniciar Sesión");
        }
    }
}
