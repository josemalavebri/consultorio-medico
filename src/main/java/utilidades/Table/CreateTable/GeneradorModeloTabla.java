package utilidades.Table.CreateTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class GeneradorModeloTabla {

    public static String[] extraerNombresColumnas(Object objeto) {
        List<String> columnas = new ArrayList<>();
        List<Class<?>> clases = new ArrayList<>();
        Class<?> clase = objeto.getClass();

        while (clase != null && clase != Object.class) {
            clases.add(clase);
            clase = clase.getSuperclass();
        }

        for (int i = clases.size() - 1; i >= 0; i--) {
            Field[] campos = clases.get(i).getDeclaredFields();
            for (Field campo : campos) {
                columnas.add(campo.getName());
            }
        }
        return columnas.toArray(new String[0]);
    }
}
