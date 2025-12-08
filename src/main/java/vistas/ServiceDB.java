
package vistas;
import java.util.List;

import controladores.Controller.ManagerController;
import modelos.BaseEntity;


public class ServiceDB<T extends BaseEntity> {
    private final Class<T> tipoEntidad;
    private final ManagerController managerController = ManagerController.getInstance();
    
    public ServiceDB(Class<T> tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public boolean guardar(T entidad) {
        return managerController.post(entidad);
    }

    public boolean eliminar(T entidad) {
        return managerController.remove(entidad.getId(), tipoEntidad);
    }

    public List<T> obtenerTodos() {
        return managerController.get(tipoEntidad);
    }

    public boolean actualizar(T entidad){
        return managerController.put(tipoEntidad);

    }
    
}
