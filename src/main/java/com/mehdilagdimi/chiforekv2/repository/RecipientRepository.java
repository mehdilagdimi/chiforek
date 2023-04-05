package com.mehdilagdimi.chiforekv2.repository;

import com.mehdilagdimi.chiforekv2.model.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
