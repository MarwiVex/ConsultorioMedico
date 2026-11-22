package consultorio.admon;

import consultorio.configuracion.ConexionBD;
import consultorio.modelo.Admin;
import consultorio.modelo.Asistente;
import consultorio.modelo.Medico;
import consultorio.modelo.Usuario;
import consultorio.modelo.enums.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class UsuarioAdmon {
    private ConexionBD conexion = ConexionBD.getInstance();

    public LinkedList<Asistente> obtenerAsistentes() {
        LinkedList<Asistente> asistentes = new LinkedList<>();
        String consulta = "SELECT * FROM usuarios WHERE rol = 2;";
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                String username = resultado.getString("username");
                String contrasenia = resultado.getString("password_hash");
                LocalDateTime fechaAlta = LocalDateTime.now();
                Boolean estado = true;
                if (resultado.getInt("activo") != 1) {
                    estado = false;
                }
                Asistente asistente = new Asistente(id, nombre, telefono, correo, username, contrasenia, estado, Rol.ASISTENTE, fechaAlta);
                asistentes.add(asistente);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return asistentes;
    }

    public LinkedList<Medico> obtenerMedicos() {
        LinkedList<Medico> medicos = new LinkedList<>();
        String consulta = "SELECT * FROM usuarios WHERE rol = 3;";
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                String username = resultado.getString("username");
                String contrasenia = resultado.getString("password_hash");
                LocalDateTime fechaAlta = LocalDateTime.now();
                Boolean estado = true;
                Integer especialidadID = resultado.getInt("especialidad_id");
                if (resultado.getInt("activo") != 1) {
                    estado = false;
                }
                Medico medico = new Medico(id, nombre, telefono, correo, username, contrasenia, estado, Rol.MEDICO, fechaAlta, especialidadID);
                medicos.add(medico);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return medicos;
    }

    public LinkedList<Admin> obtenerAdmins() {
        LinkedList<Admin> admins = new LinkedList<>();
        String consulta = "SELECT * FROM usuarios WHERE rol = 1;";
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                String username = resultado.getString("username");
                String contrasenia = resultado.getString("password_hash");
                LocalDateTime fechaAlta = LocalDateTime.now();
                Boolean estado = true;
                if (resultado.getInt("activo") != 1) {
                    estado = false;
                }
                Admin admin = new Admin(id, nombre, telefono, correo, username, contrasenia, estado, Rol.ADMIN, fechaAlta);
                admins.add(admin);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return admins;
    }

    public Boolean registrarUsuario(Usuario usuario) {
        int activo = 1;
        if (!usuario.getEstado()) {
            activo = 0;
        }
        String especialidadID = "NULL";
        if (usuario instanceof Medico) {
            especialidadID = String.valueOf(((Medico) usuario).getEspecialidadID());
        }
        int rol = usuario.getRol().ordinal() + 1;
        String sql = String.format("INSERT INTO usuarios (nombre, telefono, correo, username, password_hash, rol, especialidad_id, activo) VALUES ('%s', '%s', '%s', '%s', '%s', %d, %s, %d);", usuario.getNombre(), usuario.getTelefono(), usuario.getCorreo(), usuario.getUsername(), usuario.getContrasena(), rol, especialidadID, activo);
        return conexion.ejecutarInstruccion(sql);
    }

    public Boolean editarUsuario(Usuario usuario) {
        int estado = 1;
        if (!usuario.getEstado()) {
            estado = 0;
        }
        String especialidadID = "NULL";
        if (usuario instanceof Medico) {
            especialidadID = String.valueOf(((Medico) usuario).getEspecialidadID());
        }
        String sql = String.format("UPDATE usuarios SET nombre = '%s', telefono = '%s', correo = '%s', username = '%s', password_hash = '%s', especialidad_id = %s, activo = %d WHERE id = %d;", usuario.getNombre(), usuario.getTelefono(), usuario.getCorreo(), usuario.getUsername(), usuario.getContrasena(), especialidadID, estado, usuario.getId());
        return conexion.ejecutarInstruccion(sql);
    }

    public Boolean cambiarEstadoUsuario(Integer id) {
        String consulta = String.format("SELECT activo FROM usuarios WHERE id = %d;", id);
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            if (resultado.next()) {
                int activoActual = resultado.getInt("activo");
                int nuevoActivo = 1;
                if (activoActual == 1) {
                    nuevoActivo = 0;
                }
                String sql = String.format("UPDATE usuarios SET activo = %d WHERE id = %d;", nuevoActivo, id);
                return conexion.ejecutarInstruccion(sql);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean eliminarUsuario(Integer id) {
        String sql = String.format("DELETE FROM usuarios WHERE id = %d;", id);
        return conexion.ejecutarInstruccion(sql);
    }

    public LinkedList<String> obtenerNombresMedicosPorEspecialidad(int especialidadID) {
        LinkedList<String> nombres = new LinkedList<>();
        String consulta = String.format("SELECT id, nombre, username FROM usuarios WHERE rol = 3 AND especialidad_id = %d;", especialidadID);
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String username = resultado.getString("username");
                Integer medicoID = resultado.getInt("id");

                nombres.add(String.format("%d - %s (%s)", medicoID, nombre, username));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return nombres;
    }
}
