package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The CompetenceProfile class is an entity class 
 * representing a CompetenceProfile.
 * 
 */
@Entity
@Table(name = "competence_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenceProfile.findAll", query = "SELECT c FROM CompetenceProfile c"),
    @NamedQuery(name = "CompetenceProfile.findByCompetenceProfileId", query = "SELECT c FROM CompetenceProfile c WHERE c.competenceProfileId = :competenceProfileId"),
    @NamedQuery(name = "CompetenceProfile.findByYearsOfExperience", query = "SELECT c FROM CompetenceProfile c WHERE c.yearsOfExperience = :yearsOfExperience")})
public class CompetenceProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "competence_profile_id")
    private Long competenceProfileId;
    @Column(name = "years_of_experience")
    private Double yearsOfExperience;
    @JoinColumn(name = "user_name", referencedColumnName = "username")
    @ManyToOne
    private Person userName;
    @JoinColumn(name = "competence_id", referencedColumnName = "name")
    @ManyToOne
    private Competence competenceId;

    /**
     * Empty constructor
     */
    public CompetenceProfile() {
    }

    /**
     * 
     * @param competenceProfileId unigue Id of the competenceProfile
     */
    public CompetenceProfile(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    /**
     * 
     * @return unique ID of the competenceProfile
     */
    public Long getCompetenceProfileId() {
        return competenceProfileId;
    }

    /**
     * 
     * @param competenceProfileId unique ID of the competenceProfile
     */
    public void setCompetenceProfileId(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    /**
     * 
     * @return int describing the years of experience of user
     */
    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * 
     * @param yearsOfExperience int describing the years of experience of user
     */
    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * 
     * @return username of the owner of the competence profile
     */
    public Person getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName of the owner of the competence profile
     */
    public void setUserName(Person userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return unique id of the referenced competence
     */
    public Competence getCompetenceId() {
        return competenceId;
    }

    /**
     * 
     * @param competenceId unique id of the referenced competence
     */
    public void setCompetenceId(Competence competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * 
     * @return string containing Id of object
     */
    @Override
    public String toString() {
        return "model.CompetenceProfile[ competenceProfileId=" + competenceProfileId + " ]";
    }
    
}
