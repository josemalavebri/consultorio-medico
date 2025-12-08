package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import modelos.Turno;

public class TurnoRepositorio extends BaseRepositorio<Turno>{
    
    @Override
    public ArrayList<Turno> select() {
        return this.accesoDatos.datosTurnos();
    }

    @Override
    public boolean insert(Turno entidad) {
        return this.accesoDatos.datosTurnos().add(entidad);
    }

    @Override
    public boolean delete(int id) {
        return this.accesoDatos.datosTurnos().removeIf(paciente -> paciente.getId()== id);
    }

    @Override
    public boolean put(Turno entity) {
        ArrayList<Turno> turnos = this.accesoDatos.datosTurnos();
        for(int i = 0; i< turnos.size();i++){
            if(turnos.get(i).getId() == entity.getId()){
                turnos.set(i, entity);
                return true;
            }
        }
        return false;
    }
    
}
