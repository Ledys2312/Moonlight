package Objects;

public class GameRanking {

    private int idUser;
    private String username;
    private int totalScore;
    private int wonGames;
    private int lostGames;

    public GameRanking(int idUser, String username, int totalScore, int lostGames, int wonGames) {
        this.idUser = idUser;
        this.username = username;
        this.totalScore = totalScore;
        this.lostGames = lostGames;
        this.wonGames = wonGames;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames = lostGames;
    }
}
