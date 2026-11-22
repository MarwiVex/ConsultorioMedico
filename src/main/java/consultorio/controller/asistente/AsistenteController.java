package consultorio.controller.asistente;

import consultorio.configuracion.Ventanas;
import javafx.event.ActionEvent;

public class AsistenteController {

    public void clicPacientes(ActionEvent event) {
        Ventanas.abrirVentanaModal("/fxml/asistente/gestionPacientes.fxml", "Gestión de Pacientes");
    }

    public void clicCitas(ActionEvent event) {
        Ventanas.abrirVentanaModal("/fxml/asistente/gestionCitas.fxml", "Gestión de Citas y Agenda");
    }

    public void clicPerfil(ActionEvent event) {
        Ventanas.abrirVentanaModal("/fxml/perfilUsuario.fxml", "Mi Perfil");
    }

    public void clickCerrarSesion(ActionEvent event) {
        Ventanas.cerrarSesion(event);
    }
}
