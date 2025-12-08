package utilidades.Controller;

import Data.InternalDB.Repository.AtencionMedicaInternalRepository;
import Data.InternalDB.Repository.CitaMedicaInternalRepository;
import Data.InternalDB.Repository.MedicoInternalRepository;
import Data.InternalDB.Repository.TurnoInternalRepository;
import Data.InternalDB.RepositoryInternalDB.AtencionMedicaRepository;
import Data.InternalDB.RepositoryInternalDB.CitaMedicaRepositorio;
import Data.InternalDB.RepositoryInternalDB.MedicoRepositorio;
import Data.InternalDB.RepositoryInternalDB.TurnoRepositorio;
import Data.SQLite.AtencionMedicaExternalRepository;
import Data.SQLite.CitaMedicaExternalRepository;
import Data.SQLite.MedicoExternalRepository;
import Data.SQLite.PacienteExternalRepository;
import Data.SQLite.TurnoExternalRepository;
import controladores.AtencionMedicaController;
import controladores.CitaMedicaController;
import controladores.IGeneralController;
import controladores.MedicoController;
import controladores.PacienteController;
import controladores.TurnoController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelos.AtencionMedica;
import modelos.BaseEntity;
import modelos.CitaMedica;
import modelos.Medico;
import modelos.Paciente;
import modelos.Turno;


public class ManagerController{
    private static ManagerController managerControllerInstance;
    private final Map<Class<? extends BaseEntity>, IGeneralController<?>> controllers = new HashMap<>();
    
    public ManagerController() {
        controllers.put(Medico.class, new MedicoController(new MedicoExternalRepository()));
        controllers.put(Paciente.class, new PacienteController(new PacienteExternalRepository()));
        controllers.put(CitaMedica.class, new CitaMedicaController(new CitaMedicaExternalRepository()));
        controllers.put(Turno.class, new TurnoController(new TurnoExternalRepository()));
        controllers.put(AtencionMedica.class, new AtencionMedicaController(new AtencionMedicaExternalRepository()));
    }
    
    public static ManagerController getInstance(){
        if(managerControllerInstance == null ){
            managerControllerInstance = new ManagerController();
        }
        return managerControllerInstance;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList get(Class<? extends BaseEntity> c) {
        IGeneralController ctrl = tryGetController(c);
        if (ctrl != null) {
            return ctrl.get();
        } else {
            throw new IllegalArgumentException("Entidad no soportada: " + c);
        }
    }
    
    @SuppressWarnings("unchecked")
    public <T> boolean put(T entidad) {
        IGeneralController ctrl = tryGetController(entidad.getClass());
        if (ctrl != null) {
            return ctrl.put(entidad);
        } else {
            throw new IllegalArgumentException("Entidad no soportada: " + entidad.getClass());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public <T> boolean post(T entidad){
        IGeneralController ctrl = tryGetController(entidad.getClass());
        if(ctrl != null){
            return ctrl.post(entidad);
        } else {
            throw new IllegalArgumentException("Entidad no soportada: " + entidad.getClass());
        }
    }
    
    @SuppressWarnings("unchecked")
    public boolean remove(int id, Class<?> c){
        IGeneralController ctrl = tryGetController(c);
        return ctrl.remove(id);
    }
    
    private IGeneralController tryGetController(Class<?> c){
        try{
            IGeneralController ctrl = (IGeneralController) controllers.get(c);
            return ctrl;
        } catch(Exception ex){
            throw new IllegalArgumentException("Entidad no soportada: " + c);
        }
    }
}