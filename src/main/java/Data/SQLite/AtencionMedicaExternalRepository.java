package Data.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.AtencionMedica;
import modelos.CitaMedica;
import modelos.Medico;
import modelos.Paciente;
import modelos.Turno;

public class AtencionMedicaExternalRepository extends ExternalRepository<AtencionMedica>{

    @Override
    public ArrayList<AtencionMedica> all() {
        String sql = "SELECT a.id AS atencionId, a.sintomas, a.diagnostico, a.receta, " +
             "c.id AS citaId, c.descripcion, " +
             "p.id AS pacienteId, pp.cedula AS pacienteCedula, pp.nombre AS pacienteNombre, pp.apellido AS pacienteApellido, pp.edad AS pacienteEdad, pp.telefono AS pacienteTelefono, pp.genero AS pacienteGenero, p.correo AS pacienteCorreo, " +
             "m.id AS medicoId, mp.cedula AS medicoCedula, mp.nombre AS medicoNombre, mp.apellido AS medicoApellido, mp.edad AS medicoEdad, mp.telefono AS medicoTelefono, mp.genero AS medicoGenero, m.especialidad AS medicoEspecialidad, " +
             "t.id AS turnoId, t.fecha, t.hora, t.minuto " +
             "FROM AtencionMedica a " +
             "INNER JOIN CitaMedica c ON a.cita_medica_id = c.id " +
             "INNER JOIN Paciente p ON c.paciente_id = p.id " +
             "INNER JOIN Persona pp ON p.id = pp.id " +
             "INNER JOIN Medico m ON c.medico_id = m.id " +
             "INNER JOIN Persona mp ON m.id = mp.id " +
             "INNER JOIN Turno t ON c.turno_id = t.id";

        ArrayList<AtencionMedica> atenciones = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Construir Paciente
                Paciente paciente = new Paciente(
                    rs.getInt("pacienteId"),
                    rs.getInt("pacienteCedula"),
                    rs.getString("pacienteNombre"),
                    rs.getString("pacienteApellido"),
                    rs.getInt("pacienteEdad"),
                    rs.getString("pacienteCorreo"),
                    rs.getInt("pacienteTelefono"),
                    rs.getString("pacienteGenero")
                );

                // Construir Medico
                Medico medico = new Medico(
                    rs.getInt("medicoId"),
                    rs.getInt("medicoCedula"),
                    rs.getInt("medicoEdad"),
                    rs.getString("medicoNombre"),
                    rs.getString("medicoApellido"),
                    rs.getString("medicoEspecialidad"),
                    rs.getString("medicoGenero"),
                    rs.getInt("medicoTelefono")
                );

                // Construir Turno
                Turno turno = new Turno(
                    rs.getInt("turnoId"),
                    rs.getString("fecha"),
                    rs.getString("hora"),
                    rs.getString("minuto")
                );

                // Construir CitaMedica
                CitaMedica citaMedica = new CitaMedica(
                    rs.getInt("citaId"),
                    paciente,
                    medico,
                    rs.getString("descripcion"),
                    turno
                );

                // Construir AtencionMedica
                AtencionMedica atencion = new AtencionMedica(
                    rs.getInt("atencionId"),
                    citaMedica,
                    rs.getString("sintomas"),
                    rs.getString("diagnostico"),
                    rs.getString("receta")
                );

                atenciones.add(atencion);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener atenciones médicas: " + e.getMessage());
        }

    return atenciones;
    }

    @Override
    public boolean add(AtencionMedica atencion) {
        String sql = "INSERT INTO AtencionMedica(cita_medica_id, sintomas, diagnostico, receta) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, atencion.getCitaMedica().getId());
            pstmt.setString(2, atencion.getSintomas());
            pstmt.setString(3, atencion.getDiagnostico());
            pstmt.setString(4, atencion.getReceta());


            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Atención médica insertada correctamente.");
                return true;
            } else {
                System.out.println("No se insertó la atención médica.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar atención médica: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(AtencionMedica atencion) {
        String sql = "UPDATE AtencionMedica SET cita_medica_id = ?, sintomas = ?, diagnostico = ?, receta = ? WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, atencion.getCitaMedica().getId());
            pstmt.setString(2, atencion.getSintomas());
            pstmt.setString(3, atencion.getDiagnostico());
            pstmt.setString(4, atencion.getReceta());
            pstmt.setInt(5, atencion.getId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Atención médica actualizada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró atención médica con ID: " + atencion.getId());
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar atención médica: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM AtencionMedica WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Atención médica eliminada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró atención médica con ID: " + id);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar atención médica: " + e.getMessage());
        }

        return false;
    }
}
