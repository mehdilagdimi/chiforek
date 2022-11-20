package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProviderServiceTest {

    @Autowired
    ProviderService providerService;

    @Test
    void testRetrievingNumberOfProviders() {
        List<Provider> list =  providerService.list();
        assertEquals(2, list.size());
    }
}