package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import java.util.List;
import modelos.Paciente;

public class PacienteRepositorio extends BaseRepositorio<Paciente>{
    
    @Override
    public ArrayList<Paciente> select() {
        return this.accesoDatos.datosPacientes();
    }

    @Override
    public boolean insert(Paciente entidad) {
        List<Paciente> datosPaciente = this.accesoDatos.datosPacientes();
        calcularId(datosPaciente, entidad);
        return datosPaciente.add(entidad);
    }

    @Override
    public boolean delete(int id) {
        return this.accesoDatos.datosPacientes().removeIf(paciente -> paciente.getId()== id);
    }

    @Override
    public boolean put(Paciente entity) {
        ArrayList<Paciente> pacientes = this.accesoDatos.datosPacientes();
        for(int i = 0; i<pacientes.size();i++){
            if(pacientes.get(i).getId() == entity.getId()){
                pacientes.set(i, entity);
                return true;
            }
        }
        return false;
    }
    
}
