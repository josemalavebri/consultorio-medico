package controladores.Validador;

import java.util.*;
import javax.swing.JOptionPane;

public class Validador {

    private final List<ValidacionCampoConValor> camposAValidar = new ArrayList<>();

    public void agregarCampo(Object valor, String mensajeError, TipoValidacion... validaciones) {
        camposAValidar.add(new ValidacionCampoConValor(valor, mensajeError, validaciones));
    }

    public boolean validarTodos() {
        for (ValidacionCampoConValor entrada : camposAValidar) {
            if (!ValidadorDeCampos.validarCampo(entrada.valor, entrada.validaciones)) {
                JOptionPane.showMessageDialog(null, entrada.mensaje);
                return false;
            }
        }
        return true;
    }

    private static class ValidacionCampoConValor {
        private final Object valor;
        private final String mensaje;
        private final TipoValidacion[] validaciones;

        public ValidacionCampoConValor(Object valor, String mensaje, TipoValidacion... validaciones) {
            this.valor = valor;
            this.mensaje = mensaje;
            this.validaciones = validaciones;
        }
    }
}
