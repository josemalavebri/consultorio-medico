
package controladores;

import Data.IRepository;
import modelos.Factura;


public class FacturaController extends GeneralController<Factura>{
    
    public FacturaController(IRepository repository){
        super(repository);
    }
    
}