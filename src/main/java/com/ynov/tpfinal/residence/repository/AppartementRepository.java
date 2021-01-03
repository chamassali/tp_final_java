package com.ynov.tpfinal.residence.repository;

import com.ynov.tpfinal.residence.domain.Appartement;
import com.ynov.tpfinal.residence.domain.AppartementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
    Appartement findByName(String id);

    @Query(value = "SELECT a FROM Appartement a WHERE a.id = :#{#id}")
    Appartement findByIdAppartement(@Param("id") Long id);

    @Query(value = "SELECT a FROM Appartement a WHERE a.name = :id")
    Appartement findByMyValue(String id);

    @Query(value = "SELECT NEW com.ynov.tpfinal.residence.domain.AppartementDto(a.name, r.name) FROM Residence r LEFT JOIN r.appartements a group by a.id")
    List<AppartementDto> findAllAppartementDto();
}
