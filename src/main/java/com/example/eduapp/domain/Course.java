package com.example.eduapp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "coures_tb")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String email;
}


