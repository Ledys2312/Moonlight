package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SignUpConnection {
    public static void main(String[] args) {

        String db_url = "jdbc:mysql://localhost:3306/Moonlight";
        String db_user = "root";
        String db_pass = "";

        try {
            Connection con = DriverManager.getConnection(db_url, db_user, db_pass);
        } catch (SQLException e) {
            System.out.println("Conexión fallida");;
        }

    }
}
