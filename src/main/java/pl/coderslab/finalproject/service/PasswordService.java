package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.Password;
import pl.coderslab.finalproject.entity.ResetToken;

public interface PasswordService {

    void createResetToken(Password password, String token);

    void update(Password password);

}
