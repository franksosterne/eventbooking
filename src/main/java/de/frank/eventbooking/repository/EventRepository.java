package de.frank.eventbooking.repository;
import de.frank.eventbooking.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event,Long> {

}
