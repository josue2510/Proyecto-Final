package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class conexion {
    
    private static conexion instance;
    private Connection connection;
    
    private conexion() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost/dbuniversidad", "root", "");
            this.connection.setAutoCommit(false);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static conexion getInstance() throws SQLException {
        if (instance == null) {
            instance = new conexion();
        } else if (instance.getConnection().isClosed()) {
            instance = new conexion();
        }

        return instance;
    }

}