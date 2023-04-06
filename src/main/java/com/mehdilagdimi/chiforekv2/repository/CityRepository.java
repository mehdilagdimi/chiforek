package com.mehdilagdimi.chiforekv2.repository;

import com.mehdilagdimi.chiforekv2.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface CityRepository extends JpaRepository<City, Long> {

}
