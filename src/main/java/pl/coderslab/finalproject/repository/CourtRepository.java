package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Court;

public interface CourtRepository extends JpaRepository<Court, Integer> {
}
