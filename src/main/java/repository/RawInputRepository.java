package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import model.RawInput;

public interface RawInputRepository extends JpaRepository<RawInput,UUID> {

}
