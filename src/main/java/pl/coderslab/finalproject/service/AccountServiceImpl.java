package pl.coderslab.finalproject.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.entity.Account;
import pl.coderslab.finalproject.entity.Authority;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.entity.VerificationToken;
import pl.coderslab.finalproject.repository.AccountRepository;
import pl.coderslab.finalproject.repository.AuthorityRepository;
import pl.coderslab.finalproject.repository.UserRepository;
import pl.coderslab.finalproject.repository.VerificationTokenRepository;

@Data
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void createVerificationToken(Account account, String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setEmail(account.getEmail());
        verificationToken.setExpiryDate(verificationToken.calculateExpiryDate(verificationToken.EXPIRATION));
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public void confirmAccount(String token) {

        //retrieve token
        VerificationToken verificationToken = verificationTokenRepository.findFirstByToken(token);

        //move from account table to user table
        Account account = accountRepository.findFirstByEmail(verificationToken.getEmail());

        //create user
        Authority authority = new Authority(account.getEmail(), "ROLE_USER");
        authorityRepository.save(authority);

        User user =
                new User(account.getEmail(), account.getFirstName(), account.getLastName(), account.getPhone(),
                        account.getAddress(), account.getPassword(), true, true);
        userRepository.save(user);

        //delete from accounts
        accountRepository.delete(account);

        //delete from tokens
        verificationTokenRepository.delete(verificationToken);
    }
}
