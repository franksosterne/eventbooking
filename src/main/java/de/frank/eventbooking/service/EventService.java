package de.frank.eventbooking.service;

import de.frank.eventbooking.dto.request.CreateEventRequest;
import de.frank.eventbooking.dto.response.EventResponse;
import de.frank.eventbooking.entity.Event;
import de.frank.eventbooking.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    // Spring stellt das benötigte Repository bereit.
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public EventResponse createEvent(CreateEventRequest request) {

        Event event = new Event(
                request.title(),
                request.description(),
                request.location(),
                request.startsAt(),
                request.ticketPrice(),
                request.capacity()
        );

        Event savedEvent = eventRepository.save(event);

        return new EventResponse(
                savedEvent.getId(),
                savedEvent.getTitle(),
                savedEvent.getDescription(),
                savedEvent.getLocation(),
                savedEvent.getStartsAt(),
                savedEvent.getTicketPrice(),
                savedEvent.getCapacity(),
                savedEvent.getAvailableTickets()
        );
    }
}