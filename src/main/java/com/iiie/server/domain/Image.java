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
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "image_id")
  private Long id;

  @Column(nullable = false)
  private String imageUrl;

  // ===연관관계===//
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gallery_id")
  private Gallery gallery;
}
