package com.mehdilagdimi.chiforek.base;

import com.mehdilagdimi.chiforek.entity.errand.ErrandService;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_role",
        discriminatorType = DiscriminatorType.STRING)
public class Users extends Person{

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ErrandService> errandServices;


    public List<ErrandService> getErrandServices() {
        return errandServices;
    }

    public void setErrandServices(List<ErrandService> errandServices) {
        this.errandServices = errandServices;
    }
}
