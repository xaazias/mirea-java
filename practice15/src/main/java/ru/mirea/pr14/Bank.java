package ru.mirea.pr14;

import org.hibernate.annotations.GenericGenerator;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Bank() {}
}
