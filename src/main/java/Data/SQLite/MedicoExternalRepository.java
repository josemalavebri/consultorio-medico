package Data.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Medico;

public class MedicoExternalRepository extends ExternalRepository<Medico>{

    @Override
    public ArrayList<Medico> all() {
        String sql = "SELECT m.id, per.cedula, per.nombre, per.apellido, per.edad, per.telefono, per.genero, m.especialidad " +
                 "FROM Medico m " +
                 "INNER JOIN Persona per ON m.id = per.id";

        ArrayList<Medico> medicos = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int telefono = rs.getInt("telefono");
                String genero = rs.getString("genero");
                String especialidad = rs.getString("especialidad");

                Medico medico = new Medico(id, cedula, edad, nombre, apellido, especialidad, genero, telefono);
                medicos.add(medico);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener médicos: " + e.getMessage());
        }

        return medicos;
    }

    @Override
    public boolean add(Medico medico) {
        String sqlPersona = "INSERT INTO Persona( cedula, nombre, apellido, edad, telefono, genero) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlMedico = "INSERT INTO Medico( especialidad) VALUES (?)";

        try (Connection conn = DBConnection.connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona);
                 PreparedStatement pstmtMedico = conn.prepareStatement(sqlMedico)) {

                pstmtPersona.setInt(1, medico.getCedula());
                pstmtPersona.setString(2, medico.getNombre());
                pstmtPersona.setString(3, medico.getApellido());
                pstmtPersona.setInt(4, medico.getEdad());
                pstmtPersona.setInt(5, medico.getTelefono());
                pstmtPersona.setString(6, medico.getGenero());
                pstmtPersona.executeUpdate();

                pstmtMedico.setString(1, medico.getEspecialidad());
                pstmtMedico.executeUpdate();

                conn.commit();
                System.out.println("Médico insertado correctamente en ambas tablas.");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error al insertar médico: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Medico medico) {
        String sqlPersona = "UPDATE Persona SET cedula = ?, nombre = ?, apellido = ?, edad = ?, telefono = ?, genero = ? WHERE id = ?";
        String sqlMedico = "UPDATE Medico SET especialidad = ? WHERE id = ?";

        try (Connection conn = DBConnection.connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona);
                 PreparedStatement pstmtMedico = conn.prepareStatement(sqlMedico)) {

                pstmtPersona.setInt(1, medico.getCedula());
                pstmtPersona.setString(2, medico.getNombre());
                pstmtPersona.setString(3, medico.getApellido());
                pstmtPersona.setInt(4, medico.getEdad());
                pstmtPersona.setInt(5, medico.getTelefono());
                pstmtPersona.setString(6, medico.getGenero());
                pstmtPersona.setInt(7, medico.getId());
                int filasPersona = pstmtPersona.executeUpdate();

                pstmtMedico.setString(1, medico.getEspecialidad());
                pstmtMedico.setInt(2, medico.getId());
                int filasMedico = pstmtMedico.executeUpdate();

                if (filasPersona > 0 || filasMedico > 0) {
                    conn.commit();
                    System.out.println("Médico actualizado correctamente.");
                    return true;
                } else {
                    conn.rollback();
                    System.out.println("No se encontró médico con ID: " + medico.getId());
                    return false;
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error al actualizar médico: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        String sqlMedico = "DELETE FROM Medico WHERE id = ?";
        String sqlPersona = "DELETE FROM Persona WHERE id = ?";

        try (Connection conn = DBConnection.connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtMedico = conn.prepareStatement(sqlMedico);
                 PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona)) {

                pstmtMedico.setInt(1, id);
                int filasMedico = pstmtMedico.executeUpdate();

                pstmtPersona.setInt(1, id);
                int filasPersona = pstmtPersona.executeUpdate();

                if (filasMedico > 0 || filasPersona > 0) {
                    conn.commit();
                    System.out.println("Médico eliminado correctamente.");
                    return true;
                } else {
                    conn.rollback();
                    System.out.println("No se encontró médico con ID: " + id);
                    return false;
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error al eliminar médico: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return false;
    }
    
}
