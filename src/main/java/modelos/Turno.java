package modelos;


public class Turno extends BaseEntity{

    private String fecha;
    private String hora;
    private String minuto;
    
    public Turno(){
        super(0);
    }
    
    public Turno(String fecha, String hora, String minuto) {
        super(0);
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public Turno(int id, String fecha, String hora, String minuto) {
        super(id);
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }
    
     public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return fecha + " - " + hora + ":" + minuto;
    }
     
     
}
