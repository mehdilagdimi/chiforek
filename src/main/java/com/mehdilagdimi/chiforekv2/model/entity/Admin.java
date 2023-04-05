package com.mehdilagdimi.chiforekv2.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User {

    public Admin(){
    }

    public Admin(User parent) {
        super(parent.getEmail(), parent.getUsername(), parent.getTele(), parent.getRole(), parent.getPassword());
    }
}
