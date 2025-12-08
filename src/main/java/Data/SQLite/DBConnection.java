
package Data.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static Connection conn = null;

    private static final String destPath = "ConsultorioMedico.db";


    public static Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:sqlite:" + destPath;
                conn = DriverManager.getConnection(url);
                System.out.println("✅ Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
    
    
}
