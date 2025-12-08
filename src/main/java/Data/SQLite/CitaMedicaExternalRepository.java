package Data.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.CitaMedica;
import modelos.Medico;
import modelos.Paciente;
import modelos.Turno;

public class CitaMedicaExternalRepository extends ExternalRepository<CitaMedica> {

    @Override
    public ArrayList<CitaMedica> all() {
        String sql = "SELECT " +
                "c.id AS id, " +
                "c.descripcion AS descripcion, " +

                "p.id AS paciente_id, " +
                "p.cedula AS paciente_cedula, " +
                "p.nombre AS paciente_nombre, " +
                "p.apellido AS paciente_apellido, " +
                "p.edad AS paciente_edad, " +
                "pa.correo AS paciente_correo, " +
                "p.telefono AS paciente_telefono, " +
                "p.genero AS paciente_genero, " +

                "m.id AS medico_id, " +
                "p2.cedula AS medico_cedula, " +
                "p2.edad AS medico_edad, " +
                "p2.nombre AS medico_nombre, " +
                "p2.apellido AS medico_apellido, " +
                "m.especialidad AS medico_especialidad, " +
                "p2.genero AS medico_genero, " +
                "p2.telefono AS medico_telefono, " +

                "t.id AS turno_id, " +
                "t.fecha AS fecha, " +
                "t.hora AS hora, " +
                "t.minuto AS minuto " +

                "FROM CitaMedica c " +
                "INNER JOIN Paciente pa ON c.paciente_id = pa.id " +
                "INNER JOIN Persona p ON pa.id = p.id " +
                "INNER JOIN Medico m ON c.medico_id = m.id " +
                "INNER JOIN Persona p2 ON m.id = p2.id " +
                "INNER JOIN Turno t ON c.turno_id = t.id";

        ArrayList<CitaMedica> citas = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getInt("paciente_id"),
                        rs.getInt("paciente_cedula"),
                        rs.getString("paciente_nombre"),
                        rs.getString("paciente_apellido"),
                        rs.getInt("paciente_edad"),
                        rs.getString("paciente_correo"),
                        rs.getInt("paciente_telefono"),
                        rs.getString("paciente_genero"));

                Medico medico = new Medico(
                        rs.getInt("medico_id"),
                        rs.getInt("medico_cedula"),
                        rs.getInt("medico_edad"),
                        rs.getString("medico_nombre"),
                        rs.getString("medico_apellido"),
                        rs.getString("medico_especialidad"),
                        rs.getString("medico_genero"),
                        rs.getInt("medico_telefono"));

                Turno turno = new Turno(
                        rs.getInt("turno_id"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("minuto"));

                CitaMedica cita = new CitaMedica(
                        rs.getInt("id"),
                        paciente,
                        medico,
                        rs.getString("descripcion"),
                        turno);

                citas.add(cita);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener citas médicas: " + e.getMessage());
        }

        return citas;
    }

    @Override
    public boolean add(CitaMedica citaMedica) {
        String sql = "INSERT INTO CitaMedica(descripcion, paciente_id, medico_id, turno_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, citaMedica.getDescripcion());
            pstmt.setInt(2, citaMedica.getPaciente().getId());
            pstmt.setInt(3, citaMedica.getMedico().getId());

            if (citaMedica.getTurno() != null) {
                pstmt.setInt(4, citaMedica.getTurno().getId());
            } else {
                pstmt.setNull(4, java.sql.Types.INTEGER);
            }

            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Cita médica insertada correctamente.");
                return true;
            } else {
                System.out.println("No se pudo insertar la cita médica.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar cita médica: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(CitaMedica citaMedica) {
        String sql = "UPDATE CitaMedica SET descripcion = ?, paciente_id = ?, medico_id = ?, turno_id = ? WHERE id = ?";

        try (Connection conn = DBConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, citaMedica.getDescripcion());
            pstmt.setInt(2, citaMedica.getPaciente().getId());
            pstmt.setInt(3, citaMedica.getMedico().getId());
            pstmt.setInt(4, citaMedica.getTurno().getId());
            pstmt.setInt(5, citaMedica.getId());

            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Cita médica actualizada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró cita médica con ID: " + citaMedica.getId());
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar cita médica: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM CitaMedica WHERE id = ?";

        try (Connection conn = DBConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Cita médica eliminada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró cita médica con ID: " + id);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar cita médica: " + e.getMessage());
        }

        return false;
    }
}
