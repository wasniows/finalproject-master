package pl.coderslab.finalproject.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@Table(name = "reset_tokens")
public class ResetToken {

    public static final int EXPIRATION = 60 * 24;

    @Id
    @Column(length = 60)
    private String token;

    @Column(length = 60)
    private String email;

    @Column
    private Date expiryDate;

    public Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return cal.getTime();
    }
}
