package com.mehdilagdimi.chiforek.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PaymentGate {
    @Id
    @GeneratedValue
    long id;
}
