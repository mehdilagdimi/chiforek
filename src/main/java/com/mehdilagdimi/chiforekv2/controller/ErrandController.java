package com.mehdilagdimi.chiforekv2.controller;

import com.mehdilagdimi.chiforekv2.exception.ErrandNotFoundException;
import com.mehdilagdimi.chiforekv2.model.ErrandDTO;
import com.mehdilagdimi.chiforekv2.model.ErrandRequest;
import com.mehdilagdimi.chiforekv2.model.entity.User;
import com.mehdilagdimi.chiforekv2.service.ErrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/errands")
@RequiredArgsConstructor
public class ErrandController {

    private final ErrandService errandService;

    @PostMapping
    public ResponseEntity<?> save(
            Authentication authentication,
           @RequestBody ErrandRequest errandRequest ) throws IllegalAccessException {
        final ErrandDTO errandDTO =
                errandService.save(
                        errandRequest,
                        (User) authentication.getPrincipal() );
        return ResponseEntity.status(201).body(errandDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "itemsNum", defaultValue = "10") Integer numberOfItems
    ){
        final Page<ErrandDTO> errandDTOList = errandService.getAll(page, numberOfItems);

        return ResponseEntity.ok().body( errandDTOList.getContent() );
    }
    @GetMapping("/providers")
    public ResponseEntity<?> getAllByProvider(
            Authentication authentication,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "itemsNum", defaultValue = "10") Integer numberOfItems
    ){
        final Page<ErrandDTO> errandDTOList =
                errandService
                        .getAllByProvider(
                                null,
                                page,
                                numberOfItems,
                                (User) authentication.getPrincipal());

        return ResponseEntity.ok().body( errandDTOList.getContent() );
    }
    @GetMapping("/providers/{id}")
    public ResponseEntity<?> getAllByProviderId(
            Authentication authentication,
            @PathVariable(name = "id", required = false) Long providerId,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "itemsNum", defaultValue = "10") Integer numberOfItems
    ){
        final Page<ErrandDTO> errandDTOList =
                errandService
                        .getAllByProvider(
                                providerId,
                                page,
                                numberOfItems,
                                (User) authentication.getPrincipal());

        return ResponseEntity.ok().body( errandDTOList.getContent() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Long id ){
        final ErrandDTO errand = errandService.toDTO( errandService.getById(id) );

        return ResponseEntity.ok().body(errand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (
            @PathVariable Long id) throws ErrandNotFoundException {
        errandService.deleteById(id);

        return ResponseEntity.ok().body(id);

    }
    @ExceptionHandler(IllegalAccessException.class)
    private ResponseEntity<?> userNotAllowedToSaveErrand(){
        return  ResponseEntity.status(401).build();
    }
}
