package com.iiie.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CareerHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "career_history_id")
  private Long id;

  @Column(nullable = false)
  private String description;

  // ===연관관계===//
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "caregiver_id", nullable = false)
  private Caregiver caregiver;
}
