package com.learning.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "phone")
@Getter
@Setter
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String number;
    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

}