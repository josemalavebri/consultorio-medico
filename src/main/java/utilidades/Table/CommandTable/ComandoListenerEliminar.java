
package utilidades.Table.CommandTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class ComandoListenerEliminar implements ActionListener {
    private final JTable tabla;

    public ComandoListenerEliminar(JTable tabla) {
        this.tabla = tabla;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Comando eliminar = new CommandEliminar(e, tabla);
        eliminar.ejecutar();
    }
    
}