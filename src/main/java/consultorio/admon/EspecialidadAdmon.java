package consultorio.admon;

import consultorio.configuracion.ConexionBD;
import consultorio.modelo.Especialidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class EspecialidadAdmon {
    ConexionBD conexion = ConexionBD.getInstance();

    public String obtenerNombrePorId(int id) {
        String consulta = String.format("SELECT nombre FROM especialidades WHERE id = %d;", id);
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            if (resultado.next()) {
                return resultado.getString("nombre");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "Sin especialidad";
    }

    public LinkedList<Especialidad> obtenerEspecialidadesActivas() {
        LinkedList<Especialidad> especialidades = new LinkedList<>();
        String consulta = "SELECT * FROM especialidades WHERE activo = 1;";

        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                boolean activo = true;
                if (resultado.getInt("activo") != 1) {
                    activo = false;
                }
                Especialidad especialidad = new Especialidad(id, nombre, descripcion, activo);
                especialidades.add(especialidad);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return especialidades;
    }

    public LinkedList<Especialidad> obtenerEspecialidades() {
        LinkedList<Especialidad> especialidades = new LinkedList<>();
        String consulta = "SELECT * FROM especialidades;";

        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                boolean activo = true;
                if (resultado.getInt("activo") != 1) {
                    activo = false;
                }
                Especialidad especialidad = new Especialidad(id, nombre, descripcion, activo);
                especialidades.add(especialidad);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return especialidades;
    }

    public Boolean registrarEspecialidad(Especialidad especialidad) {
        int activo = 1;
        if (!especialidad.getEstado()) {
            activo = 0;
        }
        String sql = String.format("INSERT INTO especialidades (nombre, descripcion, activo) VALUES ('%s', '%s', %d);",
                especialidad.getNombre(),
                especialidad.getDescripcion(),
                activo);
        return conexion.ejecutarInstruccion(sql);
    }

    public Boolean editarEspecialidad(Especialidad especialidad) {
        int activo = 1;
        if (!especialidad.getEstado()) {
            activo = 0;
        }
        String sql = String.format("UPDATE especialidades SET nombre = '%s', descripcion = '%s', activo = %d WHERE id = %d;", especialidad.getNombre(), especialidad.getDescripcion(), activo, especialidad.getId());
        return conexion.ejecutarInstruccion(sql);
    }

    public Boolean cambiarEstadoEspecialidad(Integer id) {
        String consulta = String.format("SELECT activo FROM especialidades WHERE id = %d;", id);
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            if (resultado.next()) {
                int activoActual = resultado.getInt("activo");
                int nuevoActivo = 1;
                if (activoActual == 1) {
                    nuevoActivo = 0;
                }
                String sql = String.format("UPDATE especialidades SET activo = %d WHERE id = %d;", nuevoActivo, id);
                return conexion.ejecutarInstruccion(sql);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
