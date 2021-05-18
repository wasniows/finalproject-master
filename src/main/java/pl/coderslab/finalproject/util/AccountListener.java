package pl.coderslab.finalproject.util;

import lombok.Data;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.coderslab.finalproject.entity.Account;
import pl.coderslab.finalproject.service.AccountService;

import java.util.UUID;

@Data
@Component
public class AccountListener implements ApplicationListener<OnCreatedAccountEvent> {

    private String serverUrl = "http://localhost:8080";

    private final JavaMailSender mailSender;
    private final AccountService accountService;

    @Override
    public void onApplicationEvent(OnCreatedAccountEvent event) {
        this.confirmCreateAccount(event);
    }

    private void confirmCreateAccount(OnCreatedAccountEvent event) {

        //get the account
        Account account = event.getAccount();

        //create verification token
        String token = UUID.randomUUID().toString();
        accountService.createVerificationToken(account, token);

        //get email properties
        String recipientAddress = account.getEmail();
        String subject = "Aktywacja Konta Klubu tenisowego GEM SET MECZ";
        String confirmationUrl = event.getAppUrl() + "accountConfirm?token=" + token;
        String message = "Link aktywacyjny nowe konto:";

        //send email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + serverUrl + confirmationUrl);
        mailSender.send(email);
    }
}
