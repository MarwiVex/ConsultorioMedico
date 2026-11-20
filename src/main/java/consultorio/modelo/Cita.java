package consultorio.modelo;

import consultorio.modelo.enums.EstadoCita;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoCita estado;
    //Se pide en el SQL
    private Asistente asistente;
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



    public Cita(Integer id, Paciente paciente, Medico medico, LocalDate fecha, LocalTime hora, EstadoCita estado) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
}
