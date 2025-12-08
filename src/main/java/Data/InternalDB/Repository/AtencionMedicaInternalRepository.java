package Data.InternalDB.Repository;

import Data.InternalDB.RepositoryInternalDB.IBaseRepositorio;
import modelos.AtencionMedica;

public class AtencionMedicaInternalRepository extends GenericInternalRepository<AtencionMedica>{

    public AtencionMedicaInternalRepository(IBaseRepositorio actionEntidad) {
        super(actionEntidad);
    }
   
}
