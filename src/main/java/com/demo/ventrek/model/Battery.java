package com.demo.ventrek.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "battery")
public class Battery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="postcode")
    private String postcode;
    @Column(name ="capacity")
    private int capacity;
}
