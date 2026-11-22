package consultorio.modelo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Consulta {
    private Integer id;
    private Paciente pacienteID;
    private Medico medicoID;
    private Cita citaID;
    private LocalDate fecha;
    private String sintomas;
    private String diagnostico;
    private String observaciones;
    private String tratamiento;
    //tabla hija
    private LinkedList<Prescripcion> prescripciones;

    public Consulta(Integer id, Paciente pacienteID, Medico medicoID, Cita citaID, LocalDate fecha, String diagnostico, String observaciones, String tratamiento, String sintomas) {
        this.id = id;
        this.pacienteID = pacienteID;
        this.medicoID = medicoID;
        this.citaID = citaID;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.tratamiento = tratamiento;
        this.sintomas = sintomas;
        this.prescripciones = new LinkedList<>();
    }

    public Consulta(Paciente pacienteID, Medico medicoID, Cita citaID, String diagnostico, String sintomas, String observaciones, String tratamiento) {
        this.pacienteID = pacienteID;
        this.medicoID = medicoID;
        this.citaID = citaID;
        this.fecha = LocalDate.now();
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.observaciones = observaciones;
        this.tratamiento = tratamiento;
        this.prescripciones = new LinkedList<>();
    }

    public Consulta(Paciente pacienteID, Medico medicoID, Cita citaID, String diagnostico) {
        this.pacienteID = pacienteID;
        this.medicoID = medicoID;
        this.citaID = citaID;
        this.fecha = LocalDate.now();
        this.diagnostico = diagnostico;
        this.prescripciones = new LinkedList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Paciente pacienteID) {
        this.pacienteID = pacienteID;
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

    public Medico getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Medico medicoID) {
        this.medicoID = medicoID;
    }

    public Cita getCitaID() {
        return citaID;
    }

    public void setCitaID(Cita citaID) {
        this.citaID = citaID;
    }

    public LinkedList<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(LinkedList<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
    }
}
