package de.frank.eventbooking.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 3000)
    private String description;

    @Column(nullable = false, length = 200)
    private String location;

    @Column(nullable = false)
    private LocalDateTime startsAt;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal ticketPrice;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int availableTickets;



    //gespeicherte Events aus der Datenbank zu laden.
    protected Event() {
    }

    // Erstellt ein neues Event. Zu Beginn sind alle Tickets verfügbar.
    public Event(
            String title,
            String description,
            String location,
            LocalDateTime startsAt,
            BigDecimal ticketPrice,
            int capacity
    ) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startsAt = startsAt;
        this.ticketPrice = ticketPrice;
        this.capacity = capacity;
        this.availableTickets = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

}
