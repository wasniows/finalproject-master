package pl.coderslab.finalproject.util;

import org.springframework.context.ApplicationEvent;
import pl.coderslab.finalproject.entity.Account;

public class OnCreatedAccountEvent extends ApplicationEvent {

    private String appUrl;
    private Account account;

    public OnCreatedAccountEvent(Account account, String appUrl) {
        super(account);

        this.account = account;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Account getAccount() {
        return account;
    }
}
