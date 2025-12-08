package Data.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Paciente;

public class PacienteExternalRepository extends ExternalRepository<Paciente> {

    @Override
    public ArrayList<Paciente> all() {
        String sql = "SELECT p.id, p.correo, per.cedula, per.nombre, per.apellido, per.edad, per.telefono, per.genero " +
                     "FROM Paciente p " +
                     "INNER JOIN Persona per ON p.id = per.id";

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String correo = rs.getString("correo");
                int telefono = rs.getInt("telefono");
                String genero = rs.getString("genero");

                Paciente paciente = new Paciente(id, cedula, nombre, apellido, edad, correo, telefono, genero);
                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener pacientes: " + e.getMessage());
        }

        return pacientes;
    }

    @Override
    public boolean add(Paciente paciente) {
        String sqlPersona = "INSERT INTO Persona( cedula, nombre, apellido, edad, telefono, genero) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlPaciente = "INSERT INTO Paciente(correo) VALUES (?)";

        try (Connection conn = DBConnection.connect()) {
            conn.setAutoCommit(false); // Modo transaccional

            try (PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona);
                 PreparedStatement pstmtPaciente = conn.prepareStatement(sqlPaciente)) {

                pstmtPersona.setInt(1, paciente.getCedula());
                pstmtPersona.setString(2, paciente.getNombre());
                pstmtPersona.setString(3, paciente.getApellido());
                pstmtPersona.setInt(4, paciente.getEdad());
                pstmtPersona.setInt(5, paciente.getTelefono());
                pstmtPersona.setString(6, paciente.getGenero());
                pstmtPersona.executeUpdate();

                pstmtPaciente.setString(1, paciente.getCorreo());
                pstmtPaciente.executeUpdate();

                conn.commit();
                System.out.println("Paciente insertado correctamente en ambas tablas.");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error al insertar paciente: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Paciente paciente) {
        String sqlPersona = "UPDATE Persona SET cedula = ?, nombre = ?, apellido = ?, edad = ?, telefono = ?, genero = ? WHERE id = ?";
        String sqlPaciente = "UPDATE Paciente SET correo = ? WHERE id = ?";

        try (Connection conn = DBConnection.connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona);
                 PreparedStatement pstmtPaciente = conn.prepareStatement(sqlPaciente)) {

                pstmtPersona.setInt(1, paciente.getCedula());
                pstmtPersona.setString(2, paciente.getNombre());
                pstmtPersona.setString(3, paciente.getApellido());
                pstmtPersona.setInt(4, paciente.getEdad());
                pstmtPersona.setInt(5, paciente.getTelefono());
                pstmtPersona.setString(6, paciente.getGenero());
                pstmtPersona.setInt(7, paciente.getId());
                int filasPersona = pstmtPersona.executeUpdate();

                pstmtPaciente.setString(1, paciente.getCorreo());
                pstmtPaciente.setInt(2, paciente.getId());
                int filasPaciente = pstmtPaciente.executeUpdate();

                if (filasPersona > 0 || filasPaciente > 0) {
                    conn.commit();
                    System.out.println("Paciente actualizado correctamente.");
                    return true;
                } else {
                    conn.rollback();
                    System.out.println("No se encontró paciente con ID: " + paciente.getId());
                    return false;
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error al actualizar paciente: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        String sqlPaciente = "DELETE FROM Paciente WHERE id = ?";
        String sqlPersona = "DELETE FROM Persona WHERE id = ?";

        try (Connection conn = DBConnection.connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtPaciente = conn.prepareStatement(sqlPaciente);
                 PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona)) {

                pstmtPaciente.setInt(1, id);
                int filasPaciente = pstmtPaciente.executeUpdate();

                pstmtPersona.setInt(1, id);
                int filasPersona = pstmtPersona.executeUpdate();

                if (filasPaciente > 0 || filasPersona > 0) {
                    conn.commit();
                    System.out.println("Paciente eliminado correctamente.");
                    return true;
                } else {
                    conn.rollback();
                    System.out.println("No se encontró paciente con ID: " + id);
                    return false;
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error al eliminar paciente: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return false;
    }

  

}
