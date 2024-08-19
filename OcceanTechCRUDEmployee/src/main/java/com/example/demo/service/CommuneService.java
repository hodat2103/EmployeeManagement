package com.example.demo.service;

import com.example.demo.dto.CommuneDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommuneService {
    List<CommuneDto> getAllCommunes();

    CommuneDto getCommuneById(Integer id);
    CommuneDto create(CommuneDto communeDto);
    CommuneDto update(Integer id, CommuneDto communeDto);
    CommuneDto delete(Integer id);
}
