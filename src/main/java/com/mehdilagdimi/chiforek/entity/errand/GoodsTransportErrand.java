package com.mehdilagdimi.chiforek.entity.errand;

import com.mehdilagdimi.chiforek.base.enums.SERVICE;
import com.mehdilagdimi.chiforek.base.interfaces.ElementService;
import com.mehdilagdimi.chiforek.base.interfaces.ServiceVisitor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("goodstransport")
public class GoodsTransportErrand extends ErrandService implements ElementService {
    @Transient
    SERVICE service = SERVICE.TRANSPORT;

//    @Enumerated(EnumType.STRING)
//    MEANTYPE meantype;

    private double weightInKg;

    @Override
    public void accept(ServiceVisitor serviceVisitor) {
        serviceVisitor.visit(this);
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }
}
