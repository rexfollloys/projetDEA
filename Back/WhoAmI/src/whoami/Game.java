package whoami;

public class Game implements java.io.Serializable{
    private int game_id;
    private String game_password;
    private int host_id;
    private int guest_id;
    private int number_of_rounds;
    private int turn_limit;
    private int grid_id;
    private boolean spectator;
    private String date;

    public Game() {
    }

    public Game(int game_id, String game_password, int host_id, int guest_id, int number_of_rounds, int turn_limit, int grid_id, boolean spectator, String date) {
        this.game_id = game_id;
        this.game_password = game_password;
        this.host_id = host_id;
        this.guest_id = guest_id;
        this.number_of_rounds = number_of_rounds;
        this.turn_limit = turn_limit;
        this.grid_id = grid_id;
        this.spectator = spectator;
        this.date = date;
    }

    public int getGameId() {
        return this.game_id;
    }

    public void setGameId(int game_id) {
        this.game_id = game_id;
    }

    public String getGamePassword() {
        return this.game_password;
    }

    public void setGamePassword(String game_password) {
        this.game_password = game_password;
    }

    public int getHostId() {
        return this.host_id;
    }

    public void setHostId(int host_id) {
        this.host_id = host_id;
    }

    public int getGuestId() {
        return this.guest_id;
    }

    public void setGuestId(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getNumberOfRounds() {
        return this.number_of_rounds;
    }

    public void setNumberOfRounds(int number_of_rounds) {
        this.number_of_rounds = number_of_rounds;
    }

    public int getTurnLimit() {
        return this.turn_limit;
    }

    public void setTurnLimit(int turn_limit) {
        this.turn_limit = turn_limit;
    }

    public int getGridId() {
        return this.grid_id;
    }

    public void setGridId(int grid_id) {
        this.grid_id = grid_id;
    }

    public boolean getSpectator() {
        return this.spectator;
    }

    public void setSpectator(boolean spectator) {
        this.spectator = spectator;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}