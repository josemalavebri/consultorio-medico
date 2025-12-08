
package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import java.util.List;
import modelos.AtencionMedica;


public class AtencionMedicaRepository extends BaseRepositorio<AtencionMedica> {

    public AtencionMedicaRepository() {
        
        
    }

    @Override
    public ArrayList<AtencionMedica> select() {
        return this.accesoDatos.datosAtencionesMedicas();
    }

    @Override
    public boolean insert(AtencionMedica entity) {
        List<AtencionMedica> listaAtenciones = this.accesoDatos.datosAtencionesMedicas();
        calcularId(listaAtenciones, entity);
        return listaAtenciones.add(entity);
    }

    @Override
    public boolean delete(int id) {
        return this.accesoDatos.datosAtencionesMedicas().removeIf(atencion -> atencion.getId() == id);
    }

    @Override
    public boolean put(AtencionMedica entity) {
        ArrayList<AtencionMedica> atenciones = this.accesoDatos.datosAtencionesMedicas();
        for (int i = 0; i < atenciones.size(); i++) {
            if (atenciones.get(i).getId() == entity.getId()) {
                atenciones.set(i, entity);
                return true;
            }
        }
        return false;
    }
}
