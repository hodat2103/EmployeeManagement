package com.example.demo.dto;

import com.example.demo.domain.Certificate;
import com.example.demo.domain.CertificateEmployee;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Province;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateEmployeeDto {
    private int id;
    private Employee employee;
    private Certificate certificate;
    private Province province;

    public CertificateEmployeeDto(CertificateEmployee certificateEmployee){
        if(certificateEmployee != null){
            this.setId(certificateEmployee.getId());
            this.setEmployee(certificateEmployee.getEmployee());
            this.setCertificate(certificateEmployee.getCertificate());
            this.setProvince(certificateEmployee.getProvince());
        }
    }
}
