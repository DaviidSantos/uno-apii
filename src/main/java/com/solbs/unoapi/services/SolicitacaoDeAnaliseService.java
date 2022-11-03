package com.solbs.unoapi.services;

import com.solbs.unoapi.dtos.SolicitacaoDeAnaliseDTO;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.repositories.SolicitacaoDeAnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoDeAnaliseService {
    @Autowired
    private SolicitacaoDeAnaliseRepository solicitacaoDeAnaliseRepository;

    @Autowired
    private SolicitanteService solicitanteService;

    public SolicitacaoDeAnalise cadastrarSolicitacaoDeAnalise(SolicitacaoDeAnalise solicitacaoDeAnalise){
        return solicitacaoDeAnaliseRepository.save(solicitacaoDeAnalise);
    }

    public List<SolicitacaoDeAnalise> retornarTodasSolicitacoesDeAnalise(){
        return solicitacaoDeAnaliseRepository.findAll();
    }

    public SolicitacaoDeAnalise retornarSolicitacaoDeAnalisePorId(Long idSA) {
        return solicitacaoDeAnaliseRepository.findById(idSA).get();
    }

    public SolicitacaoDeAnalise atualizarDados(SolicitacaoDeAnalise solicitacaoDeAnalise, SolicitacaoDeAnaliseDTO solicitacaoDeAnaliseDTO) {
        if(solicitacaoDeAnaliseDTO.getTipoDeAnalise() != null){
            solicitacaoDeAnalise.setTipoDeAnalise(solicitacaoDeAnaliseDTO.getTipoDeAnalise());
        }

        if(solicitacaoDeAnaliseDTO.getConsideracoesGerais() != null){
            solicitacaoDeAnalise.setConsideracoesGerais(solicitacaoDeAnaliseDTO.getConsideracoesGerais());
        }

        if (solicitacaoDeAnaliseDTO.getInformacoesGerais() != null){
            solicitacaoDeAnalise.setInformacoesGerais(solicitacaoDeAnaliseDTO.getInformacoesGerais());
        }

        return solicitacaoDeAnalise;
    }
}
