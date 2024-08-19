package com.example.demo.service.Impl;

import com.example.demo.domain.Commune;
import com.example.demo.dto.CommuneDto;
import com.example.demo.repository.CommuneRepository;
import com.example.demo.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommuneServiceImpl implements CommuneService {
    @Autowired
    private CommuneRepository communeRepository;

    @Override
    public List<CommuneDto> getAllCommunes() {
        List<CommuneDto> communeDtoList = communeRepository.getAllCommunes();

        if(communeDtoList.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Commune list is empty");

        return communeDtoList;
    }

    @Override
    public CommuneDto getCommuneById(Integer id) {
        Commune commune = communeRepository.getById(id);
        if(commune == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Commune not found");
        return new CommuneDto(commune);
    }

    @Override
    public CommuneDto create(CommuneDto communeDto) {
        Commune commune = new Commune();

        commune.setCommuneName(communeDto.getCommuneName());

        communeRepository.save(commune);
        return new CommuneDto(commune);
    }

    @Override
    public CommuneDto update(Integer id, CommuneDto communeDto) {
        Commune commune = communeRepository.getById(id);
        if(commune == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Commune not found");

        commune.setCommuneName(communeDto.getCommuneName());

        communeRepository.save(commune);
        return new CommuneDto(commune);
    }

    @Override
    public CommuneDto delete(Integer id) {
        Commune commune = communeRepository.getById(id);
        if(commune == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Commune not found");
        communeRepository.delete(commune);
        return new CommuneDto(commune);
    }
}
