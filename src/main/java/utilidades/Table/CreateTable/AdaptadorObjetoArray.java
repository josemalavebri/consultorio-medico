
package utilidades.Table.CreateTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorObjetoArray {
    
    public static Object[] convertirArrayObjects (Object objeto){
        
        List<Class<?>> clases = new ArrayList<>();
        List<Object> valores = new ArrayList<>();
        Class<?> clase = objeto.getClass();

        while (clase != null && clase != Object.class) {
            clases.add(clase);
            clase = clase.getSuperclass();
        }

        for (int i = clases.size() - 1; i >= 0; i--) {
            Field[] campos = clases.get(i).getDeclaredFields();
            
            for (Field campo : campos) {
                campo.setAccessible(true);
                try{
                    valores.add(campo.get(objeto));
                } catch (IllegalAccessException e){
                    valores.add(null);
                }
            }
        }
        
        return valores.toArray();
    }
    
}


