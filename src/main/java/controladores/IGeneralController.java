package controladores;

import java.util.ArrayList;



public interface IGeneralController <T> {
    ArrayList<T> get();

    boolean post(T objeto);

    boolean put(T objeto);

    boolean remove(int id);
    
  
    
    
}

