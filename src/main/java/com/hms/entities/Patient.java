package com.hms.entities;

import com.hms.enumerators.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "patient_insurance_number")// owning side to have join column
    private Insurance insurance;// owning side

    @OneToMany(mappedBy = "patient")// inverse side
    private List<Appointment> appointments;

}














