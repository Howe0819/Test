/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Venue implements Serializable
{
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;
    private String venueName;
    private String venueLocation;
    public Long getVenueId() {
        return venueId;
    }
    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
    public String getVenueName() {
        return venueName;
    }
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    public String getVenueLocation() {
        return venueLocation;
    }
    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venueId != null ? venueId.hashCode() : 0);
        return hash;
}
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the venueId fields are not set
        if (!(object instanceof Venue)) {
           return false;
        }
        Venue other = (Venue) object;
        if ((this.venueId == null && other.venueId != null) || (this.venueId
!= null && !this.venueId.equals(other.venueId))) {
           return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "entity.Venue[id=" + venueId + "]";
    }
}
