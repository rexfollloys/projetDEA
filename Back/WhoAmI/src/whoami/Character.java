package whoami;

public class Character implements java.io.Serializable{
    private int character_id;
    private String character_name;
    private String url_image;

    public Character() {
    }

    public Character(int character_id, String character_name, String url_image) {
        this.character_id = character_id;
        this.character_name = character_name;
        this.url_image = url_image;
    }

    public int getCharacterId() {
        return this.character_id;
    }
    
    public void setCharacterId(int character_id) {
        this.character_id = character_id;
    }

    public String getCharacterName() {
        return this.character_name;
    }

    public void setCharacterName(String character_name) {
        this.character_name = character_name;
    }

    public String getUrlImage() {
        return this.url_image;
    }

    public void setUrlImage(String url_image) {
        this.url_image = url_image;
    }
}