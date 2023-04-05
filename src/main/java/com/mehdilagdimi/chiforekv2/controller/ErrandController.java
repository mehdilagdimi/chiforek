package com.mehdilagdimi.chiforekv2.controller;

import com.mehdilagdimi.chiforekv2.model.ErrandDTO;
import com.mehdilagdimi.chiforekv2.model.ErrandRequest;
import com.mehdilagdimi.chiforekv2.model.entity.Errand;
import com.mehdilagdimi.chiforekv2.service.ErrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("/api/v1/errands")
@RequiredArgsConstructor
public class ErrandController {

    private final ErrandService errandService;

    @PostMapping
    public ResponseEntity<?> saveErrand(
           @RequestBody ErrandRequest errandRequest ){
        final ErrandDTO errandDTO = errandService.save(errandRequest);

        return ResponseEntity.status(201).body(errandDTO);
    }

    @GetMapping
    public ResponseEntity<?> getErrands(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "itemsNum", defaultValue = "10") Integer numberOfItems
    ){
        final Page<ErrandDTO> errandDTOList = errandService.getAllErrands(page, numberOfItems);

        return ResponseEntity.ok().body( errandDTOList.getContent() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getErrandById(
            @PathVariable() Long id ){
        final ErrandDTO errand = errandService.getErrandById(id);

        return ResponseEntity.ok().body(errand);
    }
}
