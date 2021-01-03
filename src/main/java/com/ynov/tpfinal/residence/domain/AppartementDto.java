package com.ynov.tpfinal.residence.domain;

public class AppartementDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    private String name;
    private String residenceName;
    public AppartementDto(String name, String residenceName){
        this.name = name;
        this.residenceName = residenceName;
    }
}
