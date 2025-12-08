
package Data.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.BaseEntity;

public class DBDAOEjemplo extends ExternalRepository {
    
    public void insertarPaciente(String nombre, int edad, String telefono) {
        String sql = "INSERT INTO Paciente(nombre, edad, telefono) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, telefono);
            pstmt.executeUpdate();
            System.out.println("Paciente insertado con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar paciente: " + e.getMessage());
        }
    }

    public List<String> obtenerTodosLosPacientes() {
        String sql = "SELECT * FROM Paciente";
        List<String> pacientes = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String paciente = rs.getString("id") + " - " + rs.getString("correo") + " - " ;
                pacientes.add(paciente);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener pacientes: " + e.getMessage());
        }
        return pacientes;
    }

    // Actualizar paciente
    public void actualizarPaciente(int id, String nombre, int edad, String telefono) {
        String sql = "UPDATE Paciente SET nombre = ?, edad = ?, telefono = ? WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, telefono);
            pstmt.setInt(4, id);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Paciente actualizado.");
            } else {
                System.out.println(" No se encontró paciente con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Eliminar paciente
    public void eliminarPaciente(int id) {
        String sql = "DELETE FROM Paciente WHERE id = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println(" Paciente eliminado.");
            } else {
                System.out.println("No se encontró paciente con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    @Override
    public ArrayList all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
