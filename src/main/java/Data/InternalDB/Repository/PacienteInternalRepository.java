package Data.InternalDB.Repository;

import modelos.Paciente;
import Data.InternalDB.RepositoryInternalDB.IBaseRepositorio;

public class PacienteInternalRepository extends GenericInternalRepository<Paciente>{

    public PacienteInternalRepository(IBaseRepositorio actionEntidad) {
        super(actionEntidad);
    }
    
}