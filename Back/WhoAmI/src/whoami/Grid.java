package whoami;

public class Grid implements java.io.Serializable{
    private int grid_id;
    private String grid_name;
    private int grid_size;
    private boolean random;

    public Grid() {
    }

    public Grid(int grid_id, String grid_name, int grid_size, boolean random) {
        this.grid_id = grid_id;
        this.grid_name = grid_name;
        this.grid_size = grid_size;
        this.random = random;
    }

    public int getGridId() {
        return this.grid_id;
    }

    public void setGridId(int grid_id) {
        this.grid_id = grid_id;
    }

    public String getGridName() {
        return this.grid_name;
    }

    public void setGridName(String grid_name) {
        this.grid_name = grid_name;
    }

    public int getGridSize() {
        return this.grid_size;
    }

    public void setGridSize(int grid_size) {
        this.grid_size = grid_size;
    }

    public boolean getRandom() {
        return this.random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }
}