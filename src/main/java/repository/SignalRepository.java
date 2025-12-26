package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Signal;

public interface SignalRepository extends JpaRepository<Signal, UUID> {
    
}
