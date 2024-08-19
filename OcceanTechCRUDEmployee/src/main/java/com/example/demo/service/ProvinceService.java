package com.example.demo.service;

import com.example.demo.dto.ProvinceDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProvinceService {
    List<ProvinceDto> getAllProvinces();
    ProvinceDto getProvinceById(Integer id);
    ProvinceDto create(ProvinceDto provinceDto);
    ProvinceDto update(Integer id, ProvinceDto provinceDto);
    ProvinceDto delete(Integer id);
}
