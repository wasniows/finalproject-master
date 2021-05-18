package pl.coderslab.finalproject.controller;

import lombok.Data;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.finalproject.model.Password;
import pl.coderslab.finalproject.entity.ResetToken;
import pl.coderslab.finalproject.repository.ResetTokenRepository;
import pl.coderslab.finalproject.repository.UserRepository;
import pl.coderslab.finalproject.service.PasswordService;
import pl.coderslab.finalproject.util.OnPasswordResetEvent;

import javax.validation.Valid;
import java.util.Date;

@Data
@Controller
public class PasswordController {

    private final ApplicationEventPublisher eventPublisher;
    private final ResetTokenRepository resetTokenRepository;
    private final PasswordEncoder encoder;
    private final PasswordService passwordService;
    private final UserRepository userRepository;

    @GetMapping("password")
    public String getPasswordReset(@ModelAttribute("password") Password password) {
        return "password";
    }

    @PostMapping("password")
    public String sendEmailToReset(@Valid @ModelAttribute("password")
                                           Password password,
                                   BindingResult result, Model model) {
        //check for errors
        if (result.hasErrors()) {
            model.addAttribute("password", password);
            return "password";
        }

        //verify email from database
        if (userRepository.findFirstByEmail(password.getEmail()) == null) {
            result.rejectValue("email", "error.user", "Taki email nie istnieje");
            model.addAttribute("password", password);
            return "password";
        }

        //fire off an event to reset email
        eventPublisher.publishEvent(new OnPasswordResetEvent(password, "/"));
        return "emailSend";
    }

    @GetMapping("passwordReset")
    public String getNewPassword(@RequestParam("token") String token, Model model) {

        //verify token
        ResetToken resetToken = resetTokenRepository.findFirstByToken(token);
        if (resetToken != null && resetToken.getExpiryDate().after(new Date())) {
            Password password = new Password();
            password.setToken(token);
            password.setEmail(resetToken.getEmail());
            model.addAttribute("password", password);
            return "resetPassword";
        }
        return "tokenExpired";
    }

    @PostMapping("passwordReset")
    public String saveNewPassword(@Valid @ModelAttribute("password") Password password,
                                  BindingResult result) {
        //Check for errors
        if (result.hasErrors()) {
            return "resetPassword";
        }

        //match the password
        if (!password.getPassword().equals(password.getMatchingPassword())) {
            result.rejectValue("password", "error.user", "Wpisane hasła są różne");
            return "resetPassword";
        }

        //save new password
        password.setPassword(encoder.encode(password.getPassword()));
        passwordService.update(password);
        return "resetConfirmed";
    }
}
