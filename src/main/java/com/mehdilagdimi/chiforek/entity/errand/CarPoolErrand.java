package com.mehdilagdimi.chiforek.entity.errand;

import com.mehdilagdimi.chiforek.base.enums.SERVICE;
import com.mehdilagdimi.chiforek.base.interfaces.ElementService;
import com.mehdilagdimi.chiforek.base.interfaces.ServiceVisitor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("carpool")
public class CarPoolErrand extends ErrandService implements ElementService {

    @Transient
    SERVICE service = SERVICE.CAR_POOLING;

    private int numOfPassengers;



    @Override
    public void accept(ServiceVisitor serviceVisitor) {
        serviceVisitor.visit(this);
    }



    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
