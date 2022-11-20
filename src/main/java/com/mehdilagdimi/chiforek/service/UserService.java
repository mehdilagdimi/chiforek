package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.base.Users;
import com.mehdilagdimi.chiforek.entity.Book;
import com.mehdilagdimi.chiforek.repository.BookRepository;
import com.mehdilagdimi.chiforek.repository.ProviderRepository;
import com.mehdilagdimi.chiforek.repository.RecipientRepository;
import com.mehdilagdimi.chiforek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<Users> list() {
//        userRepository.findAll(PageRequest.of(1,20));
        return userRepository.findAll();
    }
}
