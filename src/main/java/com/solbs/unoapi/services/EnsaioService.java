package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.repositories.EnsaioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EnsaioService {
    @Autowired
    private EnsaioRepository ensaioRepository;

    /**
     * Método que retorna uma lista com todos os ensaios cadastrados
     * @return Lista de ensaios
     */
    public List<Ensaio> findAll(){
        return ensaioRepository.findAll();
    }

    /**
     * Método que retorna um ensaio a partir de seu id
     * @param id Id do ensaio
     * @return Ensaio
     */
    public Ensaio findById(Long id) {
        return ensaioRepository.findById(id).get();
    }

    /**
     * Método que salva o ensaio na base de dados
     * @param ensaio Ensaio a ser salvo
     * @return Ensaio salvo
     */
    @Transactional
    public Ensaio save(Ensaio ensaio) {
        return ensaioRepository.save(ensaio);
    }

    public List<Ensaio> findEnsaioByAmostra(Long idAmostra) {
        return ensaioRepository.findEnsaioByAmostra(idAmostra);
    }
}
