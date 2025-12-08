package modelos;

public class AtencionMedica extends BaseEntity {
    public CitaMedica citaMedica;
    public String sintomas;
    public String diagnostico;
    public String receta;
    
    public AtencionMedica(int id) {
        super(id);
        sintomas = "";
        diagnostico = "";
        receta = "";
    }
    
    public AtencionMedica(int id, CitaMedica citaMedica, String sintomas, String diagnostico, String receta) {
        super(id);
        this.citaMedica = citaMedica;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }    

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
    
    
}