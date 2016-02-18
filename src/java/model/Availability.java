
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * the Availability class is an entity class 
 * representing the availability of a registered user
 * 
 */
@Entity
@Table(name = "availability")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a"),
    @NamedQuery(name = "Availability.findByAvailabilityId", query = "SELECT a FROM Availability a WHERE a.availabilityId = :availabilityId"),
    @NamedQuery(name = "Availability.findByFromDate", query = "SELECT a FROM Availability a WHERE a.fromDate = :fromDate"),
    @NamedQuery(name = "Availability.findByToDate", query = "SELECT a FROM Availability a WHERE a.toDate = :toDate")})
public class Availability implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "availability_id")
    private Long availabilityId;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Person username;

    /**
     * empty constructor 
     */
    public Availability() {
    }

    /**
     * 
     * @param availabilityId  
     */
    public Availability(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    /**
     * @return the availability id of the object
     */
    public Long getAvailabilityId() {
        return availabilityId;
    }

    /**
     * @param availabilityId unique id of the object
     */
    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    /**
     * @return the beginning date of the availability period
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the beginning date of the availability period
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the ending date of the availability period
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * @param toDate ending date of the availability period
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     * @return the person the availability object belongs to
     */
    public Person getUsername() {
        return username;
    }

    /**
     * @param username the username of the person the object belongs to
     */
    public void setUsername(Person username) {
        this.username = username;
    }


    /**
     * 
     * @return a string containing this objects ID
     */
    @Override
    public String toString() {
        return "model.Availability[ availabilityId=" + availabilityId + " ]";
    }
    
}
