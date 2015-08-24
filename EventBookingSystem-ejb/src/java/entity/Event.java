/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Event implements Serializable
{
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventName;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    @ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    private Venue venue;
    @ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,optional=false)
    private SystemUser systemUser;
    private String status;
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public Timestamp getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }
    public Timestamp getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }
    public Venue getVenue() {
        return venue;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    public SystemUser getSystemUser() {
        return systemUser;
    }
    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
}
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the eventId fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId
!= null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "entity.Event[id=" + eventId + "]";
    }
}