package consultorio.modelo;

import consultorio.modelo.enums.Rol;

import java.time.LocalDateTime;

public class Asistente extends Usuario{
    public Asistente(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, LocalDateTime fechaAlta) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol, fechaAlta);
    }

    @Override
    public String getRutaFxml() {
        return "fxml/asistenteMenu.fxml";
    }
}
