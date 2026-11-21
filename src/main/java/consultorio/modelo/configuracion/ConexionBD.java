package consultorio.modelo.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD conexionBD = null;
    private ConfiguracionPropiedades configuracion = ConfiguracionPropiedades.getInstance();
    private Connection conexion;

    private ConexionBD(){
        try{
            conexion = DriverManager.getConnection(configuracion.getUrl());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ConexionBD getInstance(){
        if (conexionBD == null){
            conexionBD = new ConexionBD();
        }
        return conexionBD;
    }

    public ResultSet ejecutarConsulta(String consulta){
        ResultSet resultado = null;

        try{
            resultado = conexion.prepareStatement(consulta).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public Boolean ejecutarInstruccion(String instruccion){
        try {
            conexion.prepareStatement(instruccion).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Connection getConexion() {
        return conexion;
    }
}
