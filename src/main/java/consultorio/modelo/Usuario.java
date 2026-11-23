package consultorio.modelo;

import consultorio.modelo.enums.Rol;

import java.time.LocalDateTime;

public abstract class Usuario extends Persona{
    protected String username;
    protected String contrasena;
    protected Boolean estado;
    protected Rol rol;
    //aparece en sql
    protected LocalDateTime fechaAlta;

    public Usuario(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol, LocalDateTime fechaAlta) {
        super(id, nombre, telefono, correo);
        this.username = username;
        this.contrasena = contrasena;
        this.estado = estado;
        this.rol = rol;
        this.fechaAlta = fechaAlta;
    }

    public Usuario(String nombre, String username, String contrasena, Rol rol) {
        super(nombre);
        this.username = username;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = true;
        this.fechaAlta = LocalDateTime.now();
    }

    public Usuario(String nombre, String telefono, String correo, String username, String contrasena, Rol rol) {
        super(nombre, telefono, correo);
        this.username = username;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = true;
        this.fechaAlta = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public String getEstadoTexto() {
        if (this.estado) {
            return "Activo";
        }
        return "Inactivo";

    }

    public abstract String getRutaFxml();
}
