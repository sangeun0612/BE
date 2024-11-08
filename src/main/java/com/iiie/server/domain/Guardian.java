package com.iiie.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Gurdian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long kakaoId;

    @ColumnDefault(value = "0.0")
    private Double mannerScore;

    @Column(nullable = false)
    private UUID uniqueCode;
}
