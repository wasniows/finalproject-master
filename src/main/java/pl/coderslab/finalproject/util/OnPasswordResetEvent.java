package pl.coderslab.finalproject.util;

import org.springframework.context.ApplicationEvent;
import pl.coderslab.finalproject.model.Password;

public class OnPasswordResetEvent extends ApplicationEvent {
    private String appUrl;
    private Password password;

    public OnPasswordResetEvent(Password password, String appUrl) {
        super(password);

        this.appUrl = appUrl;
        this.password = password;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Password getPassword() {
        return password;
    }
}
