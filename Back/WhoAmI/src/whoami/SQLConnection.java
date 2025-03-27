/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whoami;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lmercader
 */
public class SQLConnection {
    private Connection conn;
    public void connexionSGBD() {
        try {
            // enregistrement du driver spécifique à mySQL
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
       
            conn = DriverManager.getConnection( "jdbc:oracle:thin:@scinfe098:1521:etud", "lmercader", "lmercader");
        } catch (SQLException ex) {
            System.err.println("Problème de connexion :" + ex) ;
        }
    }
    
    public void ajouterAccount(Account account) throws SQLException {
        Statement req = conn.createStatement();
        // insertion du nouveau sport
        PreparedStatement reqParam = conn.prepareStatement(" INSERT INTO ACCOUNT VALUES (?,?,?,?,?,?,?)");
        reqParam.setString(1, account.getAccountId().toString());
        reqParam.setString(2, account.getUsername());
        reqParam.setString(3, account.getAccountPassword());
        reqParam.setString(4, account.getAge().toString());
        reqParam.setString(5, account.getGender());
        reqParam.setString(6, account.getGamePlayed().toString());
        reqParam.setString(7, account.getVictories().toString());
        int nb = reqParam.executeUpdate();
        System.out.println(" Nb de Account insérées : " + nb);
    }
    
    public void ajouterCharacter(Character character) throws SQLException {
        Statement req = conn.createStatement();
        // insertion du nouveau sport
        PreparedStatement reqParam = conn.prepareStatement(" INSERT INTO CHARACTER VALUES (?,?,?)");
        reqParam.setString(1, character.getCharacterId().toString());
        reqParam.setString(2, character.getCharacterName());
        reqParam.setString(3, character.getUrlImage());
        int nb = reqParam.executeUpdate();
        System.out.println(" Nb de Characters insérées : " + nb);
    }
    
    public void ajouterGame(Game game) throws SQLException {
        Statement req = conn.createStatement();
        // insertion du nouveau sport
        PreparedStatement reqParam = conn.prepareStatement(" INSERT INTO CHARACTER VALUES (?,?,?,?,?,?,?,?,?)");
        reqParam.setString(1, game.getGameId().toString());
        reqParam.setString(2, game.getGamePassword());
        reqParam.setString(3, game.getHostId().getAccountId().toString());
        reqParam.setString(4, game.getGuestId().getAccountId().toString());
        reqParam.setString(5, game.getNumberOfRounds().toString());
        reqParam.setString(6, game.getTurnLimit().toString());
        reqParam.setString(7, game.getGridId().getGridId().toString());
        reqParam.setString(8, game.getSpectator().toString());
        reqParam.setString(9, game.getGameDate().toString());
        int nb = reqParam.executeUpdate();
        System.out.println(" Nb de Game insérées : " + nb);
    }

    public void ajouterGamehistory(Gamehistory gamehistory) throws SQLException {
        Statement req = conn.createStatement();
        // insertion du nouveau sport
        PreparedStatement reqParam = conn.prepareStatement(" INSERT INTO CHARACTER VALUES (?,?,?,?,?,?,?,?,?)");
        reqParam.setString(1, gamehistory.getGameId().toString());
        reqParam.setString(2, gamehistory.getPlayer1Id().getAccountId().toString());
        reqParam.setString(3, gamehistory.getPlayer2Id().getAccountId().toString());
        reqParam.setString(4, gamehistory.getPlayer1Score().toString());
        reqParam.setString(5, gamehistory.getPlayer2Score().toString());
        reqParam.setString(6, gamehistory.getWinnerId().toString());
        int nb = reqParam.executeUpdate();
        System.out.println(" Nb de Gamehistory insérées : " + nb);
    }
    
    public void ajouterGrid(Grid grid) throws SQLException {
        Statement req = conn.createStatement();
        // insertion du nouveau sport
        PreparedStatement reqParam = conn.prepareStatement(" INSERT INTO CHARACTER VALUES (?,?,?,?,?,?,?,?,?)");
        reqParam.setString(1, grid.getGridId().toString());
        reqParam.setString(2, grid.getGridName());
        reqParam.setString(3, grid.getGridSize().toString());
        reqParam.setString(4, grid.getRandom().toString());
        int nb = reqParam.executeUpdate();
        System.out.println(" Nb de Grid insérées : " + nb);
    }

    public void ajouterRound(Round round) throws SQLException {
        Statement req = conn.createStatement();
        // insertion du nouveau sport
        PreparedStatement reqParam = conn.prepareStatement(" INSERT INTO CHARACTER VALUES (?,?,?,?,?,?,?,?,?)");
        reqParam.setString(1, round.getRoundId().toString());
        reqParam.setString(2, round.getGameId().getGameId().toString());
        reqParam.setString(3, round.getRoundNumber().toString());
        reqParam.setString(4, round.getWinnerId().getAccountId().toString());
        int nb = reqParam.executeUpdate();
        System.out.println(" Nb de Round insérées : " + nb);
    }
    
    public void supprimerAccount(String accountId) throws SQLException {
        PreparedStatement reqParam = conn.prepareStatement("DELETE FROM ACCOUNT WHERE accountId = ?");
        reqParam.setString(1, accountId);
        int nb = reqParam.executeUpdate();
        System.out.println("Nombre de comptes supprimés : " + nb);
    }

    public void supprimerCharacter(String characterId) throws SQLException {
        PreparedStatement reqParam = conn.prepareStatement("DELETE FROM CHARACTER WHERE characterId = ?");
        reqParam.setString(1, characterId);
        int nb = reqParam.executeUpdate();
        System.out.println("Nombre de personnages supprimés : " + nb);
    }

    public void supprimerGame(String gameId) throws SQLException {
        PreparedStatement reqParam = conn.prepareStatement("DELETE FROM GAME WHERE gameId = ?");
        reqParam.setString(1, gameId);
        int nb = reqParam.executeUpdate();
        System.out.println("Nombre de jeux suSpprimés : " + nb);
    }

    public void supprimerGamehistory(String gameId) throws SQLException {
        PreparedStatement reqParam = conn.prepareStatement("DELETE FROM GAMEHISTORY WHERE gameId = ?");
        reqParam.setString(1, gameId);
        int nb = reqParam.executeUpdate();
        System.out.println("Nombre d'historiques de jeux supprimés : " + nb);
    }

    public void supprimerGrid(String gridId) throws SQLException {
        PreparedStatement reqParam = conn.prepareStatement("DELETE FROM GRID WHERE gridId = ?");
        reqParam.setString(1, gridId);
        int nb = reqParam.executeUpdate();
        System.out.println("Nombre de grilles supprimées : " + nb);
    }

    public void supprimerRound(String roundId) throws SQLException {
        PreparedStatement reqParam = conn.prepareStatement("DELETE FROM ROUND WHERE roundId = ?");
        reqParam.setString(1, roundId);
        int nb = reqParam.executeUpdate();
        System.out.println("Nombre de rounds supprimés : " + nb);
    }

}