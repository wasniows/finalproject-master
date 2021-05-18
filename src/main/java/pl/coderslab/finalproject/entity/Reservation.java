package pl.coderslab.finalproject.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column
    private LocalDate date;

    @OneToOne
    private User user;

    @OneToOne
    private Court court;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Hour> hours = new ArrayList<>();

}