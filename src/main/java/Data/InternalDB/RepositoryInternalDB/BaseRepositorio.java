package Data.InternalDB.RepositoryInternalDB;

import java.util.List;
import modelos.BaseEntity;

public abstract class BaseRepositorio<T extends BaseEntity> implements IBaseRepositorio<T>{

    protected BaseDatosInternal accesoDatos;

    public BaseRepositorio() {
        this.accesoDatos = BaseDatosInternal.getInstance();
    }
    
    protected void calcularId(List<T> listaEntidad, BaseEntity baseEntity){
        BaseEntity lastBaseEntity = listaEntidad.get(listaEntidad.size()-1);
        int lastId = lastBaseEntity.getId()+1;
        baseEntity.setId(lastId);
    }
    
    
    
    
}
