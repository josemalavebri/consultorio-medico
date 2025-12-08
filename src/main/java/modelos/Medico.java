package modelos;

public class Medico extends Persona{
    
    private String especialidad;
    
    public Medico() {
        super(); 
        this.especialidad = "";
    }
    
    public Medico(int id, int cedula, int edad,String nombre, String apellido, String especialidad,String genero,int telefono) {
        super(id,cedula,edad,nombre,apellido,telefono,genero);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
  
}
