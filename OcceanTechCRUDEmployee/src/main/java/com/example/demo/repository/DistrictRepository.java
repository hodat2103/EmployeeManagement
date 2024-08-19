package com.example.demo.repository;

import com.example.demo.domain.District;
import com.example.demo.domain.Province;
import com.example.demo.dto.DistrictDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("SELECT new com.example.demo.dto.DistrictDto(dd) FROM District dd")
    List<DistrictDto> getAllDistricts();
    @Query("SELECT d FROM District d WHERE d.districtId = :districtId")
    District findDistrictById(@Param("districtId") Integer districtId);

    @Query("SELECT d FROM District d WHERE d.districtName = :districtName")
    District findDistrictByName(@Param("districtName") String districtName);

}
