/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;

import controladores.Validador.TipoValidacion;
import controladores.Validador.Validador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author josem
 */
public class ValidacionesTesteo {
    
    public ValidacionesTesteo() {
    }
    
    @Test
    @DisplayName("Debe Verificar que solo se introduzca un texto valido")
    void textoValido(){
        TipoValidacion[] tipoValidaciones = {TipoValidacion.CADENA_TEXTO_VALIDA,TipoValidacion.LONGITUD_MAXIMA,TipoValidacion.LONGITUD_MINIMA,TipoValidacion.SOLO_LETRAS};
        Validador validador = new Validador();
        validador.agregarCampo("", "Texto No Valido", tipoValidaciones);
        boolean result = validador.validarTodos();
        assertTrue(result, "Algo falló");
    }
    
}
