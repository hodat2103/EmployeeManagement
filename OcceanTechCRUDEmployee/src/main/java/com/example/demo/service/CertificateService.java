package com.example.demo.service;

import com.example.demo.dto.CertificateDto;
import com.example.demo.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CertificateService {
    List<CertificateDto> getAllCertificates();

    CertificateDto getCertificateById(Integer id);
    CertificateDto create(CertificateDto certificateDto);
    CertificateDto update(Integer id, CertificateDto certificateDto);
    CertificateDto delete(Integer id);

}
