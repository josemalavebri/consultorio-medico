
package utilidades.Table.CommandTable;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import controladores.Controller.ManagerController;
import modelos.BaseEntity;
import utilidades.Table.ButtonTable.ButtonEditor;
import utilidades.Table.CreateTable.ObjectTableModel;

public class CommandEliminar implements Comando{


    private final ManagerController controlador;
    private final JTable tabla;
    private final ActionEvent e;

    public CommandEliminar(ActionEvent e, JTable tabla) {
        this.controlador = ManagerController.getInstance();
        this.tabla = tabla;
        this.e = e;
    }

    @Override
    public void ejecutar() {
        BaseEntity entidad = obtenerEntidadDesdeTabla();
        int id = obtenerId(entidad);
        Class<?> clase = obtenerClase(entidad);
        boolean isEliminate = eliminarEntidad(id, clase);
        if(isEliminate){
            JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
            refrescarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "NO ELIMINADO");
        }
    }

    private BaseEntity obtenerEntidadDesdeTabla() {
        ButtonEditor editor = (ButtonEditor) e.getSource();
        int fila = editor.getRow();
        ObjectTableModel modelo = (ObjectTableModel) tabla.getModel();
        return (BaseEntity) modelo.getObjetoAt(fila);
    }

    private int obtenerId(BaseEntity entidad) {
        return entidad.getId();
    }

    private Class<?> obtenerClase(BaseEntity entidad) {
        return entidad.getClass();
    }

    private boolean eliminarEntidad(int id, Class<?> clase) {
        return controlador.remove(id, clase);
    }

    
    private void refrescarTabla(){
        ComandoRefresh comandoRefresh = new ComandoRefresh((ObjectTableModel) tabla.getModel());
        comandoRefresh.ejecutar();
    }
    
}