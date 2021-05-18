package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Hour;

public interface HourRepository extends JpaRepository<Hour, Integer> {
}
