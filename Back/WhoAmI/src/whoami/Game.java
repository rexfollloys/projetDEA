/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whoami;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lmercader
 */
@Entity
@Table(name = "GAME")
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByGameId", query = "SELECT g FROM Game g WHERE g.gameId = :gameId"),
    @NamedQuery(name = "Game.findByGamePassword", query = "SELECT g FROM Game g WHERE g.gamePassword = :gamePassword"),
    @NamedQuery(name = "Game.findByNumberOfRounds", query = "SELECT g FROM Game g WHERE g.numberOfRounds = :numberOfRounds"),
    @NamedQuery(name = "Game.findByTurnLimit", query = "SELECT g FROM Game g WHERE g.turnLimit = :turnLimit"),
    @NamedQuery(name = "Game.findBySpectator", query = "SELECT g FROM Game g WHERE g.spectator = :spectator"),
    @NamedQuery(name = "Game.findByGameDate", query = "SELECT g FROM Game g WHERE g.gameDate = :gameDate")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GAME_ID")
    private BigDecimal gameId;
    @Basic(optional = false)
    @Column(name = "GAME_PASSWORD")
    private String gamePassword;
    @Column(name = "NUMBER_OF_ROUNDS")
    private BigInteger numberOfRounds;
    @Column(name = "TURN_LIMIT")
    private BigInteger turnLimit;
    @Column(name = "SPECTATOR")
    private Short spectator;
    @Column(name = "GAME_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gameDate;
    @JoinColumn(name = "HOST_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account hostId;
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Account guestId;
    @JoinColumn(name = "GRID_ID", referencedColumnName = "GRID_ID")
    @ManyToOne
    private Grid gridId;
    @OneToMany(mappedBy = "gameId")
    private Collection<Round> roundCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game")
    private Gamehistory gamehistory;

    public Game() {
    }

    public Game(BigDecimal gameId) {
        this.gameId = gameId;
    }

    public Game(BigDecimal gameId, String gamePassword) {
        this.gameId = gameId;
        this.gamePassword = gamePassword;
    }

    public BigDecimal getGameId() {
        return gameId;
    }

    public void setGameId(BigDecimal gameId) {
        this.gameId = gameId;
    }

    public String getGamePassword() {
        return gamePassword;
    }

    public void setGamePassword(String gamePassword) {
        this.gamePassword = gamePassword;
    }

    public BigInteger getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(BigInteger numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public BigInteger getTurnLimit() {
        return turnLimit;
    }

    public void setTurnLimit(BigInteger turnLimit) {
        this.turnLimit = turnLimit;
    }

    public Short getSpectator() {
        return spectator;
    }

    public void setSpectator(Short spectator) {
        this.spectator = spectator;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Account getHostId() {
        return hostId;
    }

    public void setHostId(Account hostId) {
        this.hostId = hostId;
    }

    public Account getGuestId() {
        return guestId;
    }

    public void setGuestId(Account guestId) {
        this.guestId = guestId;
    }

    public Grid getGridId() {
        return gridId;
    }

    public void setGridId(Grid gridId) {
        this.gridId = gridId;
    }

    public Collection<Round> getRoundCollection() {
        return roundCollection;
    }

    public void setRoundCollection(Collection<Round> roundCollection) {
        this.roundCollection = roundCollection;
    }

    public Gamehistory getGamehistory() {
        return gamehistory;
    }

    public void setGamehistory(Gamehistory gamehistory) {
        this.gamehistory = gamehistory;
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
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.gameId == null && other.gameId != null) || (this.gameId != null && !this.gameId.equals(other.gameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "whoami.Game[ gameId=" + gameId + " ]";
    }
    
}
