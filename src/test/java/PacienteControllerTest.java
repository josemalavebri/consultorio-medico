import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import controladores.PacienteController;
import Data.IRepository;
import modelos.Paciente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PacienteControllerTest {

    IRepository<Paciente> mockRepo;
    PacienteController controller;

    @BeforeEach
    void setup() {
        mockRepo = mock(IRepository.class);
        controller = new PacienteController(mockRepo);
    }

    @Test
    void get_RetornaListaValida() {
        Paciente p1 = mock(Paciente.class);
        Paciente p2 = mock(Paciente.class);

        when(mockRepo.all()).thenReturn(new ArrayList<>(Arrays.asList(p1, p2)));

        var resultado = controller.get();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    @Test
    void post_RetornaTrue() {
        Paciente paciente = mock(Paciente.class);

        when(paciente.getNombre()).thenReturn("Carlos");
        when(paciente.getApellido()).thenReturn("Ramírez");
        when(paciente.getEdad()).thenReturn(30);
        when(paciente.getCedula()).thenReturn(123456789);
        when(paciente.getCorreo()).thenReturn("carlos@mail.com");
        when(paciente.getTelefono()).thenReturn(987654321);

        when(mockRepo.add(paciente)).thenReturn(true);

        boolean resultado = controller.post(paciente);

        assertTrue(resultado);
    }

    @Test
    void put_RetornaTrue() {
        Paciente paciente = mock(Paciente.class);

        when(paciente.getNombre()).thenReturn("Ana");
        when(paciente.getApellido()).thenReturn("López");
        when(paciente.getEdad()).thenReturn(28);
        when(paciente.getCedula()).thenReturn(111223344);
        when(paciente.getCorreo()).thenReturn("ana@mail.com");
        when(paciente.getTelefono()).thenReturn(123456789);

        when(mockRepo.update(paciente)).thenReturn(true);

        boolean resultado = controller.put(paciente);

        assertTrue(resultado);
    }

    @Test
    void remove_RetornaTrue() {
        int idPaciente = 5;

        when(mockRepo.remove(idPaciente)).thenReturn(true);

        boolean resultado = controller.remove(idPaciente);

        assertTrue(resultado);
    }
}
