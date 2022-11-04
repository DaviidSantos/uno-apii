package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.repositories.EnsaioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de service da entidade Ensaio, utilizada pra se comunicar com a base de dados
 */
@Service
public class EnsaioService {
    @Autowired
    private EnsaioRepository ensaioRepository;

    public List<Ensaio> retornarTodosEnsaios(){
        return ensaioRepository.findAll();
    }

    public Ensaio retornarEnsaioPorId(Long id) {
        return ensaioRepository.findById(id).get();
    }

    public Ensaio cadastrarEnsaio(Ensaio ensaio) {
        return ensaioRepository.save(ensaio);
    }
}
