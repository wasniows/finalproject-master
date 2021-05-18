package pl.coderslab.finalproject.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.Password;
import pl.coderslab.finalproject.entity.ResetToken;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.repository.ResetTokenRepository;
import pl.coderslab.finalproject.repository.UserRepository;

@Data
@Service
public class PasswordServiceImpl implements PasswordService {

    private final ResetTokenRepository resetTokenRepository;
    private final UserRepository userRepository;


    @Override
    public void createResetToken(Password password, String token) {

        ResetToken resetToken = new ResetToken();
        resetToken.setToken(token);
        resetToken.setEmail(password.getEmail());
        resetToken.setExpiryDate(resetToken.calculateExpiryDate(resetToken.EXPIRATION));
        resetTokenRepository.save(resetToken);
    }

    @Override
    public void update(Password password) {
        User user = userRepository.findFirstByEmail(password.getEmail());
        user.setPassword(password.getPassword());
        userRepository.save(user);

    }
}
