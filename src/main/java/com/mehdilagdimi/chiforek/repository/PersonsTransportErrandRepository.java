package com.mehdilagdimi.chiforek.repository;

import com.mehdilagdimi.chiforek.entity.errand.PersonsTransportErrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
//public interface BookRepository extends CrudRepository<Book, Long> {
public interface PersonsTransportErrandRepository extends JpaRepository<PersonsTransportErrand, Long> {
}