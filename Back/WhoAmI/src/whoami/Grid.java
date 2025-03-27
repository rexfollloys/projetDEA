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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lmercader
 */
@Entity
@Table(name = "GRID")
@NamedQueries({
    @NamedQuery(name = "Grid.findAll", query = "SELECT g FROM Grid g"),
    @NamedQuery(name = "Grid.findByGridId", query = "SELECT g FROM Grid g WHERE g.gridId = :gridId"),
    @NamedQuery(name = "Grid.findByGridName", query = "SELECT g FROM Grid g WHERE g.gridName = :gridName"),
    @NamedQuery(name = "Grid.findByGridSize", query = "SELECT g FROM Grid g WHERE g.gridSize = :gridSize"),
    @NamedQuery(name = "Grid.findByRandom", query = "SELECT g FROM Grid g WHERE g.random = :random")})
public class Grid implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GRID_ID")
    private BigDecimal gridId;
    @Basic(optional = false)
    @Column(name = "GRID_NAME")
    private String gridName;
    @Basic(optional = false)
    @Column(name = "GRID_SIZE")
    private BigInteger gridSize;
    @Column(name = "RANDOM")
    private Short random;
    @ManyToMany(mappedBy = "gridCollection")
    private Collection<Character> characterCollection;
    @OneToMany(mappedBy = "gridId")
    private Collection<Game> gameCollection;

    public Grid() {
    }

    public Grid(BigDecimal gridId) {
        this.gridId = gridId;
    }

    public Grid(BigDecimal gridId, String gridName, BigInteger gridSize) {
        this.gridId = gridId;
        this.gridName = gridName;
        this.gridSize = gridSize;
    }

    public BigDecimal getGridId() {
        return gridId;
    }

    public void setGridId(BigDecimal gridId) {
        this.gridId = gridId;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public BigInteger getGridSize() {
        return gridSize;
    }

    public void setGridSize(BigInteger gridSize) {
        this.gridSize = gridSize;
    }

    public Short getRandom() {
        return random;
    }

    public void setRandom(Short random) {
        this.random = random;
    }

    public Collection<Character> getCharacterCollection() {
        return characterCollection;
    }

    public void setCharacterCollection(Collection<Character> characterCollection) {
        this.characterCollection = characterCollection;
    }

    public Collection<Game> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(Collection<Game> gameCollection) {
        this.gameCollection = gameCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gridId != null ? gridId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grid)) {
            return false;
        }
        Grid other = (Grid) object;
        if ((this.gridId == null && other.gridId != null) || (this.gridId != null && !this.gridId.equals(other.gridId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "whoami.Grid[ gridId=" + gridId + " ]";
    }
    
}
