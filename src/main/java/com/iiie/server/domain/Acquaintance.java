package com.iiie.server.domain;

import com.iiie.server.type.RelationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Acquaintance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "acquaintance_id")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RelationType relationType;

  // ===연관관계===//
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "guardian_id", nullable = false)
  private Guardian guardian;
}
