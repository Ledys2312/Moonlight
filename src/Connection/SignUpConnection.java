package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignUpConnection {

    private static final String db_url = "jdbc:mysql://localhost:3306/Moonlight";
    private static final String db_user = "root";
    private static final String db_passw = "";

    public static Connection getConnection() {


        try {
            Connection con = DriverManager.getConnection(db_url,db_user,db_passw);
            System.out.println("Conexion exitosa");
            return con;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            return null;
        }

    }
}
