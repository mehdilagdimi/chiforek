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
public class ErrandDTO {
    private Long id;
    private String from;
    private String username;
    private String to;
    private SERVICE service;
    private MEANTYPE meantype;
    private LocalDateTime createdAt;
    private String description;
}

