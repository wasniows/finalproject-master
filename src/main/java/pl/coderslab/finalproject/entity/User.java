package pl.coderslab.finalproject.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, unique = true)
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

    @Column(length = 100)
    private String password;

    @Column
    private boolean reservationAccess;

    @Column
    private boolean enabled;

    public User(String email, String firstName, String lastName, String phone, String address, String password, boolean enabled, boolean reservationAccess) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.enabled = enabled;
        this.reservationAccess = reservationAccess;
    }

    public User() {
    }
}
