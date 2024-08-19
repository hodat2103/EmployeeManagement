package com.example.demo.service.Impl;

import com.example.demo.domain.District;
import com.example.demo.dto.DistrictDto;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.ProvinceRepository;
import com.example.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public List<DistrictDto> getAllDistricts() {
        List<DistrictDto> districtDtoList = districtRepository.getAllDistricts();;

        if(districtDtoList.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"District list is empty");



        return districtDtoList;
    }

    @Override
    public DistrictDto getDistrictById(Integer id) {
        District district = districtRepository.getById(id);
        if(district == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"District not found");

        return new DistrictDto(district);
    }

    @Override
    public DistrictDto create(DistrictDto districtDto) {
        District district = new District();

        district.setDistrictName(districtDto.getDistrictName());
        district.setProvince(provinceRepository.getById(districtDto.getProvinceId()));
        districtRepository.save(district);
        return new DistrictDto(district);
    }

    @Override
    public DistrictDto update(Integer id, DistrictDto districtDto) {
        District district = districtRepository.getById(id);
        if(district == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"District not found");

        district.setDistrictName(districtDto.getDistrictName());
        district.setProvince(provinceRepository.getById(districtDto.getProvinceId()));
        districtRepository.save(district);
        return new DistrictDto(district);
    }

    @Override
    public DistrictDto delete(Integer id) {
        District district = districtRepository.getById(id);
        if(district == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"District not found");

        districtRepository.delete(district);
        return new DistrictDto(district);
    }
}
