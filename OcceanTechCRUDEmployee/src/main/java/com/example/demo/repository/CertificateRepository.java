package com.example.demo.repository;

import com.example.demo.domain.Certificate;
import com.example.demo.dto.CertificateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    @Query("SELECT new com.example.demo.dto.CertificateDto(cd) FROM Certificate  cd")
    List<CertificateDto> getAllCertificates();

}
