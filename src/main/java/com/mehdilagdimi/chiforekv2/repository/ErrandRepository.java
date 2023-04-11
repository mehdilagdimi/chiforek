package com.mehdilagdimi.chiforekv2.repository;

import com.mehdilagdimi.chiforekv2.enums.SERVICE;
import com.mehdilagdimi.chiforekv2.model.entity.Errand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ErrandRepository extends JpaRepository<Errand, Long> {
    Page<Errand> findAllByServiceProviderId(Long providerId, Pageable pageable);

    @Query("SELECT e FROM Errand e WHERE (?1 IS NULL OR LOWER(e._from) LIKE %?1%)"
            + " AND (?2 IS NULL OR LOWER(e._to) LIKE %?2%)"
            + " AND (?3 IS NULL OR e.service = ?3)"
            + " AND (?3 IS NULL OR e.date = ?3)"
    )
    Page<Errand> searchByFilter(String from, String to, SERVICE service, LocalDateTime dateTime, Pageable pageable);
}
