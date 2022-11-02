package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.repositories.SolicitacaoDeAnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoDeAnaliseService {
    @Autowired
    private SolicitacaoDeAnaliseRepository solicitacaoDeAnaliseRepository;

    public SolicitacaoDeAnalise cadastrarSolicitacaoDeAnalise(SolicitacaoDeAnalise solicitacaoDeAnalise){
        return solicitacaoDeAnaliseRepository.save(solicitacaoDeAnalise);
    }

    public List<SolicitacaoDeAnalise> retornarTodasSolicitacoesDeAnalise(){
        return solicitacaoDeAnaliseRepository.findAll();
    }
}
