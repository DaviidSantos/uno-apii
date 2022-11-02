package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.repositories.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmostraService {
    @Autowired
    private AmostraRepository amostraRepository;

    public List<Amostra> retornarTodasAmostras(){
        return amostraRepository.findAll();
    }
}
