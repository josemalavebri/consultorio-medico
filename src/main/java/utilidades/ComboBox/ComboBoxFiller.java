
package utilidades.ComboBox;

import java.util.List;
import javax.swing.JComboBox;


public class ComboBoxFiller {
    
    public static <T>void llenarComboBox(JComboBox<String> comboBox, List<T> lista){
        comboBox.removeAllItems();
        for (T item : lista) {
            comboBox.addItem(item.toString());
        }
    }
    
}
