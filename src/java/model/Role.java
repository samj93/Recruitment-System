
package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;


/**
 * The role class is an entity class 
 * representing a role
 * 
 */

@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "roleName")
    private String roleName;
    @JoinTable(name = "groups", joinColumns = {
        @JoinColumn(name = "groupname", referencedColumnName = "roleName")}, inverseJoinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")})
    @ManyToMany
    private Collection<Person> personCollection;

    /**
     * Constructor
     */
    public Role() {
        personCollection = new ArrayList<Person>();
    }

    /**
     *
     * @param roleName name of role
     */
    public Role(String roleName) {
        this.roleName = roleName;
    }

    /**
     *
     * @return name of role
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @param roleName name of role
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * adds the person from the input parameter
     * to the collection of persons
     * 
     * @param person 
     */
    public  void addPerson(Person person){
        personCollection.add(person);
        
    }

    /**
     *
     * @return list of persons
     */
    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    /**
     *
     * @param personCollection list of persons
     */
    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }


    
    /**
     * 
     * @return string containing rolename of object
     */
    @Override
    public String toString() {
        return "model.Role[ roleName=" + roleName + " ]";
    }
    
}
