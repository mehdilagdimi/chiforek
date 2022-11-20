package com.mehdilagdimi.chiforek.entity;

import com.mehdilagdimi.chiforek.base.Users;
import com.mehdilagdimi.chiforek.entity.mean.Mean;
import com.mehdilagdimi.chiforek.base.enums.MEANTYPE;
import com.mehdilagdimi.chiforek.base.enums.SERVICE;
import com.mehdilagdimi.chiforek.base.interfaces.ElementUser;
import com.mehdilagdimi.chiforek.base.interfaces.UserVisitor;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("provider")
public class Provider extends Users implements ElementUser {

    @Enumerated(EnumType.STRING)
    SERVICE service;

    @Enumerated(EnumType.STRING)
    MEANTYPE meantype;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Mean> means;

    @Override
    public void accept(UserVisitor userVisitor){
        userVisitor.visit(this);
    }

    public SERVICE getService() {
        return service;
    }

    public void setService(SERVICE service) {
        this.service = service;
    }

    public MEANTYPE getMeantype() {
        return meantype;
    }

    public void setMeantype(MEANTYPE meantype) {
        this.meantype = meantype;
    }

    public List<Mean> getMeans() {
        return means;
    }

    public void setMeans(List<Mean> means) {
        this.means = means;
    }
}
