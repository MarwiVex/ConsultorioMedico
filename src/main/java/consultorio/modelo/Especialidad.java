package consultorio.modelo;

public class Especialidad extends CatalogoBase{
    public Especialidad(int id, String nombre, String descripcion, boolean activo) {
        super(id, nombre, descripcion, activo);
    }

    public Especialidad(String nombre) {
        super(nombre);
    }

    public Especialidad(String nombre, String descripcion) {
        super(nombre, descripcion);
    }
}
