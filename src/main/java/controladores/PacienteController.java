package controladores;

import Data.IRepository;
import controladores.Validador.MsgValidacion;
import controladores.Validador.TipoValidacion;
import controladores.Validador.Validador;
import modelos.Paciente;

public class PacienteController extends GeneralController<Paciente> {

    public PacienteController(IRepository repository) {
        super(repository);
    }

    @Override
    public boolean post(Paciente paciente) {
        if (verificarCampos(
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getEdad(),
                paciente.getCedula(),
                paciente.getCorreo(),
                paciente.getTelefono())) {
            return db.add(paciente);
        }
        return false;
    }

    @Override
    public boolean put(Paciente paciente) {
        if (verificarCampos(
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getEdad(),
                paciente.getCedula(),
                paciente.getCorreo(),
                paciente.getTelefono())) {
            return db.update(paciente);
        }
        return false;
    }

    private boolean verificarCampos(String nombre, String apellido, int edad, int cedula, String correo, int telefono) {
        Validador validador = new Validador();

        validador.agregarCampo(nombre, MsgValidacion.NOMBRE_INVALIDO,
                TipoValidacion.NO_NULO, TipoValidacion.CADENA_TEXTO_VALIDA, TipoValidacion.SOLO_LETRAS);

        validador.agregarCampo(apellido, MsgValidacion.APELLIDO_INVALIDO,
                TipoValidacion.NO_NULO, TipoValidacion.CADENA_TEXTO_VALIDA, TipoValidacion.SOLO_LETRAS);

        validador.agregarCampo(edad, MsgValidacion.EDAD_INVALIDA,
                TipoValidacion.NO_NULO, TipoValidacion.NUMERICO);

        validador.agregarCampo(cedula, MsgValidacion.CEDULA_INVALIDA,
                TipoValidacion.NO_NULO, TipoValidacion.NUMERICO);

        validador.agregarCampo(correo, MsgValidacion.CORREO_INVALIDO,
                TipoValidacion.NO_NULO);

        validador.agregarCampo(telefono, MsgValidacion.TELEFONO_INVALIDO,
                TipoValidacion.NO_NULO, TipoValidacion.NUMERICO);

        return validador.validarTodos();
    }

}