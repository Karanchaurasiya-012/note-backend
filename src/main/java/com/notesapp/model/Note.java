package com.notesapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, unique = true)
    private String shareId;

    // Before saving, generate shareId
    @PrePersist
    public void generateShareId() {
        if (this.shareId == null) {
            this.shareId = UUID.randomUUID().toString().substring(0, 8);
        }
    }
}
