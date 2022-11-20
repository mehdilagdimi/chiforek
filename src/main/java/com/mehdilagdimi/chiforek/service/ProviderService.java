package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.entity.Provider;
import com.mehdilagdimi.chiforek.repository.ProviderRepository;
import com.mehdilagdimi.chiforek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;


    public List<Provider> list() {
//        providerRepository.findAll(PageRequest.of(1,20));
        return providerRepository.findAll();
    }
}
