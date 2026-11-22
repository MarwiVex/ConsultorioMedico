package consultorio.modelo;

public class Medicamento extends CatalogoBase{
    public Medicamento(int id, String nombre, String descripcion, boolean activo) {
        super(id, nombre, descripcion, activo);
    }

    public Medicamento(String nombre) {
        super(nombre);
    }

    public Medicamento(String nombre, String descripcion) {
        super(nombre, descripcion);
    }
}
