package consultorio.modelo;

import consultorio.modelo.enums.Rol;

import java.time.LocalDateTime;

public class Medico extends Usuario{
    private int especialidadID;

    public Medico(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, LocalDateTime fechaAlta, int especialidadID) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol, fechaAlta);
        this.especialidadID = especialidadID;
    }

    public Medico(String nombre, String username, String contrasena, Rol rol, int especialidadID) {
        super(nombre, username, contrasena, rol);
        this.especialidadID = especialidadID;
    }

    public Medico(String nombre, String telefono, String correo, String username, String contrasena, Rol rol, int especialidadID) {
        super(nombre, telefono, correo, username, contrasena, rol);
        this.especialidadID = especialidadID;
    }

    public Medico(String nombre, String username, String contrasena, int especialidadID) {
        super(nombre, username, contrasena, Rol.MEDICO);
        this.especialidadID = especialidadID;
    }

    public Medico(String nombre, String telefono, String correo, String username, String contrasena, int especialidadID) {
        super(nombre, telefono, correo, username, contrasena, Rol.MEDICO);
        this.especialidadID = especialidadID;
    }

    public int getEspecialidadID() {
        return especialidadID;
    }

    public void setEspecialidadID(int especialidadID) {
        this.especialidadID = especialidadID;
    }

    @Override
    public String getRutaFxml() {
        return "/fxml/medico/medicoMenu.fxml";
    }
}
