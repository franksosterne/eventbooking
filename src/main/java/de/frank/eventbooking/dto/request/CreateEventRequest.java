package de.frank.eventbooking.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEventRequest(
        @NotBlank(message = "Der Titel darf nicht leer sein.")
        @Size(max = 150, message = "Der Titel darf höchstens 150 Zeichen enthalten.")
        String title,

        @NotBlank(message = "Die Beschreibung darf nicht leer sein.")
        @Size(max = 3000, message = "Die Beschreibung darf höchstens 3000 Zeichen enthalten.")
        String description,

        @NotBlank(message = "Der Veranstaltungsort darf nicht leer sein.")
        @Size(max = 200, message = "Der Veranstaltungsort darf höchstens 200 Zeichen enthalten.")
        String location,

        @NotNull(message = "Der Veranstaltungsbeginn muss angegeben werden.")
        @Future(message = "Der Veranstaltungsbeginn muss in der Zukunft liegen.")
        LocalDateTime startsAt,

        @NotNull(message = "Der Ticketpreis muss angegeben werden.")
        @DecimalMin(value = "0.00", message = "Der Ticketpreis darf nicht negativ sein.")
        @Digits(integer = 8, fraction = 2,
                message = "Der Ticketpreis darf höchstens acht Vorkommastellen und zwei Nachkommastellen haben.")
        BigDecimal ticketPrice,

        @NotNull(message = "Die Kapazität muss angegeben werden.")
        @Positive(message = "Die Kapazität muss größer als null sein.")
        Integer capacity
) {
}
