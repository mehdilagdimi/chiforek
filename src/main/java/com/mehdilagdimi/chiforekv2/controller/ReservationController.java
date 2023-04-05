package com.mehdilagdimi.chiforekv2.controller;

import com.mehdilagdimi.chiforekv2.exception.ErrandNotFoundException;
import com.mehdilagdimi.chiforekv2.model.ErrandDTO;
import com.mehdilagdimi.chiforekv2.model.ErrandRequest;
import com.mehdilagdimi.chiforekv2.model.ReservationDTO;
import com.mehdilagdimi.chiforekv2.model.ReservationRequest;
import com.mehdilagdimi.chiforekv2.model.entity.User;
import com.mehdilagdimi.chiforekv2.service.ErrandService;
import com.mehdilagdimi.chiforekv2.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> save(
            Authentication authentication,
           @RequestBody ReservationRequest reservationRequest ) throws IllegalAccessException {
        final ReservationDTO reservationDTO =
                reservationService.save(
                        reservationRequest,
                        (User) authentication.getPrincipal() );

        return ResponseEntity.status(201).body(reservationDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "itemsNum", defaultValue = "10") Integer numberOfItems
    ){
        final Page<ReservationDTO> errandDTOList = reservationService.getAll(page, numberOfItems);

        return ResponseEntity.ok().body( errandDTOList.getContent() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Long id ){
        final ReservationDTO errand = reservationService.getById(id);

        return ResponseEntity.ok().body(errand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (
            @PathVariable Long id) throws ErrandNotFoundException {
        reservationService.deleteById(id);

        return ResponseEntity.ok().body(id);

    }
    @ExceptionHandler(IllegalAccessException.class)
    private ResponseEntity<?> userNotAllowedToSaveErrand(){
        return  ResponseEntity.status(401).build();
    }
}
