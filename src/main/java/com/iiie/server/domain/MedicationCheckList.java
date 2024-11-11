package com.iiie.server.domain;

import com.iiie.server.type.TakenStatus;
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
public class MedicationCheckList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "medication_checklist_id")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  private TakenStatus morningTakenStatus;

  @Enumerated(EnumType.STRING)
  private TakenStatus afternoonTakenStatus;

  @Enumerated(EnumType.STRING)
  private TakenStatus eveningTakenStatus;

  // ===연관관계===//
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id", nullable = false)
  private Patient patient;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "care_report_id")
  private CareReport careReport;
}
