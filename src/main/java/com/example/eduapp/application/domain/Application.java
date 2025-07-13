package com.example.eduapp.application.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "application_tb")
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
