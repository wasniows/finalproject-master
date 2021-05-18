package pl.coderslab.finalproject.model;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Password {

//    @Size(min = 8, max = 30, message = "{password.min.max}")
    @NotEmpty(message = "{password.notEmpty}")
    private String password;

    private String matchingPassword;

    @Email(message = "{email.valid}")
    @Size(max = 60, message = "{email.max}")
    @NotEmpty(message = "{email.notEmpty}")
    private String email;

    private String token;
}
