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
import javax.persistence.Table;

/**
 *
 * @author lmercader
 */
@Entity
@Table(name = "ROUND")
@NamedQueries({
    @NamedQuery(name = "Round.findAll", query = "SELECT r FROM Round r"),
    @NamedQuery(name = "Round.findByRoundId", query = "SELECT r FROM Round r WHERE r.roundId = :roundId"),
    @NamedQuery(name = "Round.findByRoundNumber", query = "SELECT r FROM Round r WHERE r.roundNumber = :roundNumber")})
public class Round implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ROUND_ID")
    private BigDecimal roundId;
    @Column(name = "ROUND_NUMBER")
    private BigInteger roundNumber;
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account winnerId;
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID")
    @ManyToOne
    private Game gameId;

    public Round() {
    }

    public Round(BigDecimal roundId) {
        this.roundId = roundId;
    }

    public BigDecimal getRoundId() {
        return roundId;
    }

    public void setRoundId(BigDecimal roundId) {
        this.roundId = roundId;
    }

    public BigInteger getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(BigInteger roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Account getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Account winnerId) {
        this.winnerId = winnerId;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roundId != null ? roundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Round)) {
            return false;
        }
        Round other = (Round) object;
        if ((this.roundId == null && other.roundId != null) || (this.roundId != null && !this.roundId.equals(other.roundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "whoami.Round[ roundId=" + roundId + " ]";
    }
    
}
