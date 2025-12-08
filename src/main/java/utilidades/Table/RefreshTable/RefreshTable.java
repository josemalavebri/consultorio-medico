
package utilidades.Table.RefreshTable;

import java.util.HashMap;
import javax.swing.JTable;
import utilidades.Table.CommandTable.Comando;
import utilidades.Table.CommandTable.ComandoRefresh;
import utilidades.Table.CreateTable.ObjectTableModel;


public class RefreshTable  {

    private final HashMap<String, JTable> tables = new HashMap<>();
    
    private static RefreshTable refreshTable;
    private RefreshTable(){ }
    
    public void suscribir(String clase, JTable table){
        tables.put(clase, table);
    }
    
    public void refrescar(JTable table){
        ObjectTableModel objectTableModel = (ObjectTableModel) table.getModel();
        Comando comando = new ComandoRefresh(objectTableModel);
        comando.ejecutar();
    }
    
    public void refrescarTodas(){
        for(var tableValueKey : tables.entrySet()){
            JTable table = tableValueKey.getValue();
            Comando comando = new ComandoRefresh( (ObjectTableModel) table.getModel());
            comando.ejecutar();
        }
    }

    public static RefreshTable getInstance(){
        if(refreshTable == null){
            refreshTable = new RefreshTable();
        }
        return refreshTable;
    }
    
 
}
