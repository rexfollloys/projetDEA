package whoami;

public class Account implements java.io.Serializable{
    private int Account_id;
    private String pseudo;
    private String Account_password;
    private int age;
    private String genre;
    private int game_played;
    private int win_number;
    
    public Account(){}

    public Account(int Account_id, String pseudo, String Account_password, int age, String genre, int game_played, int win_number){
        this.Account_id = Account_id;
        this.pseudo = pseudo;
        this.Account_password = Account_password;
        this.age = age;
        this.genre = genre;
        this.game_played = game_played;
        this.win_number = win_number;
    }

    public String getAccountId(){
        return this.Account_id;
    }

    public void setAccountId(String Account_id){
        this.Account_id = Account_id;
    }

    public String getPseudo(){
        return this.pseudo;
    }
    
    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    public String getAccountpassword(){
        return this.Account_password;
    }

    public void setAccountpassword(String Account_password){
        this.Account_password = Account_password;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public int getNbPartiesJouees(){
        return this.game_played;
    }

    public void setNbPartiesJouees(int game_played){
        this.game_played = game_played;
    }

    public int getNbVictoires(){
        return this.win_number;
    }

    public void setNbVictoires(int win_number){
        this.win_number = win_number;
    }

    /*
        @Override
    public String toString() {
        return "["+idPersonne+"] nom: "+nom+ " "+adresse.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Personne)) {
            return false;
        }

        Personne p = (Personne) obj;

        return ((idPersonne == p.getIdPersonne()) && (nom.equals(p.nom)) && (adresse.equals(p.getAdresse())));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idPersonne;
        hash = 17 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 17 * hash + (this.adresse != null ? this.adresse.hashCode() : 0);
        return hash;
    }
    */
}