package Connection;

import Forms.LoginUpScreen;
import Objects.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginConnection {

    public static boolean registerUser(String name, String surname, String username, String password) {

        String sql = "INSERT INTO users(user_name, surname, username, contraseña) VALUES(?,?,?,?)";

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
            System.out.println("There was a problem while trying to register the user" + e.getMessage());
            return false;
        }

    }

    public static User authenticateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND contraseña = ?";

        try {
            Connection conn2 = ConnectionManager.getConnection();
            PreparedStatement ps2 = conn2.prepareStatement(sql);
            ps2.setString(1, username);
            ps2.setString(2, password);

            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                int id = rs2.getInt("id_user");
                String name = rs2.getString("user_name");
                String surname = rs2.getString("surname");
                String user = rs2.getString("username");
                String pass = rs2.getString("contraseña");

                return new User(id, name, surname, user, pass);
            }

            return null;
        } catch (SQLException e) {
            System.out.println("There was a problem while trying to authenticate the user" + e.getMessage());
            return null;
        }

    }
}
