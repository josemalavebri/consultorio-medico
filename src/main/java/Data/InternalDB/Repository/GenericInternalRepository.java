package Data.InternalDB.Repository;

import Data.IRepository;
import Data.InternalDB.RepositoryInternalDB.IBaseRepositorio;
import java.util.ArrayList;
import modelos.BaseEntity;

public abstract class GenericInternalRepository<T extends BaseEntity> implements IRepository<T>{
    
    protected IBaseRepositorio actionEntidad;
    
    public GenericInternalRepository(IBaseRepositorio actionEntidad) {
        this.actionEntidad = actionEntidad;
    }
    
    @Override
    public ArrayList<T> all() {
        return actionEntidad.select();
    }

    @Override
    public boolean add(T entity) {
        try{
            return actionEntidad.insert(entity);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(T entity) {
        return actionEntidad.put(entity);
    }

    @Override
    public boolean remove(int id) {
        return actionEntidad.delete(id);
    }
}

