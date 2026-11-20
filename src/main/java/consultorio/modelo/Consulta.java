package consultorio.modelo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Consulta {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private Cita cita;
    private LocalDate fecha;
    private String sintomas;
    private String diagnostico;
    private String observaciones;
    private String tratamiento;
    //tabla hija
    private LinkedList<Prescripcion> prescripciones;

    public Consulta(Integer id, Paciente paciente, Medico medico, Cita cita, LocalDate fecha, String diagnostico, String observaciones, String tratamiento, String sintomas) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.cita = cita;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.tratamiento = tratamiento;
        this.sintomas = sintomas;
        this.prescripciones = new LinkedList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
