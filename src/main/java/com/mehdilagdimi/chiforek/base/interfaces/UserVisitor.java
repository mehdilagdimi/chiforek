package com.mehdilagdimi.chiforek.base.interfaces;

import com.mehdilagdimi.chiforek.entity.Provider;
import com.mehdilagdimi.chiforek.entity.Recipient;

public interface UserVisitor {
    void visit(Provider provider);
    void visit(Recipient recipient);
}
