package com.example.drogeria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Client {


    @SequenceGenerator(
            name = "sequenceClient",
            sequenceName = "sequenceClient",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequenceClient"
    )

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String numberOfPhone;
    @OneToOne(mappedBy = "client")
    private Order order;
}
