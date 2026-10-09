package de.frank.eventbooking.controller;

import de.frank.eventbooking.dto.request.CreateEventRequest;
import de.frank.eventbooking.dto.response.EventResponse;
import de.frank.eventbooking.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private  final EventService eventService;

    public EventController (EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(
            @Valid @RequestBody CreateEventRequest request
            ){
        EventResponse response = eventService.createEvent(request);
        URI location = URI.create("/api/events/" + response.id());

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {

        List<EventResponse> events = eventService.getAllEvents();

        // Eine leere Liste ist ebenfalls eine erfolgreiche Antwort.
        return ResponseEntity.ok(events);
    }
}
