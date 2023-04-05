package com.mehdilagdimi.chiforekv2.model;

import com.mehdilagdimi.chiforekv2.enums.MEANTYPE;
import com.mehdilagdimi.chiforekv2.enums.SERVICE;
import lombok.Builder;

@Builder
public record ErrandRequest (String _from, String _to, SERVICE service, MEANTYPE meantype, String description) {
}
