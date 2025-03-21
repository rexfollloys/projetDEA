package whoami;

public class Account implements java.io.Serializable{
    private int account_id;
    private String username;
    private String account_password;
    private int age;
    private String gender;
    private int game_played;
    private int victories;
    
    public Account(){}

    public Account(int account_id, String username, String account_password, int age, String gender, int game_played, int victories){
        this.account_id = account_id;
        this.username = username;
        this.account_password = account_password;
        this.age = age;
        this.gender = gender;
        this.game_played = game_played;
        this.victories = victories;
    }

    public String getAccountId(){
        return this.account_id;
    }

    public void setAccountId(String account_id){
        this.account_id = account_id;
    }

    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = pseudo;
    }

    public String getAccountpassword(){
        return this.account_password;
    }

    public void setAccountpassword(String account_password){
        this.account_password = account_password;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public int getNbPartiesJouees(){
        return this.game_played;
    }

    public void setNbPartiesJouees(int game_played){
        this.game_played = game_played;
    }

    public int getNbVictoires(){
        return this.victories;
    }

    public void setNbVictoires(int victories){
        this.victories = victories;
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