package com.example.demo.repository;

import com.example.demo.domain.Commune;
import com.example.demo.dto.CommuneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer> {
    @Query("SELECT new com.example.demo.dto.CommuneDto(cd) FROM Commune cd")
    List<CommuneDto> getAllCommunes();
    @Query("SELECT c FROM Commune c WHERE c.communeName = :communeName")
    Commune getCommuneByName(@Param("communeName") String communeName);
    @Query("SELECT c FROM Commune c WHERE c.communeId = :communeId")
    CommuneDto getCommuneById(@Param("communeId") Integer communeId);

    //boolean existsCommuneInDistricyByName(String communeName, String districtName);
}
