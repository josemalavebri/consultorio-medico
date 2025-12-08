
package InstallBD;

import com.sun.tools.javac.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class InstallDB {
  
    public void installDB(){
        String dbName = "ConsultorioMedico.db";
        String userHome = System.getProperty("user.home");
        String destDir = userHome + File.separator + "ConsultorioMedico";
        String destPath = destDir + File.separator + dbName;

        File destFile = new File(destPath);
        if (!destFile.exists()) {
            try {
                Files.createDirectories(Paths.get(destDir));
                try (InputStream is = Main.class.getResourceAsStream("/bd/" + dbName)) {
                    if (is == null) {
                        System.out.println("❌ No se encontró el archivo embebido: /bd/" + dbName);
                        return;
                    }
                    Files.copy(is, destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("📄 Base de datos copiada a: " + destPath);
                }
            } catch (IOException e) {
                System.out.println("❌ Error copiando la base de datos:");
                e.printStackTrace();
                return;
            }
        }

        String url = "jdbc:sqlite:" + destPath;
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
