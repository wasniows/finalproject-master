package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Authority;
import pl.coderslab.finalproject.entity.Reservation;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query(value = "SELECT * FROM authorities WHERE email = :email",
            nativeQuery = true)
    List<Authority> authoritiesByEmail(@Param("email") String email);
}
