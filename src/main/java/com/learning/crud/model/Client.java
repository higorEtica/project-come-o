package com.learning.crud.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(name = "date_of_age")
    @Temporal(TemporalType.DATE)
    private Date dateOfAge;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Phone> phones;

}
