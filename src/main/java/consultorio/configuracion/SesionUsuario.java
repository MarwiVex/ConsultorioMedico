package consultorio.configuracion;

import consultorio.modelo.Usuario;
import consultorio.modelo.enums.Rol;

public class SesionUsuario {
    private static SesionUsuario sesionUsuario;
    private Usuario usuarioLogueado;

    private SesionUsuario(){
    }

    public static SesionUsuario getInstance(){
        if(sesionUsuario == null){
            sesionUsuario = new SesionUsuario();
        }
        return sesionUsuario;
    }

    public void setUsuarioLogueado(Usuario usuario){
        this.usuarioLogueado = usuario;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }
    public void cerrarSesion() {
        this.usuarioLogueado = null;
    }


}
