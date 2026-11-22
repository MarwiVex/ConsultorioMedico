package consultorio.modelo;

import consultorio.modelo.enums.Sexo;

import java.time.LocalDate;

public class Paciente extends Persona{
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private Sexo sexo;

    public Paciente(Integer id, String nombre, String telefono, String correo, LocalDate fechaNacimiento, LocalDate fechaRegistro, Sexo sexo) {
        super(id, nombre, telefono, correo);
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.sexo = sexo;
    }

    public Paciente(String nombre, LocalDate fechaNacimiento, Sexo sexo) {
        super(nombre);
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fechaRegistro = LocalDate.now();
    }

    public Paciente(String nombre, String telefono, String correo, LocalDate fechaNacimiento, Sexo sexo) {
        super(nombre, telefono, correo);
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
        this.sexo = sexo;
    }

    public Paciente(String nombre, LocalDate fechaNacimiento, Sexo sexo, LocalDate fechaRegistro) {
        super(nombre);
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fechaRegistro = fechaRegistro;
    }

    public Paciente(String nombre, String telefono, String correo, LocalDate fechaNacimiento, LocalDate fechaRegistro, Sexo sexo) {
        super(nombre, telefono, correo);
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
