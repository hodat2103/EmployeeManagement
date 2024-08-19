package com.example.demo.dto;

import com.example.demo.domain.Certificate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto {
   private int certificateId;
   private String certificateName;
   private LocalDate dateStart;
   private LocalDate dateEnd;
   private boolean active;

    public CertificateDto(Certificate certificate){
            if(certificate != null){
                this.setCertificateId(certificate.getCertificateId());
                this.setCertificateName(certificate.getCertificateName());
                this.setDateStart(certificate.getDateStart());
                this.setDateEnd(certificate.getDateEnd());
                this.setActive(certificate.isActive());
            }
        }


}
