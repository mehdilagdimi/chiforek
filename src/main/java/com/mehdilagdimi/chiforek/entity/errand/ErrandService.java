package com.mehdilagdimi.chiforek.entity.errand;

import com.mehdilagdimi.chiforek.base.Users;
import com.mehdilagdimi.chiforek.base.enums.RATING;
import com.mehdilagdimi.chiforek.base.enums.SERVICE;
import com.mehdilagdimi.chiforek.base.enums.SERVICESCOPE;
import com.mehdilagdimi.chiforek.entity.mean.Mean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="errand_type",
        discriminatorType = DiscriminatorType.STRING)
public class ErrandService {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String _from;
    private String _to;
    private String fromOnMapCoordinates;
    private String toOnMapCoordinates;


    @Enumerated(EnumType.STRING)
    RATING rating = RATING.NEUTRAL;


    @Enumerated(EnumType.STRING)
    SERVICE service;

    @Enumerated(EnumType.STRING)
    SERVICESCOPE SERVICESCOPE;

    @Column(nullable = false)
    Timestamp created_at = Timestamp.from(Instant.now());

    Timestamp acceptanceDate;
    @Column(length = 512)
    String description;

    @Column(length = 1024)
    String review;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mean_id", referencedColumnName = "id")
    Mean mean;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return _from;
    }

    public void setFrom(String _from) {
        this._from = _from;
    }

    public String getTo() {
        return _to;
    }

    public void setTo(String _to) {
        this._to = _to;
    }

    public String getFromOnMapCoordinates() {
        return fromOnMapCoordinates;
    }

    public void setFromOnMapCoordinates(String fromOnMapCoordinates) {
        this.fromOnMapCoordinates = fromOnMapCoordinates;
    }

    public String getToOnMapCoordinates() {
        return toOnMapCoordinates;
    }

    public void setToOnMapCoordinates(String toOnMapCoordinates) {
        this.toOnMapCoordinates = toOnMapCoordinates;
    }

    public RATING getRating() {
        return rating;
    }

    public void setRating(RATING rating) {
        this.rating = rating;
    }

    public SERVICE getService() {
        return service;
    }

    public void setService(SERVICE service) {
        this.service = service;
    }

    public com.mehdilagdimi.chiforek.base.enums.SERVICESCOPE getSERVICESCOPE() {
        return SERVICESCOPE;
    }

    public void setSERVICESCOPE(com.mehdilagdimi.chiforek.base.enums.SERVICESCOPE SERVICESCOPE) {
        this.SERVICESCOPE = SERVICESCOPE;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Timestamp acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Mean getMean() {
        return mean;
    }

    public void setMean(Mean mean) {
        this.mean = mean;
    }
}
