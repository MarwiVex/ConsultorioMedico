package consultorio.modelo;

import consultorio.modelo.enums.Rol;

public abstract class Usuario extends Persona{
    protected String username;
    protected String contrasena;
    protected Boolean estado;
    protected Rol rol;

    public Usuario(Integer id, String nombre, String telefono, String correo, String username, String contrasena, Boolean estado, Rol rol) {
        super(id, nombre, telefono, correo);
        this.username = username;
        this.contrasena = contrasena;
        this.estado = estado;
        this.rol = rol;
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
}
