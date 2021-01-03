package com.ynov.tpfinal.residence.service;

import com.ynov.tpfinal.residence.domain.Residence;
import com.ynov.tpfinal.residence.domain.ResidenceDto;
import com.ynov.tpfinal.residence.domain.Appartement;
import com.ynov.tpfinal.residence.domain.AppartementDto;
import com.ynov.tpfinal.residence.repository.AppartementRepository;
import com.ynov.tpfinal.residence.repository.ResidenceRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ResidenceService {

    private final AppartementRepository appartementRepository;
    private ResidenceRepository residenceRepository;

    public ResidenceService(AppartementRepository appartementRepository,
                            ResidenceRepository residenceRepository) {
        this.appartementRepository = appartementRepository;
        this.residenceRepository = residenceRepository;
    }

    public List<Appartement> getAppartements() {
        return appartementRepository.findAll();
    }

    public Appartement getAppartement(String id) {

        return appartementRepository.findByName(id);
    }

    public void generateAppartements() {
        Appartement appartement = new Appartement();
        appartement.setName("VILLAAA");
        appartementRepository.save(appartement);

        appartement = new Appartement();
        appartement.setName("APPAAART");
        appartementRepository.save(appartement);
    }

    // @Transactional
    public void generateResidence() {
        Residence residence = new Residence();
        residence.setName("JESAISPAS");
        residenceRepository.save(residence);
        residence.setAppartements(new HashSet<>());
        Appartement appartement = new Appartement();
        appartement.setName("PENTHOUSSE-");
        appartementRepository.save(appartement);
        residence.getAppartements().add(appartement);
        appartement = new Appartement();
        appartement.setName("VILLAA2");
        appartementRepository.save(appartement);
        residence.getAppartements().add(appartement);
        // concessionRepository.save(concession);
    }

    public List<Residence> getResidences() {
        return residenceRepository.getResidenceWhithAppartements();
    }
    public List<ResidenceDto> getResidencesWhithNbAppartement() {
        return residenceRepository.getResidenceWhithNbAppartement();
    }

    public List<AppartementDto> getAppartementDto() {
        List<AppartementDto> allAppartementDto = appartementRepository.findAllAppartementDto();
        allAppartementDto.stream().forEach(System.out::println);
        return allAppartementDto;
    }

    public List<Residence> getResidencesWithoutFetch() {
        return residenceRepository.findAll();
    }


    public void createResidence(String name, String country, String region, String address,String typeOfPlace, boolean swimmingPool, boolean spa, boolean wifi) {
        Residence residence = new Residence();
        residence.setName(name);
        residence.setCountry(country);
        residence.setRegion(region);
        residence.setAddress(address);
        residence.setTypeOfPlace(typeOfPlace);
        residence.setSwimmingPool(swimmingPool);
        residence.setSpa(spa);
        residence.setWifi(wifi);
        residenceRepository.save(residence);
    }

    public void updateResidence(Long id, String name, String country, String region, String address,String typeOfPlace, boolean swimmingPool, boolean spa, boolean wifi) {
        Residence residence = residenceRepository.findByIdResidence(id);
        residence.setName(name);
        residence.setCountry(country);
        residence.setRegion(region);
        residence.setAddress(address);
        residence.setTypeOfPlace(typeOfPlace);
        residence.setSwimmingPool(swimmingPool);
        residence.setSpa(spa);
        residence.setWifi(wifi);
        residenceRepository.save(residence);
    }

    public void deleteResidence(Long id) {
        Residence residence = residenceRepository.findByIdResidence(id);
        residenceRepository.delete(residence);
    }

    public void createAppartement(Long residence_id, String name, Integer numberOfRooms, Integer area, boolean babyEquipment, boolean climatisation, Integer price) {
        Appartement appartement = new Appartement();
        appartement.setName(name);
        appartement.setResidenceId(residence_id);
        appartement.setNumberOfRooms(numberOfRooms);
        appartement.setArea(area);
        appartement.setBabyEquipment(babyEquipment);
        appartement.setClimatisation(climatisation);
        appartement.setPrice(price);
        appartementRepository.save(appartement);
    }

    public void updateAppartement(Long id, String name, Integer numberOfRooms, Integer area, boolean babyEquipment, boolean climatisation, Integer price) {
        Appartement appartement = appartementRepository.findByIdAppartement(id);
        appartement.setName(name);
        appartement.setNumberOfRooms(numberOfRooms);
        appartement.setArea(area);
        appartement.setBabyEquipment(babyEquipment);
        appartement.setClimatisation(climatisation);
        appartement.setPrice(price);
        appartementRepository.save(appartement);
    }

    public void deleteAppartement(Long id) {
        Appartement appartement = appartementRepository.findByIdAppartement(id);
        appartementRepository.delete(appartement);
    }

    public List<Residence> getResidenceByCountry(String country) {
        return residenceRepository.getResidenceByCountry(country);
    }

}
