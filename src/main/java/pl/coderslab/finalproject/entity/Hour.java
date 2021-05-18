package pl.coderslab.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hours")
public class Hour implements Comparable<Hour>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String name;

    @Override
    public int compareTo(Hour hour) {
        return (int) (this.id - hour.getId());
    }
}
