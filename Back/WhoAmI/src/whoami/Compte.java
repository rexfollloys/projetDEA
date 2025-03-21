package whoami;

public class Compte implements java.io.Serializable{
    private int compte_id;
    private String pseudo;
    private String compte_mdp;
    private int age;
    private String genre;
    private int nb_parties_jouees;
    private int nb_victoires;
    
    public Compte(){}

    public Compte(int compte_id, String pseudo, String compte_mdp, int age, String genre, int nb_parties_jouees, int nb_victoires){
        this.compte_id = compte_id;
        this.pseudo = pseudo;
        this.compte_mdp = compte_mdp;
        this.age = age;
        this.genre = genre;
        this.nb_parties_jouees = nb_parties_jouees;
        this.nb_victoires = nb_victoires;
    }

    public String getCompteId(){
        return this.compte_id;
    }

    public void setCompteId(String compte_id){
        this.compte_id = compte_id;
    }

    public String getPseudo(){
        return this.pseudo;
    }
    
    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    public String getCompteMdp(){
        return this.compte_mdp;
    }

    public void setCompteMdp(String compte_mdp){
        this.compte_mdp = compte_mdp;
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
        return this.nb_parties_jouees;
    }

    public void setNbPartiesJouees(int nb_parties_jouees){
        this.nb_parties_jouees = nb_parties_jouees;
    }

    public int getNbVictoires(){
        return this.nb_victoires;
    }

    public void setNbVictoires(int nb_victoires){
        this.nb_victoires = nb_victoires;
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