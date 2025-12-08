
package utilidades.Table.CommandTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import utilidades.Table.ButtonTable.ButtonEditor;
import utilidades.Table.CreateTable.ObjectTableModel;
import vistas.IReceptorEntityJFrame;

public class ComandoListenerActualizar implements ActionListener {
    private JTable tabla;
    private IReceptorEntityJFrame frame;

    public ComandoListenerActualizar(JTable tabla, IReceptorEntityJFrame frame) {
        this.tabla = tabla;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonEditor editor = (ButtonEditor) e.getSource();  
        int fila = editor.getRow();
        ObjectTableModel modelo = (ObjectTableModel) tabla.getModel();
        frame.setEntidad(modelo.getObjetoAt(fila));
        JFrame framas = (JFrame) frame;
        framas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framas.setVisible(true);
    }
}