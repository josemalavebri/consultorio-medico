
package controladores;

import Data.IRepository;
import modelos.AtencionMedica;

public class AtencionMedicaController extends GeneralController<AtencionMedica>{
    
    public AtencionMedicaController(IRepository repository){
        super(repository);
    }
    
}