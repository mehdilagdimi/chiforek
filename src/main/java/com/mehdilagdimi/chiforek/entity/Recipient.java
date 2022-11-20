package com.mehdilagdimi.chiforek.entity;

import com.mehdilagdimi.chiforek.base.Users;
import com.mehdilagdimi.chiforek.base.interfaces.ElementUser;
import com.mehdilagdimi.chiforek.base.interfaces.UserVisitor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("recipient")
public class Recipient extends Users implements ElementUser {
    @Override
    public void accept(UserVisitor userVisitor){
        userVisitor.visit(this);
    }
}
