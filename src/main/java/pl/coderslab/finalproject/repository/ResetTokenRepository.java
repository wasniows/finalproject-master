package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.ResetToken;

@Repository
public interface ResetTokenRepository extends JpaRepository<ResetToken, String> {

    ResetToken findFirstByToken(String token);
}
