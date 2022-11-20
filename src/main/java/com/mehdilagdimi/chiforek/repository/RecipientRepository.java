package com.mehdilagdimi.chiforek.repository;

import com.mehdilagdimi.chiforek.entity.Provider;
import com.mehdilagdimi.chiforek.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
//public interface BookRepository extends CrudRepository<Book, Long> {
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}