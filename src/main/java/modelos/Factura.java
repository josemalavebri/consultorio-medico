
package modelos;


public class Factura extends BaseEntity{

    private int numeroFactura;
    private CitaMedica citaMedica;
    private double TotalPagar;
    
    public Factura(){
        super(0);
    }
    
    public Factura(int id, int numeroFactura, CitaMedica citaMedica, double TotalPagar) {
        super(id);
        this.numeroFactura = numeroFactura;
        this.citaMedica = citaMedica;
        this.TotalPagar = TotalPagar;
    }
    
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }
}
