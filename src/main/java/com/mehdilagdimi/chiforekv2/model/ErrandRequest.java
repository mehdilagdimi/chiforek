package com.mehdilagdimi.chiforekv2.model;

import com.mehdilagdimi.chiforekv2.enums.MEANTYPE;
import com.mehdilagdimi.chiforekv2.enums.SERVICE;
import lombok.Builder;

import java.util.Objects;

@Builder
public record ErrandRequest (String _from, String _to, SERVICE service, MEANTYPE meantype, String description) {
    public ErrandRequest {
        Objects.requireNonNull(_from);
        Objects.requireNonNull(_to);
        Objects.requireNonNull(service);
        Objects.requireNonNull(meantype);
    }
}
