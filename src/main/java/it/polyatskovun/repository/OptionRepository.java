package it.polyatskovun.repository;

import it.polyatskovun.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID>{
}
