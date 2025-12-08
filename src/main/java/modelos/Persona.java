
package modelos;

public abstract class Persona extends BaseEntity{
    
    protected int cedula;
    protected int edad;
    protected String nombre;
    protected String apellido;
    protected int telefono;

 
    private String genero;

    
    public Persona() {
        super(0);
        this.cedula = 0;
        this.edad = 0;
        this.nombre = "";
        this.apellido = "";
        this.telefono = 0;
    }

    public Persona(int id, int cedula, int edad,String nombre, String apellido, int telefono, String genero) {
        super(id);
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.genero = genero;
    }
    

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return nombre + " "+apellido;
    }
    
       public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
