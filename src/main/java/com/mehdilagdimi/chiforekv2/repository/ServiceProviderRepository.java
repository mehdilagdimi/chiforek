package com.mehdilagdimi.chiforekv2.repository;

import com.mehdilagdimi.chiforekv2.model.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
}
