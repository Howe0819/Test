/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;
import entity.Event;
import entity.Venue;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Local;
import util.exception.VenueConflictException;

@Local
public interface EventSessionLocal
{
    public List<Venue> getAllVenues();
    public List<Event> getAllEvents();
    public List <Event> getMyEvents(Long systemUserId);
    public Long addNewEvent(String eventName, Timestamp startDateTime, Timestamp endDateTime, Long venueId, Long systemUserId) throws
VenueConflictException;
}
