package consultorio.modelo;

import consultorio.modelo.enums.Rol;

public class Asistente extends Usuario{
    public Asistente(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol);
    }
}
