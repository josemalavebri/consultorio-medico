
package controladores;

import Data.IRepository;
import controladores.Validador.MsgValidacion;
import controladores.Validador.TipoValidacion;
import controladores.Validador.Validador;
import modelos.Medico;

public class MedicoController extends GeneralController<Medico> {

    public MedicoController(IRepository repository) {
        super(repository);
    }

    @Override
    public boolean post(Medico medico) {
        if (!verificarCampos(medico.getNombre(), medico.getApellido(), medico.getEdad(), medico.getCedula(),
                medico.getTelefono())) {
            return db.add(medico);
        }
        return false;
    }

    @Override
    public boolean put(Medico medico) {
        if (!verificarCampos(medico.getNombre(), medico.getApellido(), medico.getEdad(), medico.getCedula(),
                medico.getTelefono())) {
            return db.update(medico);
        }
        return false;
    }

    private boolean verificarCampos(String nombre, String apellido, int edad, int cedula, int telefono) {
        Validador validador = new Validador();

        validador.agregarCampo(nombre, MsgValidacion.NOMBRE_INVALIDO,
                TipoValidacion.NO_NULO, TipoValidacion.CADENA_TEXTO_VALIDA, TipoValidacion.SOLO_LETRAS);

        validador.agregarCampo(apellido, MsgValidacion.APELLIDO_INVALIDO,
                TipoValidacion.NO_NULO, TipoValidacion.CADENA_TEXTO_VALIDA, TipoValidacion.SOLO_LETRAS);

        validador.agregarCampo(edad, MsgValidacion.EDAD_INVALIDA,
                TipoValidacion.NO_NULO, TipoValidacion.NUMERICO);

        validador.agregarCampo(cedula, MsgValidacion.CEDULA_INVALIDA,
                TipoValidacion.NO_NULO, TipoValidacion.NUMERICO);

        validador.agregarCampo(telefono, MsgValidacion.TELEFONO_INVALIDO,
                TipoValidacion.NO_NULO, TipoValidacion.NUMERICO);

        return validador.validarTodos();
    }
}