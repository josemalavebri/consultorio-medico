package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.*;

public class BaseDatosInternal {
    private static BaseDatosInternal instancia;
    private static ArrayList<Turno> listaTurnos;
    private static ArrayList<Paciente> listaPacientes;
    private static ArrayList<Medico> listaMedicos;
    private static ArrayList<CitaMedica> listaCitasMedicas;
    private static ArrayList<Factura> listaFacturas;
    private static ArrayList<AtencionMedica> listaAtencionesMedicas;

    private BaseDatosInternal(){
        listaPacientes = new ArrayList<>();
        listaMedicos = new ArrayList<>();
        listaTurnos = new ArrayList<>();
        listaCitasMedicas = new ArrayList<>();
        listaFacturas = new ArrayList<>();
    }
    
    public static BaseDatosInternal getInstance(){
        if(instancia==null){
            instancia = new BaseDatosInternal();
            cargarDatosTemporales();
        } 
        return instancia;
    }
    
    public ArrayList<Paciente> datosPacientes(){
        return listaPacientes;
    } 
    
    public ArrayList<Medico> datosMedicos(){
        return listaMedicos;
    }
    
    public ArrayList<Turno> datosTurnos(){
        return listaTurnos;
    }
    
    public ArrayList<CitaMedica> datosCitasMedicas(){
        return listaCitasMedicas;
    }
    
    public ArrayList<Factura> datosFacturas(){
        return listaFacturas;
    }
    
    public ArrayList<AtencionMedica> datosAtencionesMedicas(){
        return listaAtencionesMedicas;
    }
    
    private static void cargarDatosTemporales(){
        crearTurnosTemporales();
        crearPacienteTemporales();
        crearMedicosTemporales();
        crearCitasMedicasTemporales();
        crearAtencionesMedicasTemporales();
    }
    
    private static void crearTurnosTemporales(){
        String fechaFija = "19/5/2025";
        listaTurnos = new ArrayList<>();
        listaTurnos.add(new Turno(1, fechaFija, "08", "00"));
        listaTurnos.add(new Turno(2, fechaFija, "09", "00"));
        listaTurnos.add(new Turno(3, fechaFija, "10", "00"));
        listaTurnos.add(new Turno(4, fechaFija, "11", "00"));
        listaTurnos.add(new Turno(5, fechaFija, "12", "00"));
        listaTurnos.add(new Turno(6, fechaFija, "13", "00"));
        listaTurnos.add(new Turno(7, fechaFija, "14", "00"));
        listaTurnos.add(new Turno(8, fechaFija, "15", "00"));
        listaTurnos.add(new Turno(9, fechaFija, "16", "00"));
        listaTurnos.add(new Turno(10, fechaFija, "17", "00"));
    }
    
    private static void crearPacienteTemporales() {
        listaPacientes = new ArrayList<>();
        listaPacientes.add(new Paciente(1, 1723456789, "Ana", "Perez", 28, "ana.perez@mail.com", 991234567, "Femenino"));
        listaPacientes.add(new Paciente(2, 912345678, "Luis", "Gomez", 35, "luis.gomez@mail.com", 987654321, "Masculino"));
        listaPacientes.add(new Paciente(3, 801122334, "Marta", "Ramirez", 22, "marta.r@mail.com", 971122334, "Femenino"));
        listaPacientes.add(new Paciente(4, 609876543, "Carlos", "Lopez", 40, "carlos.l@mail.com", 965566778, "Masculino"));
        listaPacientes.add(new Paciente(5, 1109988776, "Lucia", "Fernandez", 30, "lucia.f@mail.com", 999988776, "Femenino"));
        listaPacientes.add(new Paciente(6, 203344556, "Pedro", "Suarez", 45, "pedro.suarez@mail.com", 954433221, "Masculino"));
        listaPacientes.add(new Paciente(7, 502233445, "Elena", "Cruz", 27, "elena.cruz@mail.com", 945678901, "Femenino"));
        listaPacientes.add(new Paciente(8, 1401122334, "Jorge", "Mendoza", 33, "jorge.m@mail.com", 981122334, "Masculino"));
        listaPacientes.add(new Paciente(9, 1019988776, "Camila", "Rios", 29, "camila.rios@mail.com", 979988776, "Femenino"));
        listaPacientes.add(new Paciente(10, 1712345678, "Andres", "Navarro", 38, "andres.n@mail.com", 966677889, "Masculino"));
    }

    
    private static void crearMedicosTemporales(){
        listaMedicos = new ArrayList<>();
        listaMedicos.add(new Medico(1, 1109988663, 20,"Carlos", "López", "Cardiología", "Masculino", 935679901));
        listaMedicos.add(new Medico(2, 913348678, 20,"Ana", "Gómez", "Pediatría", "Femenino", 925577900));
        listaMedicos.add(new Medico(5, 709973543, 20,"Mateo", "Díaz", "Traumatología", "Masculino", 915775979));
    }
    
    private static void crearCitasMedicasTemporales(){
        listaCitasMedicas = new ArrayList<>();
        int idCita = 1;
        Iterator<Paciente> iterPacientes = listaPacientes.iterator();
        Iterator<Medico> iterMedicos = listaMedicos.iterator();
        Iterator<Turno> iterTurnos = listaTurnos.iterator();

        while (iterPacientes.hasNext() && iterMedicos.hasNext() && iterTurnos.hasNext()) {
            Paciente paciente = iterPacientes.next();
            Medico medico = iterMedicos.next();
            Turno turno = iterTurnos.next();

            String descripcion = "Cita Medica Temporal";

            listaCitasMedicas.add(new CitaMedica(idCita++, paciente, medico, descripcion, turno));
        }
    }
    

    private static void crearAtencionesMedicasTemporales() {
        listaAtencionesMedicas = new ArrayList<>();
        int idAtencion = 1;

        String[] sintomasEjemplo = {
            "Dolor de cabeza y fiebre",
            "Dolor abdominal y náuseas",
            "Tos seca y congestión nasal",
            "Dolor de garganta y debilidad",
            "Fiebre alta y dolor en articulaciones"
        };

        String[] diagnosticosEjemplo = {
            "Gripe común",
            "Gastritis leve",
            "Resfriado",
            "Amigdalitis",
            "Dengue clásico"
        };

        String[] recetasEjemplo = {
            "Paracetamol cada 8 horas",
            "Omeprazol en ayunas",
            "Antigripal dos veces al día",
            "Ibuprofeno cada 6 horas",
            "Hidratación oral y reposo"
        };

        for (int i = 0; i < listaCitasMedicas.size(); i++) {
            CitaMedica cita = listaCitasMedicas.get(1);

            // Usa el índice para rotar los ejemplos
            String sintomas = sintomasEjemplo[i % sintomasEjemplo.length];
            String diagnostico = diagnosticosEjemplo[i % diagnosticosEjemplo.length];
            String receta = recetasEjemplo[i % recetasEjemplo.length];

            AtencionMedica atencion = new AtencionMedica(idAtencion++, cita, sintomas, diagnostico, receta);
            listaAtencionesMedicas.add(atencion);
        }
    }

    
    
}
