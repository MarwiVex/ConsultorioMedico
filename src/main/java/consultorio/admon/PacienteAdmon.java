package consultorio.admon;

import consultorio.configuracion.ConexionBD;
import consultorio.modelo.Paciente;
import consultorio.modelo.enums.Sexo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

public class PacienteAdmon {
    private ConexionBD conexion = ConexionBD.getInstance();

    public LinkedList<Paciente> obtenerPacientes() {
        LinkedList<Paciente> pacientes = new LinkedList<>();
        String consulta = "SELECT * FROM pacientes;";
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                LocalDate fechaNacimiento = LocalDate.parse(resultado.getString("fecha_nacimiento"));
                LocalDate fechaRegistro = LocalDate.parse(resultado.getString("fecha_registro"));
                Sexo sexo = Sexo.values()[resultado.getInt("sexo") - 1];

                Paciente paciente = new Paciente(id, nombre, telefono, correo, fechaNacimiento, fechaRegistro, sexo);
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return pacientes;
    }

    public Boolean registrarPaciente(Paciente paciente) {
        int sexo = paciente.getSexo().ordinal() + 1;
        String sql = String.format("INSERT INTO pacientes (nombre, fecha_nacimiento, sexo, telefono, correo) VALUES ('%s', '%s', %d, '%s', '%s');", paciente.getNombre(), paciente.getFechaNacimiento().toString(), sexo, paciente.getTelefono(), paciente.getCorreo());
        return conexion.ejecutarInstruccion(sql);
    }

    public Boolean editarPaciente(Paciente paciente) {
        int sexo = paciente.getSexo().ordinal() + 1;
        String sql = String.format("UPDATE pacientes SET nombre = '%s', fecha_nacimiento = '%s', sexo = %d, telefono = '%s', correo = '%s' WHERE id = %d;", paciente.getNombre(), paciente.getFechaNacimiento().toString(), sexo, paciente.getTelefono(), paciente.getCorreo(), paciente.getId());
        return conexion.ejecutarInstruccion(sql);
    }

    public Boolean eliminarPaciente(Integer id) {
        String sql = String.format("DELETE FROM pacientes WHERE id = %d;", id);
        return conexion.ejecutarInstruccion(sql);
    }

    public LinkedList<Paciente> buscarPacientes(String criterio) {
        LinkedList<Paciente> pacientes = new LinkedList<>();
        //usar %%s%% para consulta que busque en cualquier parte de atributo el crtiterio, para manadar un %criterio% a la consulta
        String consulta = String.format("SELECT * FROM pacientes WHERE nombre LIKE '%%%s%%' OR telefono LIKE '%%%s%%' OR id LIKE '%%%s%%';", criterio, criterio, criterio);
        try {
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                LocalDate fechaNacimiento = LocalDate.parse(resultado.getString("fecha_nacimiento"));
                LocalDate fechaRegistro = LocalDate.parse(resultado.getString("fecha_registro"));
                Sexo sexo = Sexo.values()[resultado.getInt("sexo") - 1];
                Paciente paciente = new Paciente(id, nombre, telefono, correo, fechaNacimiento, fechaRegistro, sexo);
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return pacientes;
    }
}
