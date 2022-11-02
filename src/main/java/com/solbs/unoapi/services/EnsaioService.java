package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.repositories.EnsaioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnsaioService {
    @Autowired
    private EnsaioRepository ensaioRepository;

    public List<Ensaio> retornarTodosEnsaios(){
        return ensaioRepository.findAll();
    }
}
