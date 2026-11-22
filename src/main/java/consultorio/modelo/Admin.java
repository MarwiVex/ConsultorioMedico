package consultorio.modelo;

import consultorio.modelo.enums.Rol;

import java.time.LocalDateTime;

public class Admin extends Usuario{
    public Admin(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, LocalDateTime fechaAlta) {
        super(id, nombre, telefono, correo, username, contrasena, estado, rol, fechaAlta);
    }

    public Admin(String nombre, String username, String contrasena) {
        super(nombre, username, contrasena, Rol.ADMIN);
    }

    public Admin(String nombre, String telefono, String correo, String username, String contrasena) {
        super(nombre, telefono, correo, username, contrasena, Rol.ADMIN);
    }

    @Override
    public String getRutaFxml() {
        return "/fxml/admin/adminMenu.fxml";
    }


}
