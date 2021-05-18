package pl.coderslab.finalproject.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "accounts")
public class Account {

    @Id
    @Email(message = "{email.valid}")
    @Size(max = 60, message = "{email.max}")
    @NotEmpty(message = "{email.notEmpty}")
    @Column(length = 60)
    private String email;

    @Size(min = 3, max = 60, message = "{firstName.min.max}")
    @NotEmpty(message = "{firstName.notEmpty}")
    @Column(length = 60)
    private String firstName;

    @Size(min = 3, max = 60, message = "{lastName.min.max}")
    @NotEmpty(message = "{lastName.notEmpty}")
    @Column(length = 60)
    private String lastName;

    @Size(min = 9, max = 30, message = "{phone.min}")
    @NotEmpty(message = "{phone.notEmpty}")
    @Column(length = 30)
    private String phone;

    @Size(min = 3, max = 100, message = "{address.min.max}")
    @NotEmpty(message = "{address.notEmpty}")
    @Column(length = 100)
    private String address;


    //    @Size(min = 8, max = 30, message = "{password.min.max}")
    @NotEmpty(message = "{password.notEmpty}")
    @Column(length = 100)
    private String password;

    @Transient
    private String matchingPassword;
}
