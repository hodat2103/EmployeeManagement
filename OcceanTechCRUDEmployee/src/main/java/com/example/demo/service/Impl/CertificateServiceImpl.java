package com.example.demo.service.Impl;

import com.example.demo.domain.Certificate;
import com.example.demo.dto.CertificateDto;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    private CertificateRepository certificateRepository;
    @Override
    public List<CertificateDto> getAllCertificates() {
        List<CertificateDto> certificateDtoList = certificateRepository.getAllCertificates();
        if(certificateDtoList.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Certificate list is empty");

        return certificateDtoList;
    }

    @Override
    public CertificateDto getCertificateById(Integer id) {
        Certificate certificate = certificateRepository.getById(id);
        if(certificate == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Certificate not found");

        return new CertificateDto(certificate);
    }

    @Override
    public CertificateDto create(CertificateDto certificateDto) {
        Certificate certificate = new Certificate();

        certificate.setCertificateName(certificateDto.getCertificateName());
        certificate.setDateStart(certificateDto.getDateStart());
        certificate.setDateEnd(certificateDto.getDateEnd());
        certificate.setActive(certificateDto.isActive());

        certificateRepository.save(certificate);
        return new CertificateDto(certificate);
    }

    @Override
    public CertificateDto update(Integer id, CertificateDto certificateDto) {
        Certificate certificate = certificateRepository.getById(id);
        if(certificate == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Certificate not found");

        certificate.setCertificateName(certificateDto.getCertificateName());
        certificate.setDateStart(certificateDto.getDateStart());
        certificate.setDateEnd(certificateDto.getDateEnd());
        certificate.setActive(certificateDto.isActive());

        certificateRepository.save(certificate);
        return new CertificateDto(certificate);
    }

    @Override
    public CertificateDto delete(Integer id) {
        Certificate certificate = certificateRepository.getById(id);
        if(certificate == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Certificate not found");
        certificateRepository.delete(certificate);

        return new CertificateDto(certificate);
    }
}
