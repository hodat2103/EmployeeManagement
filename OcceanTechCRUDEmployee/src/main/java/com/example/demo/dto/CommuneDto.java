package com.example.demo.dto;

import com.example.demo.domain.Commune;
import com.example.demo.domain.District;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CommuneDto {
    private int communeId;
    private String communeName;
    private int  districtId;
    private String districtName;
    public CommuneDto(Commune commune){
        if(commune != null){
            this.setCommuneId(commune.getCommuneId());
            this.setCommuneName(commune.getCommuneName());
            if(commune.getDistrict() != null){
                this.districtId = commune.getDistrict().getDistrictId();
                this.districtName = commune.getDistrict().getDistrictName();
            }

        }
    }
}
