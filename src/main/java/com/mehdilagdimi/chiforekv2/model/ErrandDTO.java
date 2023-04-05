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
    private String _from;
    private String _to;
    private SERVICE service;
    private MEANTYPE meantype;
    private LocalDateTime created_at;
    private String description;
}

