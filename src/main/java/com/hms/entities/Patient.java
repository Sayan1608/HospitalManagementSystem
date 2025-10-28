package com.hms.entities;

import com.hms.enumerators.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
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

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_number")// owning side to have join column
    private Insurance insurance;// owning side

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)// inverse side
//    @ToString.Exclude
    @Builder.Default
    private List<Appointment> appointments = new LinkedList<>();

}














