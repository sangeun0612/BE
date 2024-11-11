package com.iiie.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Guardian {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "guardian_id")
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

  // ===연관관계===//
  @OneToOne
  @JoinColumn(name = "caregiver_id", unique = true)
  private Caregiver caregiver;

  @OneToOne
  @JoinColumn(name = "patient_id", unique = true)
  private Patient patient;
}
