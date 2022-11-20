package com.mehdilagdimi.chiforek.entity.errand;

import com.mehdilagdimi.chiforek.base.enums.SERVICE;
import com.mehdilagdimi.chiforek.base.interfaces.ElementService;
import com.mehdilagdimi.chiforek.base.interfaces.ServiceVisitor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("relocation")
public class RelocationErrand extends ErrandService implements ElementService {
    @Transient
    SERVICE service = SERVICE.RELOCATION;



    @Override
    public void accept(ServiceVisitor serviceVisitor) {
        serviceVisitor.visit(this);
    }


}

