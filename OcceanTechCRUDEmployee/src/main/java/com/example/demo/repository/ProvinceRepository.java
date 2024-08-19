package com.example.demo.repository;

import com.example.demo.domain.Province;
import com.example.demo.dto.ProvinceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

    @Query("SELECT new com.example.demo.dto.ProvinceDto(pd) from Province pd")
    List<ProvinceDto> getAllProvinces();

}
