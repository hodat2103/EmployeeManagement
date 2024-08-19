package com.example.demo.service.Impl;

import com.example.demo.domain.Commune;
import com.example.demo.domain.District;
import com.example.demo.domain.Province;
import com.example.demo.dto.CommuneDto;
import com.example.demo.dto.DistrictDto;
import com.example.demo.dto.ProvinceDto;
import com.example.demo.repository.CommuneRepository;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.ProvinceRepository;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private CommuneRepository communeRepository;
    @Override
    public List<ProvinceDto> getAllProvinces() {
        List<ProvinceDto> provinceDtoList = provinceRepository.getAllProvinces();
        if(provinceDtoList.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Province list is empty");

        return provinceDtoList;
    }

    @Override
    public ProvinceDto getProvinceById(Integer id) {
        Province province = provinceRepository.getById(id);
        if(province == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Province not found");
        return new ProvinceDto(province);
    }

    @Override
    public ProvinceDto create(ProvinceDto provinceDto) {
        Province province = new Province();
        province.setProvinceName(provinceDto.getProvinceName());

        List<District> districtList = new ArrayList<>();
        for (DistrictDto districtDto : provinceDto.getDistrictList()) {
            District district = new District();
//            district.setDistrictId(districtDto.getDistrictId());

            district.setDistrictName(districtDto.getDistrictName());
            district.setProvince(province);
            districtList.add(district);

            List<Commune> communeList = new ArrayList<>();
            if (districtDto.getCommuneList() != null) {
                for (CommuneDto communeDto : districtDto.getCommuneList()) {
                    Commune commune = new Commune();
                    commune.setCommuneName(communeDto.getCommuneName());
                    commune.setDistrict(district);
                    communeList.add(commune);
                }
            }

            district.setCommunes(communeList);
        }
        province.setDistricts(districtList);
        provinceRepository.save(province);
        return new ProvinceDto(province);
    }


    @Override
    public ProvinceDto update(Integer id, ProvinceDto provinceDto) {
        Province province = provinceRepository.getById(id);
        if (province == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Province not found");
        } else {
            province.setProvinceName(provinceDto.getProvinceName());


            for (DistrictDto districtDto : provinceDto.getDistrictList()) {
                District existsDistrict = districtRepository.findDistrictByName(districtDto.getDistrictName());
                System.out.println(districtDto.toString());

                if (existsDistrict != null || districtRepository.findDistrictById(existsDistrict.getDistrictId()).getProvince().getProvinceId() != id ) {

//                    District district = new District();
//
//                    district.setDistrictName(districtDto.getDistrictName());
//                    districtList.add(district);
//                    districtRepository.save(district);

                        existsDistrict.setDistrictName(districtDto.getDistrictName());

                    List<CommuneDto> communeDtoList = districtDto.getCommuneList();
                    for (CommuneDto communeDto : communeDtoList) {
                        CommuneDto existsCommune = communeRepository.getCommuneById(communeDto.getCommuneId());
                        if (existsCommune != null) {

                           existsCommune.setCommuneName(communeDto.getCommuneName());

                        }
                    }
                }

            }

        }
        provinceRepository.save(province);
        return new ProvinceDto(province);
    }

    @Override
    public ProvinceDto delete(Integer id) {
        Province province = provinceRepository.getById(id);
        if(province == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Province not found");
        List<District> districtList = province.getDistricts();
        for(District district : districtList){
            List<Commune> communeList = district.getCommunes();
            if(!communeList.isEmpty()){
                communeList.clear();
            }
            districtList.remove(district);
        }
        provinceRepository.delete(province);
        return new ProvinceDto(province);
    }
}
