package com.hms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    private Doctor hod;

    @ManyToMany
    @Builder.Default
    private List<Doctor> doctors = new LinkedList<>();
}
