package consultorio.modelo.configuracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;

public class ConfiguracionPropiedades {
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String diasAtencion;
    private String url;
    private Properties propiedades;
    private static ConfiguracionPropiedades configuracionPropiedades;

    private ConfiguracionPropiedades(){
        try {
            FileInputStream fis = new FileInputStream("consultorio.properties");
            propiedades.load(fis);
            nombre = propiedades.getProperty("consultorio.nombre");
            horaInicio = LocalTime.parse(propiedades.getProperty("consultorio.horaInicio"));
            horaFin = LocalTime.parse(propiedades.getProperty("consultorio.horaFin"));
            diasAtencion = propiedades.getProperty("consultorio.diasAtencion");
            url = propiedades.getProperty("database.url");

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Error al leer propiedades");
        }
    }

    public static ConfiguracionPropiedades getInstance(){
        if(configuracionPropiedades==null){
            configuracionPropiedades = new ConfiguracionPropiedades();
        }
        return configuracionPropiedades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Properties getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Properties propiedades) {
        this.propiedades = propiedades;
    }

    public String getDiasAtencion() {
        return diasAtencion;
    }

    public void setDiasAtencion(String diasAtencion) {
        this.diasAtencion = diasAtencion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
