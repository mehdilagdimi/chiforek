package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.base.interfaces.ServiceVisitor;
import com.mehdilagdimi.chiforek.entity.errand.CarPoolErrand;
import com.mehdilagdimi.chiforek.entity.errand.RelocationErrand;
import com.mehdilagdimi.chiforek.entity.errand.PersonsTransportErrand;

public abstract class ErrandServiceVisitorService implements ServiceVisitor {

    @Override
    public void visit(PersonsTransportErrand personsTransportErrand) {

    }

    @Override
    public void visit(RelocationErrand relocationErrand) {

    }

    @Override
    public void visit(CarPoolErrand carPoolErrand) {

    }
}
