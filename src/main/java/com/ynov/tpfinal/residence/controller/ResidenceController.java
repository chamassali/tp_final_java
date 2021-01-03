package com.ynov.tpfinal.residence.controller;

import com.ynov.tpfinal.residence.domain.Appartement;
import com.ynov.tpfinal.residence.domain.AppartementDto;
import com.ynov.tpfinal.residence.domain.Residence;
import com.ynov.tpfinal.residence.domain.ResidenceDto;
import com.ynov.tpfinal.residence.service.ResidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/residence")
public class ResidenceController {

    ResidenceService residenceService;

    public ResidenceController(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @GetMapping("/appartement")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement> getAppartements() {
        return residenceService.getAppartements();
    }

    @GetMapping("/residence")
    @ResponseStatus(HttpStatus.OK)
    public List<Residence> getResidences() {
        return residenceService.getResidences();
    }

    @GetMapping("/residence-without-fetch")
    @ResponseStatus(HttpStatus.OK)
    public List<Residence> getResidencesWithoutFetch() {
        return residenceService.getResidencesWithoutFetch();
    }

    @GetMapping("/residence-nb-appartement")
    @ResponseStatus(HttpStatus.OK)
    public List<ResidenceDto> getResidencesWithNbAppartements() {
        return residenceService.getResidencesWhithNbAppartement();
    }

    @GetMapping("/vdto")
    @ResponseStatus(HttpStatus.OK)
    public List<AppartementDto> getAppartementDto() {
        return residenceService.getAppartementDto();
    }

    @GetMapping("/appartement/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement getAppartement(@PathVariable String id) {
        Appartement appartement = residenceService.getAppartement(id);
        if (appartement == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appartement not found");
        }
        return appartement;
    }

    @GetMapping("/appartement/generate")
    @ResponseStatus(HttpStatus.OK)
    public void generateAppartements() {
        residenceService.generateAppartements();
    }

    @GetMapping("/residence/generate")
    @ResponseStatus(HttpStatus.OK)
    public void generateResidence() {
        residenceService.generateResidence();
    }

    @PostMapping("Residence_create")
    @ResponseStatus(HttpStatus.OK)
    public void CreateResidence(String name, String country, String region,String address,String typeOfPlace,boolean swimmingPool, boolean spa, boolean wifi){
        residenceService.createResidence(name,country,region,address,typeOfPlace,swimmingPool,spa,wifi);
    }

    @PutMapping("Residence_Edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateResidence(Long id, String name, String country, String region, String address,String typeOfPlace, boolean swimmingPool, boolean spa, boolean wifi){
        residenceService.updateResidence(id,name,country,region,address,typeOfPlace,swimmingPool,spa,wifi);
    }

    @DeleteMapping("Residence_Delete")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteResidence(Long id){
        residenceService.deleteResidence(id);
    }

    @PostMapping("Appartement_create")
    @ResponseStatus(HttpStatus.OK)
    public void CreateAppartement(Long residence_id, String name, Integer numberOfRooms, Integer area, boolean babyEquipment, boolean climatisation, Integer price){
        residenceService.createAppartement(residence_id,name,numberOfRooms,area,babyEquipment,climatisation,price);
    }

    @PutMapping("Appartement_Edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateAppartement(Long id, String name, Integer numberOfRooms, Integer area, boolean babyEquipment, boolean climatisation, Integer price){
        residenceService.updateAppartement(id,name,numberOfRooms,area,babyEquipment,climatisation,price);
    }

    @DeleteMapping("Appartement_Delete")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteAppartement(Long id){
        residenceService.deleteAppartement(id);
    }

    @GetMapping("Search_By_Country")
    @ResponseStatus(HttpStatus.OK)
    public void getResidenceByCountry(String country){
        residenceService.getResidenceByCountry(country);
    }




}