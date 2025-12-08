package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import java.util.List;
import modelos.CitaMedica;

public class CitaMedicaRepositorio extends BaseRepositorio<CitaMedica>{
    
    @Override
    public ArrayList<CitaMedica> select() {
        
        
        return this.accesoDatos.datosCitasMedicas();
    }

    @Override
    public boolean insert(CitaMedica entidad) {
        List<CitaMedica> citasMedicas = this.accesoDatos.datosCitasMedicas();
        calcularId(citasMedicas, entidad);
        return citasMedicas.add(entidad);
    }

    @Override
    public boolean delete(int id) {
        return this.accesoDatos.datosCitasMedicas().removeIf(paciente -> paciente.getId()== id);
    }

    @Override
    public boolean put(CitaMedica entity) {
        ArrayList<CitaMedica> citasMedicas = this.accesoDatos.datosCitasMedicas();
        for(int i = 0; i< citasMedicas.size();i++){
            if(citasMedicas.get(i).getId() == entity.getId()){
                citasMedicas.set(i, entity);
                return true;
            }
        }
        return false;
    }
    
}
