package consultorio.controller.admin;

import consultorio.configuracion.SesionUsuario;
import consultorio.configuracion.Ventanas;
import consultorio.modelo.Asistente;
import consultorio.modelo.Especialidad;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AdminController {
    public void clicEspecialidades(ActionEvent actionEvent) {
        Ventanas.abrirVentanaModal("/fxml/admin/gestionEspecialidades.fxml", "Gestión de Especialidades");
    }

    public void clicMedicos(ActionEvent actionEvent) {
        Ventanas.abrirVentanaModal("/fxml/admin/gestionMedicos.fxml", "Gestión de Medicos");
    }

    public void clickAsistentes(ActionEvent actionEvent) {
        Ventanas.abrirVentanaModal("/fxml/admin/gestionAsistentes.fxml", "Gestión de Asistentes");
    }

    public void clickReportes(ActionEvent actionEvent) {
    }

    public void clickCerrarSesion(ActionEvent actionEvent) {
        Ventanas.cerrarSesion(actionEvent);
    }
}
