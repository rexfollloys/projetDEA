package whoami;

public class Round implements java.io.Serializable{
    private int round_id;
    private Game game_id;
    private int round_number;
    private Account winner_id;

    public Round() {
    }

    public Round(int round_id, Game game_id, int round_number, Account winner_id) {
        this.round_id = round_id;
        this.game_id = game_id;
        this.round_number = round_number;
        this.winner_id = winner_id;
    }

    public int getRoundId() {
        return this.round_id;
    }

    public void setRoundId(int round_id) {
        this.round_id = round_id;
    }

    public int getGameId() {
        return this.game_id;
    }

    public void setGameId(Game game_id) {
        this.game_id = game_id;
    }

    public int getRoundNumber() {
        return this.round_number;
    }

    public void setRoundNumber(int round_number) {
        this.round_number = round_number;
    }

    public int getWinnerId() {
        return this.winner_id;
    }

    public void setWinnerId(Account winner_id) {
        this.winner_id = winner_id;
    }
}