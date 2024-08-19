package com.example.demo.dto;

import com.example.demo.domain.Commune;
import com.example.demo.domain.District;
import com.example.demo.domain.Province;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {
    private int districtId;
    private String districtName;
    private int provinceId;
    private String provinceName;
    private List<CommuneDto> communeList;
    public DistrictDto(District district){
        if(district != null){
            this.setDistrictId(district.getDistrictId());
            this.setDistrictName(district.getDistrictName());
            if(district.getProvince() != null){
                this.provinceId = district.getProvince().getProvinceId();
                this.provinceName = district.getProvince().getProvinceName();
            }
            if(district.getCommunes() != null){
                this.communeList = new ArrayList<>();
                for (Commune commune : district.getCommunes()){
                    CommuneDto communeDto = new CommuneDto(commune);
                    this.communeList.add(communeDto);
                }
            }

        }
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<CommuneDto> getCommuneList() {
        return communeList;
    }

    public void setCommuneList(List<CommuneDto> communeList) {
        this.communeList = communeList;
    }

    @Override
    public String toString() {
        return "DistrictDto{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", communeList=" + communeList +
                '}';
    }
}
