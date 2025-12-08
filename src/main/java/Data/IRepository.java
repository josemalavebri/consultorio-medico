
package Data;

import java.util.ArrayList;
import modelos.BaseEntity;

public interface IRepository<T extends BaseEntity> {
    ArrayList<T> all();
    boolean add(T entity);
    boolean update(T entity);
    boolean remove(int id);
    
	
	
}