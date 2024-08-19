package com.example.demo.dto;

import com.example.demo.domain.District;
import com.example.demo.domain.Province;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProvinceDto {
    private  int provinceId;
    private String provinceName;
    private List<DistrictDto> districtList;
    public ProvinceDto(Province province){
        if(province != null){
            this.setProvinceId(province.getProvinceId());
            this.setProvinceName(province.getProvinceName());
            if(province.getDistricts() != null){
                this.districtList = new ArrayList<>();
                for (District district : province.getDistricts()){
                    DistrictDto districtDto = new DistrictDto(district);
                    this.districtList.add(districtDto);

                }
            }
        }
    }
}
