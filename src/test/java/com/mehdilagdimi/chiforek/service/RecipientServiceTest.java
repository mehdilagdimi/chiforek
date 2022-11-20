package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.entity.Recipient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipientServiceTest {

    @Autowired
    RecipientService recipientService;
    @Test
    void testRetrievingNumberOfRecipients() {
        List<Recipient> list = recipientService.list();
        assertEquals(1, list.size());
    }
}