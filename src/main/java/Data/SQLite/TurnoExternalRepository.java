package Data.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Turno;

public class TurnoExternalRepository extends ExternalRepository<Turno>{

    @Override
    public ArrayList<Turno> all() {
        String sql = "SELECT id, fecha, hora, minuto FROM Turno";
        ArrayList<Turno> turnos = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String minuto = rs.getString("minuto");
                Turno turno = new Turno(id, fecha, hora, minuto);
                turnos.add(turno);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener turnos: " + e.getMessage());
        }
        
        return turnos;
    }

    @Override
    public boolean add(Turno turno) {
        String sql = "INSERT INTO Turno(id, fecha, hora, minuto) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, turno.getId());
            pstmt.setString(2, turno.getFecha());
            pstmt.setString(3, turno.getHora());
            pstmt.setString(4, turno.getMinuto());

            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Turno insertado correctamente.");
                return true;
            } else {
                System.out.println("No se insertó el turno.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar turno: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Turno turno) {
        String sql = "UPDATE Turno SET fecha = ?, hora = ?, minuto = ? WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, turno.getFecha());
            pstmt.setString(2, turno.getHora());
            pstmt.setString(3, turno.getMinuto());
            pstmt.setInt(4, turno.getId());

            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Turno actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró turno con ID: " + turno.getId());
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar turno: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM Turno WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Turno eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró turno con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar turno: " + e.getMessage());
        }

        return false;
    }
    
}
