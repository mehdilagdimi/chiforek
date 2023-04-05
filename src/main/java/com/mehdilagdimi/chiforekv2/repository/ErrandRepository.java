package com.mehdilagdimi.chiforekv2.repository;

import com.mehdilagdimi.chiforekv2.model.entity.Errand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrandRepository extends JpaRepository<Errand, Long> {
}
