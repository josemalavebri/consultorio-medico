package utilidades.Table.CreateTable;

import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import controladores.Controller.ManagerController;
import modelos.BaseEntity;
import utilidades.Table.ButtonTable.ButtonEditor;
import utilidades.Table.ButtonTable.ButtonRenderer;
import utilidades.Table.CommandTable.ComandoListenerActualizar;
import utilidades.Table.CommandTable.ComandoListenerEliminar;
import vistas.IReceptorEntityJFrame;

public class ConstructorModeloTabla {

    private static final ManagerController managerController = ManagerController.getInstance();

        
    public static ObjectTableModel construirYAsignarModelo(Class<? extends BaseEntity> c){
        List listaDatos = managerController.get(c);
        ObjectTableModel objectTableModel = new ObjectTableModel(listaDatos);
        return objectTableModel;
    }
   
    public static void AgregarEventosEditarYEliminar(JTable table, IReceptorEntityJFrame frame) {
        ObjectTableModel general = (ObjectTableModel) table.getModel();

        if (general.findColumn("Modificar") == -1) {
            general.addColumn("Modificar");
            for (int i = 0; i < general.getRowCount(); i++) {
                general.setValueAt("Modificar", i, general.getColumnCount() - 1);
            }
        }

        if (general.findColumn("Eliminar") == -1) {
            general.addColumn("Eliminar");
            for (int i = 0; i < general.getRowCount(); i++) {
                general.setValueAt("Eliminar", i, general.getColumnCount() - 1);
            }
        }
        ComandoListenerEliminar eventoEliminar = new ComandoListenerEliminar(table);
        table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox(), "Eliminar", eventoEliminar));

        ComandoListenerActualizar eventoActualizar = new ComandoListenerActualizar(table, frame);
        table.getColumn("Modificar").setCellRenderer(new ButtonRenderer());
        table.getColumn("Modificar").setCellEditor(new ButtonEditor(new JCheckBox(), "Modificar", eventoActualizar));
    }
    
}
