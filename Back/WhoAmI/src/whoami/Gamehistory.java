/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whoami;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lmercader
 */
@Entity
@Table(name = "GAMEHISTORY")
@NamedQueries({
    @NamedQuery(name = "Gamehistory.findAll", query = "SELECT g FROM Gamehistory g"),
    @NamedQuery(name = "Gamehistory.findByGameId", query = "SELECT g FROM Gamehistory g WHERE g.gameId = :gameId"),
    @NamedQuery(name = "Gamehistory.findByPlayer1Score", query = "SELECT g FROM Gamehistory g WHERE g.player1Score = :player1Score"),
    @NamedQuery(name = "Gamehistory.findByPlayer2Score", query = "SELECT g FROM Gamehistory g WHERE g.player2Score = :player2Score"),
    @NamedQuery(name = "Gamehistory.findByWinnerId", query = "SELECT g FROM Gamehistory g WHERE g.winnerId = :winnerId")})
public class Gamehistory implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GAME_ID")
    private BigDecimal gameId;
    @Column(name = "PLAYER1_SCORE")
    private BigInteger player1Score;
    @Column(name = "PLAYER2_SCORE")
    private BigInteger player2Score;
    @Column(name = "WINNER_ID")
    private BigInteger winnerId;
    @JoinColumn(name = "PLAYER1_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account player1Id;
    @JoinColumn(name = "PLAYER2_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account player2Id;
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Game game;

    public Gamehistory() {
    }

    public Gamehistory(BigDecimal gameId) {
        this.gameId = gameId;
    }

    public BigDecimal getGameId() {
        return gameId;
    }

    public void setGameId(BigDecimal gameId) {
        this.gameId = gameId;
    }

    public BigInteger getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(BigInteger player1Score) {
        this.player1Score = player1Score;
    }

    public BigInteger getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(BigInteger player2Score) {
        this.player2Score = player2Score;
    }

    public BigInteger getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(BigInteger winnerId) {
        this.winnerId = winnerId;
    }

    public Account getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Account player1Id) {
        this.player1Id = player1Id;
    }

    public Account getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Account player2Id) {
        this.player2Id = player2Id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameId != null ? gameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gamehistory)) {
            return false;
        }
        Gamehistory other = (Gamehistory) object;
        if ((this.gameId == null && other.gameId != null) || (this.gameId != null && !this.gameId.equals(other.gameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "whoami.Gamehistory[ gameId=" + gameId + " ]";
    }
    
}
