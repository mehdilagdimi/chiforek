package com.mehdilagdimi.chiforek.entity.mean;

import com.mehdilagdimi.chiforek.base.enums.MEANTYPE;
import com.mehdilagdimi.chiforek.base.enums.SERVICE;
import com.mehdilagdimi.chiforek.base.enums.SERVICESCOPE;
import com.mehdilagdimi.chiforek.entity.Provider;
import com.mehdilagdimi.chiforek.entity.errand.ErrandService;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mean {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int MAX_PASSENGERS;

    @Column(length = 512)
    private String imagesPath;

    @Enumerated(EnumType.STRING)
    MEANTYPE meantype;

    @Enumerated(EnumType.STRING)
    private static SERVICE service;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private static SERVICESCOPE serviceScope;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
            @JoinColumn(name = "provider_id", referencedColumnName = "id")
    Provider provider;

    @OneToMany(mappedBy = "mean", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ErrandService> errandServices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMAX_PASSENGERS() {
        return MAX_PASSENGERS;
    }

    public void setMAX_PASSENGERS(int MAX_PASSENGERS) {
        this.MAX_PASSENGERS = MAX_PASSENGERS;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    public MEANTYPE getMeantype() {
        return meantype;
    }

    public void setMeantype(MEANTYPE meantype) {
        this.meantype = meantype;
    }

    public static SERVICE getService() {
        return service;
    }

    public static void setService(SERVICE service) {
        Mean.service = service;
    }

    public static SERVICESCOPE getServiceScope() {
        return serviceScope;
    }

    public static void setServiceScope(SERVICESCOPE serviceScope) {
        Mean.serviceScope = serviceScope;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<ErrandService> getErrandServices() {
        return errandServices;
    }

    public void setErrandServices(List<ErrandService> errandServices) {
        this.errandServices = errandServices;
    }
}
