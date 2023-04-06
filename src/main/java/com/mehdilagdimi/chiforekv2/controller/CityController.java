package com.mehdilagdimi.chiforekv2.controller;

import com.mehdilagdimi.chiforekv2.model.CityDTO;
import com.mehdilagdimi.chiforekv2.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping
    public ResponseEntity<?> getAll(){
//        List<City> cityList = cityRepository.findAll();
        List<CityDTO> cityList =
                Arrays.asList(
                        CityDTO.builder().name("Marrakech").build(),
                        CityDTO.builder().name("Casa").build(),
                        CityDTO.builder().name("Rabat").build() );
        return ResponseEntity.ok().body(cityList);
    }

}
