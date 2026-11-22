package consultorio.modelo;

public abstract class CatalogoBase {
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected boolean estado;

    public CatalogoBase(int id, String nombre, String descripcion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public CatalogoBase(String nombre) {
        this.nombre = nombre;
        this.descripcion = null;
        this.estado = true;
    }

    public CatalogoBase(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getEstadoTexto() {
        if (this.estado) {
            return "Activo";
        }
        return "Inactivo";
    }
}
