package com.mehdilagdimi.chiforekv2.model;

import lombok.Builder;

import java.util.Objects;

@Builder
public record ReservationRequest(Long errandId, Long recipientId) {
    public ReservationRequest {
        Objects.requireNonNull(errandId);
        Objects.requireNonNull(recipientId);
    }
}
