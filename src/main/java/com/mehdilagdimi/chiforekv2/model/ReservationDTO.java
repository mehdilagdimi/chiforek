package com.mehdilagdimi.chiforekv2.model;

import com.mehdilagdimi.chiforekv2.enums.MEANTYPE;
import com.mehdilagdimi.chiforekv2.enums.SERVICE;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDTO {
    private Long id;
    private Long errandId;
    private String from;
    private String to;
    private String recipientEmail;
    private String providerEmail;
    private SERVICE service;
    private MEANTYPE meantype;
    private LocalDateTime createdAt;
}

