/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class SystemUser implements Serializable
{
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemUserId;
    private String userName;
    private String password;
@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="systemUser")private List<Event> events = new ArrayList<Event>();
    public Long getSystemUserId() {
        return systemUserId;
    }
    public void setSystemUserId(Long systemUserId) {
        this.systemUserId = systemUserId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
            this.events = events;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemUserId != null ? systemUserId.hashCode() : 0);
        return hash;
}
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the systemUserId fields are not set
        if (!(object instanceof SystemUser)) {
            return false;
        }
        SystemUser other = (SystemUser) object;
        if ((this.systemUserId == null && other.systemUserId != null) ||
(this.systemUserId != null && !this.systemUserId.equals(other.systemUserId)))
{
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "entity.SystemUser[id=" + systemUserId + "]";
    }
}
