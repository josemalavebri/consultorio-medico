/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import modelos.AtencionMedica;
import modelos.CitaMedica;
import modelos.Medico;
import modelos.Paciente;
import org.junit.jupiter.api.Test;

import controladores.Controller.ManagerController;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerControllerTest {
    
    public ManagerControllerTest() {
        
    }
    
    @Test
    void insertarEntidadesYValidarPost() {
        ManagerController manager = ManagerController.getInstance();
        assertFalse(manager.get(Paciente.class).isEmpty(), "La lista de pacientes está vacía");
        assertFalse(manager.get(Medico.class).isEmpty(), "La lista de médicos está vacía");
        assertFalse(manager.get(CitaMedica.class).isEmpty(), "La lista de citas está vacía");
        assertFalse(manager.get(AtencionMedica.class).isEmpty(), "La lista de atenciones médicas está vacía");

    }
}

    