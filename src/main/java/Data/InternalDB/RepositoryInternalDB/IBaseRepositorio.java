package Data.InternalDB.RepositoryInternalDB;

import java.util.ArrayList;
import modelos.BaseEntity;

public interface IBaseRepositorio<T extends BaseEntity> {
    ArrayList<T> select();
    boolean insert(T entity);
    boolean delete(int id);
    boolean put(T entity);
}
