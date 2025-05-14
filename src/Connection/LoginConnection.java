package Connection;

import Forms.LoginUpScreen;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginConnection {

    public static boolean registerUser(String name, String surname, String username, String password) {

        String sql = "INSERT INTO login(user_name, surname, username, contraseña) VALUES(?,?,?,?)";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, username);
            ps.setString(4, password);

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("There was a problem while trying to register the user");
            return false;
        }

    }
}
