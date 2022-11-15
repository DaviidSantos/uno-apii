package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.repositories.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AmostraService {
    @Autowired
    private AmostraRepository amostraRepository;

    /**
     * Método que retorna todas as amostras cadastradas
     * @return lista de amostras
     */
    public List<Amostra> findAll(){
        return amostraRepository.findAll();
    }

    /**
     * Método que retorna uma amostra a partir do id
     * @param idAmostra id da amostra
     * @return amostra
     */
    public Amostra findById(String idAmostra) {
        return amostraRepository.findById(idAmostra).get();
    }

    /**
     * Método que salva uma amostra na base de dados
     * @param amostra amostra a ser salva
     * @return amostra salva
     */
    @Transactional
    public Amostra save(Amostra amostra){
        return amostraRepository.save(amostra);
    }

    /**
     * Método que retorna todas as amostras com status: análise finalizada
     * @return lista de amostras com analise finalizada
     */
    public List<Amostra> findAmostraAnaliseFinalizada() {
        return amostraRepository.findAmostrasAnaliseFinalizada();
    }

    /**
     * Método que retorna todas as amostras com status: em análise
     * @return lista de amostras em análise
     */
    public List<Amostra> findAmostraEmAnalise(){
        return amostraRepository.findAmostraEmAnalise();
    }

    /**
     * Método que retorna todas as amostras com status: aguardando análise
     * @return lista de amostras aguardando análise
     */
    public List<Amostra> findAmostraAguardandoAnalise() {
        return amostraRepository.findAmostraAguardandoAnalise();
    }

    public List<Amostra> findAmostraEmFalta() {
        return amostraRepository.findAmostraEmFalta();
    }
}
