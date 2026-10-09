package de.frank.eventbooking.service;

import de.frank.eventbooking.dto.request.CreateEventRequest;
import de.frank.eventbooking.dto.response.EventResponse;
import de.frank.eventbooking.entity.Event;
import de.frank.eventbooking.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    // Spring übergibt das benötigte Repository über den Konstruktor.
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public EventResponse createEvent(CreateEventRequest request) {

        // Der Event-Konstruktor setzt availableTickets auf capacity.
        Event event = new Event(
                request.title(),
                request.description(),
                request.location(),
                request.startsAt(),
                request.ticketPrice(),
                request.capacity()
        );

        Event savedEvent = eventRepository.save(event);

        return toResponse(savedEvent);
    }

    @Transactional(readOnly = true)
    public List<EventResponse> getAllEvents() {

        // Wandelt jedes geladene Event in ein Response-DTO um.
        return eventRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // Gemeinsame DTO-Umwandlung für das Anlegen und das Auflisten.
    private EventResponse toResponse(Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getLocation(),
                event.getStartsAt(),
                event.getTicketPrice(),
                event.getCapacity(),
                event.getAvailableTickets()
        );
    }

    
}