package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.entity.Account;

public interface AccountService {

    Account create(Account account);

    void createVerificationToken(Account account, String token);

    void confirmAccount(String token);

}
