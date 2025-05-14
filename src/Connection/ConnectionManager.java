package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String url = "jdbc:mysql://localhost:3306/moonlight";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "mysql";

    // Singleton Connection object (https://en.wikipedia.org/wiki/Singleton_pattern)
    private static Connection connection = null;

    // Constructor privat per prevenir que es creiïn instàncies d'aquesta classe
    private ConnectionManager( ) { }

    /**
     * Get the database connection.
     * @throws SQLException if connection cannot be established
     */
    public static Connection getConnection( ) throws SQLException {
        // Comprovem que no estigui ja creada (només es crea la 1a vegada que es demana)
        if (connection == null || connection.isClosed()) try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            throw new SQLException( ex );
        }
        return connection;
    }
}
