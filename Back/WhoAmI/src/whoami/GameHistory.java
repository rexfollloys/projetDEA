package whoami;

public class GameHistory implements java.io.Serializable{
    private Game game_id;
    private Account player1_id;
    private Account player2_id;
    private int player1_score;
    private int player2_score;
    private int winner_id;

    public GameHistory() {
    }

    public GameHistory(Game game_id, Account player1_id, Account player2_id, int player1_score, int player2_score, int winner_id) {
        this.game_id = game_id;
        this.player1_id = player1_id;
        this.player2_id = player2_id;
        this.player1_score = player1_score;
        this.player2_score = player2_score;
        this.winner_id = winner_id;
    }

    public int getGameId() {
        return this.game_id;
    }

    public void setGameId(Game game_id) {
        this.game_id = game_id;
    }

    public int getPlayer1Id() {
        return this.player1_id;
    }

    public void setPlayer1Id(Account player1_id) {
        this.player1_id = player1_id;
    }

    public int getPlayer2Id() {
        return this.player2_id;
    }

    public void setPlayer2Id(Account player2_id) {
        this.player2_id = player2_id;
    }

    public int getPlayer1Score() {
        return this.player1_score;
    }

    public void setPlayer1Score(int player1_score) {
        this.player1_score = player1_score;
    }

    public int getPlayer2Score() {
        return this.player2_score;
    }

    public void setPlayer2Score(int player2_score) {
        this.player2_score = player2_score;
    }

    public int getWinnerId() {
        return this.winner_id;
    }

    public void setWinnerId(int winner_id) {
        this.winner_id = winner_id;
    }
}