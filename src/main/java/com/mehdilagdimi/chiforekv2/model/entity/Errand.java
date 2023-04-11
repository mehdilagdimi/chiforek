package com.mehdilagdimi.chiforekv2.model.entity;

import com.mehdilagdimi.chiforekv2.enums.MEANTYPE;
import com.mehdilagdimi.chiforekv2.enums.SERVICE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="errand_type",
        discriminatorType = DiscriminatorType.STRING)
public class Errand {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String _from;
    private String _to;

    @Enumerated(EnumType.STRING)
    private SERVICE service;

    @Enumerated(EnumType.STRING)
    private MEANTYPE meantype;

    private LocalDateTime date;

    private int maxNumOfSeats;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(length = 512)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private ServiceProvider serviceProvider;

}
