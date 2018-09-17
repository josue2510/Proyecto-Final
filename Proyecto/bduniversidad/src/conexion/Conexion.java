package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    private static Conexion instance;
    private Connection connection;
    private PreparedStatement sentencia = null;

    
    public Conexion(String user, String password, String dataBase) throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost/bduniversidad", "root", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void consulta(String sql) throws SQLException   {
		sentencia = connection.prepareStatement(sql);
	}
    
    public ResultSet resultado() throws SQLException  {
		return sentencia.executeQuery();
	}
    
    public int modificacion() throws SQLException {
		return sentencia.executeUpdate();
		
	}

    public static Conexion getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conexion(null, null, null);
        } else if (instance.getConnection().isClosed()) {
            instance = new Conexion(null, null, null);
        }

        return instance;
    }
    public void close() throws SQLException  {
		if (sentencia != null) {
			sentencia.close();
		}
		
		if (connection != null) {
			connection.close();
		}
	}
    
    public PreparedStatement getSentencia() {
		return sentencia;
	}


}