package Data.InternalDB.Repository;

import modelos.Turno;
import Data.InternalDB.RepositoryInternalDB.IBaseRepositorio;

public class TurnoInternalRepository extends GenericInternalRepository<Turno>{

    public TurnoInternalRepository(IBaseRepositorio actionEntidad) {
        super(actionEntidad);
    } 
}
