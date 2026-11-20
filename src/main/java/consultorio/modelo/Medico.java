package consultorio.modelo;

import consultorio.modelo.enums.Rol;

public class Medico extends Usuario{
    private Especialidad especialidad;

    public Medico(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, Especialidad especialidad) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol);
        this.especialidad = especialidad;
    }
}
