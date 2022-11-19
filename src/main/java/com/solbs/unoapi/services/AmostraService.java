package com.solbs.unoapi.services;

import com.solbs.unoapi.dtos.QuantidadeStatusAmostra;
import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.repositories.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AmostraService {
    @Autowired
    private AmostraRepository amostraRepository;

    /**
     * Método que retorna todas as amostras cadastradas
     * @return Lista de amostras
     */
    public List<Amostra> findAll(){
        return amostraRepository.findAll();
    }

    /**
     * Método que retorna uma amostra a partir do id
     * @param idAmostra Id da amostra
     * @return Amostra
     */
    public Amostra findById(String idAmostra) {
        return amostraRepository.findById(idAmostra).get();
    }

    /**
     * Método que salva uma amostra na base de dados
     * @param amostra Amostra a ser salva
     * @return Amostra salva
     */
    @Transactional
    public Amostra save(Amostra amostra){
        return amostraRepository.save(amostra);
    }

    /**
     * Método que retorna todas as amostras com status: análise finalizada
     * @return Lista de amostras com analise finalizada
     */
    public List<Amostra> findAmostraAnaliseFinalizada() {
        return amostraRepository.findAmostrasAnaliseFinalizada();
    }

    /**
     * Método que retorna todas as amostras com status: em análise
     * @return Lista de amostras em análise
     */
    public List<Amostra> findAmostraEmAnalise(){
        return amostraRepository.findAmostraEmAnalise();
    }

    /**
     * Método que retorna todas as amostras com status: aguardando análise
     * @return Lista de amostras aguardando análise
     */
    public List<Amostra> findAmostraAguardandoAnalise() {
        return amostraRepository.findAmostraAguardandoAnalise();
    }

    /**
     * Método que retorna todas as amostras com status: em falta
     * @return Lista de amostras em falta
     */
    public List<Amostra> findAmostraEmFalta() {
        return amostraRepository.findAmostraEmFalta();
    }

    /**
     * Método que retorna a quatidade de amostras em cada Status
     * @return QuantidadeStatusAmostra
     */
    public QuantidadeStatusAmostra retornarQuantidadeAmostraPorStatus(){
        QuantidadeStatusAmostra quantidadeStatusAmostra = new QuantidadeStatusAmostra();
        quantidadeStatusAmostra.setAmostraFinalizada(amostraRepository.quantidadeFinalizada());
        quantidadeStatusAmostra.setAmostraEmAnalise(amostraRepository.quantidadeEmAnalise());
        quantidadeStatusAmostra.setAmostraAguardandoAnalise(amostraRepository.quantidadeAguardandoAnalise());
        return quantidadeStatusAmostra;
    }
}
