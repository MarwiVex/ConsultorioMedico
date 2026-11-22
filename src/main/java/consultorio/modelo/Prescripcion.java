package consultorio.modelo;

public class Prescripcion {
    private Integer id;
    private Consulta consultaID;
    private Medicamento medicamentoID;
    private String dosis;
    private String frecuencia;
    private String duracion;
    private String indicaciones;

    public Prescripcion(Integer id, Consulta consultaID, Medicamento medicamentoID, String dosis, String frecuencia, String duracion, String indicaciones) {
        this.id = id;
        this.consultaID = consultaID;
        this.medicamentoID = medicamentoID;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.indicaciones = indicaciones;
    }

    public Prescripcion(Medicamento medicamentoID, String dosis, String frecuencia, String duracion) {
        this.medicamentoID = medicamentoID;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
    }

    public Prescripcion(Medicamento medicamentoID, String dosis, String frecuencia, String duracion, String indicaciones) {
        this.medicamentoID = medicamentoID;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.indicaciones = indicaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medicamento getMedicamentoID() {
        return medicamentoID;
    }

    public void setMedicamentoID(Medicamento medicamentoID) {
        this.medicamentoID = medicamentoID;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Consulta getConsultaID() {
        return consultaID;
    }

    public void setConsultaID(Consulta consultaID) {
        this.consultaID = consultaID;
    }
}
