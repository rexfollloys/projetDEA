-- Création de la BDD
CREATE DATABASE quiestce;

-- Utilisation de la BDD
USE quiestce;

-- Création de la table Compte
CREATE TABLE Compte (
    compte_id INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(30) NOT NULL,
    compte_mdp VARCHAR(20) NOT NULL,
    age INT,
    genre VARCHAR(10),
    nb_parties_jouees INT DEFAULT 0,
    nb_victoires INT DEFAULT 0
);

-- Création de la table Grille
CREATE TABLE Grille (
    grille_id INT AUTO_INCREMENT PRIMARY KEY,
    grille_nom VARCHAR(30) NOT NULL,
    grille_taille INT NOT NULL,
    random BOOLEAN NOT NULL
);

-- Création de la table Partie
CREATE TABLE Partie (
    partie_id INT AUTO_INCREMENT PRIMARY KEY,
    partie_mdp VARCHAR(20) NOT NULL,
    createur_id INT,
    adversaire_id INT,
    nb_manches INT,
    limite_nombre_tours INT,
    grille_id INT,
    spectateur BOOLEAN,
    partie_date DATETIME,
    CONSTRAINT fk_Partie_createur FOREIGN KEY (createur_id) REFERENCES Compte(compte_id),
    CONSTRAINT fk_Partie_adversaire FOREIGN KEY (adversaire_id) REFERENCES Compte(compte_id),
    CONSTRAINT fk_Partie_grille FOREIGN KEY (grille_id) REFERENCES Grille(grille_id)
);

-- Création de la table HistoriquePartie
CREATE TABLE HistoriquePartie (
    partie_id INT,
    joueur1_id INT,
    joueur2_id INT,
    joueur1_score INT,
    joueur2_score INT,
    gagnant INT,
    CONSTRAINT fk_HistoriquePartie_partie FOREIGN KEY (partie_id) REFERENCES Partie(partie_id),
    CONSTRAINT fk_HistoriquePartie_joueur1 FOREIGN KEY (joueur1_id) REFERENCES Compte(compte_id),
    CONSTRAINT fk_HistoriquePartie_joueur2 FOREIGN KEY (joueur2_id) REFERENCES Compte(compte_id)
);

-- Création de la table Manches
CREATE TABLE Manches (
    manche_id INT AUTO_INCREMENT PRIMARY KEY,
    partie_id INT,
    num_manche INT,
    gagnant_id INT,
    CONSTRAINT fk_Manches_partie FOREIGN KEY (partie_id) REFERENCES Partie(partie_id),
    CONSTRAINT fk_Manches_gagnant FOREIGN KEY (gagnant_id) REFERENCES Compte(compte_id)
);

-- Création de la table Personnage
CREATE TABLE Personnage (
    personnage_id INT AUTO_INCREMENT PRIMARY KEY,
    personnage_nom VARCHAR(10) NOT NULL,
    url_image VARCHAR(50) NOT NULL
);
