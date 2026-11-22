package consultorio.modelo;

import consultorio.modelo.enums.Rol;

import java.time.LocalDateTime;

public class Asistente extends Usuario{
    public Asistente(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, LocalDateTime fechaAlta) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol, fechaAlta);
    }

    public Asistente(String nombre, String username, String contrasena) {
        super(nombre, username, contrasena, Rol.ASISTENTE);
    }

    public Asistente(String nombre, String telefono, String correo, String username, String contrasena) {
        super(nombre, telefono, correo, username, contrasena, Rol.ASISTENTE);
    }

    @Override
    public String getRutaFxml() {
        return "/fxml/asistente/asistenteMenu.fxml";
    }
}
