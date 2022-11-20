package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.entity.Provider;
import com.mehdilagdimi.chiforek.entity.Recipient;
import com.mehdilagdimi.chiforek.repository.ProviderRepository;
import com.mehdilagdimi.chiforek.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;


    public List<Recipient> list() {
//        providerRepository.findAll(PageRequest.of(1,20));
        return recipientRepository.findAll();
    }
}
