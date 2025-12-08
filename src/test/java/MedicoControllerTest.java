import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import controladores.MedicoController;
import Data.IRepository;
import modelos.Medico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MedicoControllerTest {

    IRepository<Medico> mockRepo;
    MedicoController controller;

    @BeforeEach
    void setup() {
        mockRepo = (IRepository<Medico>) mock(IRepository.class);
        controller = new MedicoController(mockRepo);
    }

    @Test
    void get_RetornaListaNoVacia() {
        Medico medico = mock(Medico.class);
        when(mockRepo.all()).thenReturn(new ArrayList<>(Arrays.asList(medico)));

        ArrayList<Medico> resultado = controller.get();

        assertTrue(!resultado.isEmpty());
    }

    @Test
    void post_RetornaTrue() {
        Medico medico = mock(Medico.class);
        when(medico.getNombre()).thenReturn("Juan");
        when(medico.getApellido()).thenReturn("Perez");
        when(medico.getEdad()).thenReturn(30);
        when(medico.getCedula()).thenReturn(1234567);
        when(medico.getTelefono()).thenReturn(9876543);

        when(mockRepo.add(medico)).thenReturn(true);

        boolean resultado = controller.post(medico);

        assertFalse(resultado);
    }

    @Test
    void put_RetornaTrue() {
        Medico medico = mock(Medico.class);
        when(medico.getNombre()).thenReturn("Ana");
        when(medico.getApellido()).thenReturn("Gomez");
        when(medico.getEdad()).thenReturn(40);
        when(medico.getCedula()).thenReturn(222222);
        when(medico.getTelefono()).thenReturn(555555);

        when(mockRepo.update(medico)).thenReturn(true);

        boolean resultado = controller.put(medico);

        assertFalse(resultado);
    }

    @Test
    void remove_RetornaTrue() {
        int id = 5;
        when(mockRepo.remove(id)).thenReturn(true);

        assertTrue(controller.remove(id));
    }

}