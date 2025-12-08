
package utilidades.Table.ControlTable;

import javax.swing.JTable;
import modelos.BaseEntity;
import utilidades.Table.CreateTable.ConstructorModeloTabla;
import utilidades.Table.RefreshTable.RefreshTable;
import vistas.IReceptorEntityJFrame;


public class ControlTable {
    private final RefreshTable refreshTable;
    
    public ControlTable(){
        refreshTable = RefreshTable.getInstance();
    }
    
    public void registrarTabla(Class<?> c, JTable table){
        refreshTable.suscribir(c.toString(), table);
    }
    
    public void llenarTablaDatos(Class<? extends BaseEntity> c, JTable table){
        table.setModel(ConstructorModeloTabla.construirYAsignarModelo(c));
        table.setRowHeight(30);
    } 
    
    public void eventosTabla(JTable table, IReceptorEntityJFrame frame){
        ConstructorModeloTabla.AgregarEventosEditarYEliminar(table, frame);
    }
    
    public void refrescarTodasTablas(){
        refreshTable.refrescarTodas();
    }

}
