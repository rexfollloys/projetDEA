/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whoami;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lmercader
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByAge", query = "SELECT a FROM Account a WHERE a.age = :age"),
    @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender"),
    @NamedQuery(name = "Account.findByGamePlayed", query = "SELECT a FROM Account a WHERE a.gamePlayed = :gamePlayed"),
    @NamedQuery(name = "Account.findByVictories", query = "SELECT a FROM Account a WHERE a.victories = :victories")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ACCOUNT_ID")
    private BigDecimal accountId;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "AGE")
    private BigInteger age;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "GAME_PLAYED")
    private BigInteger gamePlayed;
    @Column(name = "VICTORIES")
    private BigInteger victories;
    @OneToMany(mappedBy = "guestId")
    private Collection<Game> gameCollection;
    @OneToMany(mappedBy = "hostId")
    private Collection<Game> gameCollection1;
    @OneToMany(mappedBy = "winnerId")
    private Collection<Round> roundCollection;
    @OneToMany(mappedBy = "player1Id")
    private Collection<Gamehistory> gamehistoryCollection;
    @OneToMany(mappedBy = "player2Id")
    private Collection<Gamehistory> gamehistoryCollection1;

    public Account() {
    }

    public Account(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public Account(BigDecimal accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }

    public BigDecimal getAccountId() {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(BigInteger gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    public BigInteger getVictories() {
        return victories;
    }

    public void setVictories(BigInteger victories) {
        this.victories = victories;
    }

    public Collection<Game> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(Collection<Game> gameCollection) {
        this.gameCollection = gameCollection;
    }

    public Collection<Game> getGameCollection1() {
        return gameCollection1;
    }

    public void setGameCollection1(Collection<Game> gameCollection1) {
        this.gameCollection1 = gameCollection1;
    }

    public Collection<Round> getRoundCollection() {
        return roundCollection;
    }

    public void setRoundCollection(Collection<Round> roundCollection) {
        this.roundCollection = roundCollection;
    }

    public Collection<Gamehistory> getGamehistoryCollection() {
        return gamehistoryCollection;
    }

    public void setGamehistoryCollection(Collection<Gamehistory> gamehistoryCollection) {
        this.gamehistoryCollection = gamehistoryCollection;
    }

    public Collection<Gamehistory> getGamehistoryCollection1() {
        return gamehistoryCollection1;
    }

    public void setGamehistoryCollection1(Collection<Gamehistory> gamehistoryCollection1) {
        this.gamehistoryCollection1 = gamehistoryCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "whoami.Account[ accountId=" + accountId + " ]";
    }
    
}
