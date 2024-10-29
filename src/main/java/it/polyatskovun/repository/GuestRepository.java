package it.polyatskovun.repository;

import it.polyatskovun.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuestRepository extends JpaRepository<GuestEntity, UUID>{
}
