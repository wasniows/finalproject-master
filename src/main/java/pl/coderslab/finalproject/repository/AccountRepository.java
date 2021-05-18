package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findFirstByEmail(String email);
}
