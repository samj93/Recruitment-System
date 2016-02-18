package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Competence class is an entity class 
 * representing a Competence option.
 * 
 */

@Entity
@Table(name = "competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
    @NamedQuery(name = "Competence.findByName", query = "SELECT c FROM Competence c WHERE c.name = :name"),
    @NamedQuery(name = "Competence.findByCompetenceId", query = "SELECT c FROM Competence c WHERE c.competenceId = :competenceId")})
public class Competence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "competence_id")
    private long competenceId;
    @OneToMany(mappedBy = "competenceName")
    private Collection<CompetenceProfile> competenceProfileCollection;

    /**
     * Empty constructor
     */
    public Competence() {
    }

    /**
     * 
     * @param name of the competence.
     */
    public Competence(String name) {
        this.name = name;
    }

    /**
     * 
     * @param name of the competence
     * @param competenceId unique id of the competence
     */
    public Competence(String name, long competenceId) {
        this.name = name;
        this.competenceId = competenceId;
    }

    /**
     * 
     * @return name of the competence object
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name of the competence object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return the ID of the competence object
     */
    public long getCompetenceId() {
        return competenceId;
    }

    /**
     * 
     * @param competenceId the ID of the competence object
     */
    public void setCompetenceId(long competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * 
     * @return list of competenceProfiles
     */
    @XmlTransient
    public Collection<CompetenceProfile> getCompetenceProfileCollection() {
        return competenceProfileCollection;
    }

    /**
     * 
     * @param competenceProfileCollection list of competenceProfiles
     */
    public void setCompetenceProfileCollection(Collection<CompetenceProfile> competenceProfileCollection) {
        this.competenceProfileCollection = competenceProfileCollection;
    }


    /**
     * 
     * @return string containing name of object
     */
    @Override
    public String toString() {
        return "model.Competence[ name=" + name + " ]";
    }
    
}
