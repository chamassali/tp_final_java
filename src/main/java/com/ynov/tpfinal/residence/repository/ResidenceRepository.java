package com.ynov.tpfinal.residence.repository;
import com.ynov.tpfinal.residence.domain.Residence;
import com.ynov.tpfinal.residence.domain.ResidenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    @Query(value = "SELECT * FROM Residence WHERE country LIKE lower(:country)",  nativeQuery = true)
    List<Residence> getResidenceByCountry(String country);

    @Query(value = "SELECT r FROM Residence r WHERE r.id = :#{#id}")
    Residence findByIdResidence(@Param("id") Long id);

    @Query(value = "SELECT r FROM Residence r JOIN FETCH r.appartements ")
    List<Residence> getResidenceWhithAppartements();

    @Query(value = "SELECT NEW com.ynov.tpfinal.residence.domain.ResidenceDto(r.name, count(a)) FROM Residence r LEFT JOIN r.appartements a GROUP BY r.id")
    List<ResidenceDto> getResidenceWhithNbAppartement();

}
