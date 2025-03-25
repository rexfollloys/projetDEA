/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whoami;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lmercader
 */
@Entity
@Table(name = "CHARACTER")
@NamedQueries({
    @NamedQuery(name = "Character.findAll", query = "SELECT c FROM Character c"),
    @NamedQuery(name = "Character.findByCharacterId", query = "SELECT c FROM Character c WHERE c.characterId = :characterId"),
    @NamedQuery(name = "Character.findByCharacterName", query = "SELECT c FROM Character c WHERE c.characterName = :characterName"),
    @NamedQuery(name = "Character.findByUrlImage", query = "SELECT c FROM Character c WHERE c.urlImage = :urlImage")})
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CHARACTER_ID")
    private BigDecimal characterId;
    @Basic(optional = false)
    @Column(name = "CHARACTER_NAME")
    private String characterName;
    @Basic(optional = false)
    @Column(name = "URL_IMAGE")
    private String urlImage;
    @JoinTable(name = "GRIDCHARACTER", joinColumns = {
        @JoinColumn(name = "CHARACTER_ID", referencedColumnName = "CHARACTER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "GRID_ID", referencedColumnName = "GRID_ID")})
    @ManyToMany
    private Collection<Grid> gridCollection;

    public Character() {
    }

    public Character(BigDecimal characterId) {
        this.characterId = characterId;
    }

    public Character(BigDecimal characterId, String characterName, String urlImage) {
        this.characterId = characterId;
        this.characterName = characterName;
        this.urlImage = urlImage;
    }

    public BigDecimal getCharacterId() {
        return characterId;
    }

    public void setCharacterId(BigDecimal characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Collection<Grid> getGridCollection() {
        return gridCollection;
    }

    public void setGridCollection(Collection<Grid> gridCollection) {
        this.gridCollection = gridCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (characterId != null ? characterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Character)) {
            return false;
        }
        Character other = (Character) object;
        if ((this.characterId == null && other.characterId != null) || (this.characterId != null && !this.characterId.equals(other.characterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "whoami.Character[ characterId=" + characterId + " ]";
    }
    
}
