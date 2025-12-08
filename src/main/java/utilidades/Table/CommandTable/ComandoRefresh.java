
package utilidades.Table.CommandTable;

import java.util.List;

import controladores.Controller.ManagerController;
import modelos.BaseEntity;
import utilidades.Table.CreateTable.ObjectTableModel;


public class ComandoRefresh implements Comando{

    private ManagerController manager;
    private final ObjectTableModel objectTableModel;
    
    public ComandoRefresh(ObjectTableModel objectTableModel){
        this.objectTableModel = objectTableModel;
        manager = ManagerController.getInstance();
    }

    @Override
    public void ejecutar() {
        BaseEntity baseEntity = objectTableModel.getObjetoAt(0);
        List<BaseEntity> datos = manager.get(baseEntity.getClass());
        objectTableModel.removeAll();
        objectTableModel.llenarDatosTabla(datos);
    }
    
}
