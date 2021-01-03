package com.ynov.tpfinal.residence.domain;

public class ResidenceDto {

    private String name;
    private long nbAppartement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNbAppartement() {
        return nbAppartement;
    }

    public void setNbAppartement(int nbAppartement) {
        this.nbAppartement = nbAppartement;
    }

    public ResidenceDto(String name, long nbAppartement) {
        this.name = name;
        this.nbAppartement = nbAppartement;
    }
}
