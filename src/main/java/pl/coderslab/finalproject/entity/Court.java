package pl.coderslab.finalproject.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courts")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

}
