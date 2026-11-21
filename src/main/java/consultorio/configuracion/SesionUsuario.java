package consultorio.configuracion;

import consultorio.modelo.Usuario;
import consultorio.modelo.enums.Rol;

public class SesionUsuario {
    private Usuario usuario;
    private Rol rol;

    public SesionUsuario(){
        rol = usuario.getRol();
    }


}
