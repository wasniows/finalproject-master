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
import pl.coderslab.finalproject.entity.Account;
import pl.coderslab.finalproject.entity.VerificationToken;
import pl.coderslab.finalproject.repository.UserRepository;
import pl.coderslab.finalproject.repository.VerificationTokenRepository;
import pl.coderslab.finalproject.service.AccountService;
import pl.coderslab.finalproject.util.OnCreatedAccountEvent;

import javax.validation.Valid;
import java.util.Date;

@Data
@Controller
public class AccountController {

    private final AccountService accountService;
    private final PasswordEncoder encoder;
    private final ApplicationEventPublisher eventPublisher;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;


    @GetMapping("account")
    public String getRegistration(@ModelAttribute("account") Account account) {
        return "account";
    }

    @PostMapping("account")
    public String addRegistration(@Valid @ModelAttribute("account")
                                          Account account,
                                  BindingResult result, Model model) {

        //check for errors
        if (result.hasErrors()) {
            model.addAttribute("account", account);
            return "account";
        }

        //verify that the email don't already exist
        if (userRepository.findFirstByEmail(account.getEmail()) != null) {
            result.rejectValue("email", "error.user", "Taki email już istnieje");
            model.addAttribute("account", account);
            return "account";
        }

        //check matching passwords
        if (!account.getPassword().equals(account.getMatchingPassword())) {
            result.rejectValue("password", "error.user", "Wpisane hasła są różne");
            model.addAttribute("account", account);
            return "account";
        }

        //encrypt password
        account.setPassword(encoder.encode(account.getPassword()));

        //create the account
        account = accountService.create(account);

        //fire off an event on creation
        eventPublisher.publishEvent(new OnCreatedAccountEvent(account, "/"));
        return "emailSend";
    }

    @GetMapping("accountConfirm")
    public String confirmAccount(@RequestParam("token") String token) {

        VerificationToken verificationToken = verificationTokenRepository.findFirstByToken(token);
        if (verificationToken != null && verificationToken.getExpiryDate().after(new Date())) {
            accountService.confirmAccount(token);
            return "accountConfirmed";
        }
        return "tokenExpired";
    }
}
