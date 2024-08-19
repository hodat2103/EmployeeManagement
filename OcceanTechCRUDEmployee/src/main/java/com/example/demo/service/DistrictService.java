package com.example.demo.service;

import com.example.demo.dto.DistrictDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DistrictService {
    List<DistrictDto> getAllDistricts();
    DistrictDto getDistrictById(Integer id);
    DistrictDto create(DistrictDto districtDto);
    DistrictDto update(Integer id, DistrictDto districtDto);
    DistrictDto delete(Integer id);
}
