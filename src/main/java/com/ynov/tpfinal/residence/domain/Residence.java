package com.ynov.tpfinal.residence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    @OneToMany
    @JoinColumn(name="RESIDENCE_ID")
    private Set<Appartement> appartements;

    private String country;
    private String region;
    private String address;
    private String typeOfPlace;
    private boolean swimmingPool;
    private boolean spa;
    private boolean wifi;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Appartement> getAppartements() {
        return appartements;
    }

    public void setAppartements(Set<Appartement> appartements) {
        this.appartements = appartements;
    }

    public void setNom(String name) {

    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTypeOfPlace(String typeOfPlace) {
        this.typeOfPlace = typeOfPlace;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

}
