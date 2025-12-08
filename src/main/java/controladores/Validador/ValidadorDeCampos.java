package controladores.Validador;

public class ValidadorDeCampos {

    public static boolean validarCampo(Object valor, TipoValidacion... validaciones) {
        for (TipoValidacion validacion : validaciones) {
            if (validacion == TipoValidacion.NO_NULO) {
                if (valor == null)
                    return false;
            }

            if (validacion == TipoValidacion.CADENA_TEXTO_VALIDA) {
                if (!esCadenaTextoValida(valor))
                    return false;
            }

            if (validacion == TipoValidacion.NUMERICO) {
                if (!esNumerico(valor))
                    return false;
            }

            if (validacion == TipoValidacion.SOLO_LETRAS) {
                if (!esSoloLetras(valor))
                    return false;
            }

            if (validacion == TipoValidacion.CORREO_ELECTRONICO) {
                if (!esCorreoValido(valor))
                    return false;
            }
        }
        return true;
    }

    private static boolean esNumerico(Object valor) {
        try {
            Double.parseDouble(valor.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean esCadenaTextoValida(Object valor) {
        String texto = valor.toString().trim();
        return !texto.isEmpty();
    }

    private static boolean esSoloLetras(Object valor) {
        return valor.toString().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    private static boolean esCorreoValido(Object valor) {
        String correo = valor.toString();
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

}
