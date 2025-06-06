package Connection;

import Objects.GameRanking;
import Objects.SessionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class GameConnection {

    public static List<GameRanking> getRankings() {

        List<GameRanking> rankings = new ArrayList<>();

        String sql = """ 
                    Select users.id_user, users.username, 
                    sum(games.total_points) as total_points, 
                    sum(case when games.result = 'Winner' then 1 else 0 end) as 'won_games', 
                    sum(case when games.result = 'Loser' then 1 else 0 end) as 'lost_games' 
                    from users join games on users.id_user = games.id_user 
                    group by users.id_user, users.username 
                    order by total_points desc; """;

        try {
            Connection conn3 = ConnectionManager.getConnection();
            PreparedStatement stm = conn3.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int id_user = rs.getInt("id_user");
                String username = rs.getString("username");
                int points = rs.getInt("total_points");
                int won = rs.getInt("won_games");
                int lost = rs.getInt("lost_games");

                rankings.add(new GameRanking(id_user,username,points,won,lost));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rankings;
    }

    public static void saveGameResults(String difficulty, String result, int points) {

        String sql = "INSERT INTO games (id_user, level_difficulty, result, total_points ) VALUES (?,?,?,?)";

        try {
            Connection conn4 = ConnectionManager.getConnection();
            PreparedStatement stm2 = conn4.prepareStatement(sql);

            int id_user = SessionManager.getCurrentUser().getId();

            stm2.setInt(1, id_user);
            stm2.setString(2, difficulty);
            stm2.setString(3, result);
            stm2.setInt(4, points);

            stm2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}