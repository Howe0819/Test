/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;
import entity.Event;
import entity.SystemUser;
import entity.Venue;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.VenueConflictException;

@Stateless
public class EventSession implements EventSessionLocal
{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List <Venue> getAllVenues()
    {
        Query query = entityManager.createQuery("SELECT v FROM Venue v");
        return query.getResultList();
    }
    
    private Venue getVenue(Long venueId)
    {
        Venue venue = entityManager.find(Venue.class, venueId);
        return venue;
    }
    private SystemUser getSystemUser(Long systemUserId)
    {
        SystemUser systemUser = entityManager.find(SystemUser.class,
systemUserId);
        return systemUser;
    }
    @Override
    public List <Event> getAllEvents()
    {
        Query query = entityManager.createQuery("SELECT e FROM Event e");
        return query.getResultList();
    }
    @Override
    public List <Event> getMyEvents(Long systemUserId)
    {
        SystemUser systemUser = getSystemUser(systemUserId);
        Query query = entityManager.createQuery("SELECT e FROM Event e WHERE e.systemUser = :inSytemUser");
        query.setParameter("inSytemUser", systemUser);
        return query.getResultList();
    }
    private Boolean checkVenueConflict(Timestamp startDateTime, Timestamp endDateTime, Long venueId)
    {
        Query query = entityManager.createQuery("SELECT e FROM Event e WHERE e.venue = :venue AND e.startDateTime <= :endDateTime AND e.endDateTime >=:startDateTime");
        query.setParameter("venue", getVenue(venueId));
        query.setParameter("startDateTime", startDateTime);
        query.setParameter("endDateTime", endDateTime);
        List resultList = query.getResultList();
        if(resultList.isEmpty())
        {   return false;
}else
        {
            return true;
        } 
    }
@Override
    public Long addNewEvent(String eventName, Timestamp startDateTime,
Timestamp endDateTime, Long venueId, Long systemUserId) throws
VenueConflictException
    {
        if(!checkVenueConflict(startDateTime, endDateTime, venueId))
        {
            SystemUser systemUser = getSystemUser(systemUserId);
            Event event = new Event();
            event.setEventName(eventName);
            event.setStartDateTime(startDateTime);
            event.setEndDateTime(endDateTime);
            event.setVenue(getVenue(venueId));
            event.setSystemUser(systemUser);
            event.setStatus("Pending");
            entityManager.persist(event);
            entityManager.flush();
            systemUser.getEvents().add(event);
            entityManager.merge(systemUser);
            return event.getEventId();
        }
        else
        {
            throw new VenueConflictException("Venue conflict: " + venueId);
        } 
    }
}
