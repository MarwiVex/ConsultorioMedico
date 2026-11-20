package consultorio.modelo;

import consultorio.modelo.enums.Rol;

import java.time.LocalDateTime;

public class Medico extends Usuario{
    private Especialidad especialidad;

    public Medico(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, LocalDateTime fechaAlta, Especialidad especialidad) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol, fechaAlta);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String getRutaFxml() {
        return "fxml/medicoMenu.fxml";
    }
}
