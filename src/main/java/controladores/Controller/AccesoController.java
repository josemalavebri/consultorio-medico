
package controladores.Controller;

import Data.InternalDB.Repository.PacienteInternalRepository;
    import Data.IRepository;
import Data.InternalDB.RepositoryInternalDB.PacienteRepositorio;
import controladores.*;
import Data.InternalDB.RepositoryInternalDB.IBaseRepositorio;





public class AccesoController {
  
    private final IGeneralController medicoController;
    private final IGeneralController pacienteController;
    private IGeneralController turnoController;
    private IGeneralController citaMedicaController;
    private IGeneralController facturaController;
    private final IRepository repository;
    private final IBaseRepositorio actionEntidad;
    
    public AccesoController(){
        actionEntidad = new PacienteRepositorio();
        repository = new PacienteInternalRepository(actionEntidad);
        medicoController = new MedicoController(repository);
        pacienteController = new PacienteController(repository);
    }
    
    
    public IGeneralController facturaController(){
        return facturaController;
    }
   
    public IGeneralController turnosController(){
        return turnoController;
    }
    
    public IGeneralController citaMedicaController(){
        return citaMedicaController;
    }
    
    public IGeneralController pacienteController(){
        return pacienteController;
    }
    
    public IGeneralController medicoController(){
        return medicoController;
    }
    
    
    
    
}
