
package utilidades.ComboBox;

import java.util.List;
import javax.swing.JComboBox;

import controladores.Controller.ManagerController;
import modelos.BaseEntity;


public class ComboBoxControl {
    private ManagerController managerController;
    
    public ComboBoxControl(){
        managerController = ManagerController.getInstance();
    }
    
    public List LlenarDatos(Class<? extends BaseEntity> c, JComboBox<String> comboBox){
        List lista = managerController.get(c); 
        comboBox.removeAllItems();
        for (var item : lista) {
            comboBox.addItem(item.toString());
        }
        
        return lista;
    }
  
}
