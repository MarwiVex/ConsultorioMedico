package consultorio.modelo;

import consultorio.modelo.enums.EstadoCita;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Integer id;
    private Paciente pacienteID;
    private Medico medicoID;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoCita estado;
    //Se pide en el SQL
    private Asistente asistenteID;
    private String observaciones;
    /*
    CREATE TABLE IF NOT EXISTS citas (
    id                  INTEGER PRIMARY KEY AUTOINCREMENT,
    paciente_id         INTEGER NOT NULL,
    medico_id           INTEGER NOT NULL,
    asistente_id        INTEGER NOT NULL,
    fecha_hora          TEXT NOT NULL,
    estado              INTEGER NOT NULL DEFAULT 1,
    observaciones       TEXT,
     */


    public Cita(Integer id, Paciente pacienteID, Asistente asistenteID, String observaciones, EstadoCita estado, LocalDate fecha, LocalTime hora, Medico medicoID) {
        this.id = id;
        this.pacienteID = pacienteID;
        this.asistenteID = asistenteID;
        this.observaciones = observaciones;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.medicoID = medicoID;
    }

    public Cita(Paciente pacienteID, Medico medicoID, Asistente asistenteID, LocalDate fecha, LocalTime hora) {
        this.pacienteID = pacienteID;
        this.medicoID = medicoID;
        this.asistenteID = asistenteID;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = EstadoCita.PROGRAMADA;
    }

    public Cita(Paciente pacienteID, Medico medicoID, Asistente asistenteID, LocalDate fecha, LocalTime hora, String observaciones) {
        this.pacienteID = pacienteID;
        this.medicoID = medicoID;
        this.asistenteID = asistenteID;
        this.fecha = fecha;
        this.hora = hora;
        this.observaciones = observaciones;
        this.estado = EstadoCita.PROGRAMADA;
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

    public Medico getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Medico medicoID) {
        this.medicoID = medicoID;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Asistente getAsistenteID() {
        return asistenteID;
    }

    public void setAsistenteID(Asistente asistenteID) {
        this.asistenteID = asistenteID;
    }
}
