package de.frank.eventbooking.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String title,
        String description,
        String location,
        LocalDateTime startsAt,
        BigDecimal ticketPrice,
        int capacity,
        int availableTickets
) {
}
