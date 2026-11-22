package consultorio.servicios;

import consultorio.configuracion.ConexionBD;
import consultorio.modelo.*;
import consultorio.modelo.enums.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Autenticacion {
    private Usuario usuario;
    private ConexionBD conexion = ConexionBD.getInstance();

    public Usuario autenticar(String username, String contrasena){
        Usuario usuario=null;
        String consulta = String.format("SELECT * FROM usuarios WHERE username = '%s' AND password_hash = '%s' AND activo = 1;", username, contrasena);
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            if (resultado.next()){
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                String user = resultado.getString("username");
                String pass = resultado.getString("password_hash");
                java.time.LocalDateTime fechaAlta = java.time.LocalDateTime.now();
                boolean estado = true;
                if(resultado.getInt("activo")!=1){
                    estado = false;
                }
                int rol = resultado.getInt("rol");
                switch (rol){
                    case 1:
                        usuario = new Admin(id, nombre, telefono, correo, user, pass, estado, Rol.ADMIN, fechaAlta);
                        break;
                    case 2:
                        usuario = new Asistente(id, nombre, telefono, correo, user, pass, estado, Rol.ASISTENTE, fechaAlta);
                        break;
                    case 3:
                        int especialidadID = resultado.getInt("especialidad_id");
                        usuario = new Medico(id, nombre, telefono, correo, user, pass, estado, consultorio.modelo.enums.Rol.MEDICO, fechaAlta, especialidadID);
                        break;
                    default:
                        System.err.println("Error al ver el rol");
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }
}
