package it.polyatskovun.repository;

import it.polyatskovun.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OptionRepository extends JpaRepository<OptionEntity, UUID>{
}
