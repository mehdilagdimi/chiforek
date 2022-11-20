//package com.mehdilagdimi.chiforek.service;
//
//import com.mehdilagdimi.chiforek.repository.MeanRepository;
//import com.mehdilagdimi.chiforek.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.util.List;
//
//@Service
//public class CrudService {
//
//    @Autowired
//    private static MeanRepository meanRepository;
//    @Autowired
//    private static UserRepository userRepository;
//
//
//    public static<T extends JpaRepository> List list() {
//        userRepository.findAll(PageRequest.of(1,20));
//        return userRepository.findAll();
//    }
//}
