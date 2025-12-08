package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import java.util.List;
import modelos.Medico;

public class MedicoRepositorio extends BaseRepositorio<Medico>{
    
    public MedicoRepositorio(){
    }
    
    @Override
    public ArrayList<Medico> select() {
        return this.accesoDatos.datosMedicos();
    }

    @Override
    public boolean insert(Medico entidad) {
        List<Medico> listaMedicos = this.accesoDatos.datosMedicos();
        calcularId(listaMedicos, entidad);
        return listaMedicos.add(entidad);
    }
    
    @Override
    public boolean delete(int id) {
        return this.accesoDatos.datosMedicos().removeIf(medico -> medico.getId()== id);
    }

    @Override
    public boolean put(Medico entity) {
        ArrayList<Medico> medicos = this.accesoDatos.datosMedicos();
        for(int i = 0; i< medicos.size();i++){
            if(medicos.get(i).getId() == entity.getId()){
                medicos.set(i, entity);
                return true;
            }
        }
        return false;
    }
    
}
