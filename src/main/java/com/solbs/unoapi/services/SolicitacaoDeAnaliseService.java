package com.solbs.unoapi.services;

import com.solbs.unoapi.dtos.SolicitacaoDeAnaliseDTO;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.repositories.SolicitacaoDeAnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class SolicitacaoDeAnaliseService {
    @Autowired
    private SolicitacaoDeAnaliseRepository solicitacaoDeAnaliseRepository;

    @Autowired
    private SolicitanteService solicitanteService;

    /**
     * Método que retorna uma lista com todas as Solicitações de Análise
     * @return Lista de Solicitações de Análise
     */
    public List<SolicitacaoDeAnalise> findAll(){
        return solicitacaoDeAnaliseRepository.findAll();
    }

    /**
     * Método que retorna uma Solicitação de Análise a partir de seu ID
     * @param idSA ID da Solicitação de Análise
     * @return Solicitação de Análise
     */
    public SolicitacaoDeAnalise findById(String idSA) {
        return solicitacaoDeAnaliseRepository.findById(idSA).get();
    }

    /**
     * Método que salva uma solicitação de análise na base de dados
     * @param solicitacaoDeAnalise Solicitação a ser salva na base de dados
     * @return Solicitação salva
     */
    @Transactional
    public SolicitacaoDeAnalise save(SolicitacaoDeAnalise solicitacaoDeAnalise){
        return solicitacaoDeAnaliseRepository.save(solicitacaoDeAnalise);
    }

    /**
     * Método que retorna uma lista de Solicitações de Análise de um solicitante
     * @param solicitante Solicitante das Solicitações de Análise
     * @return Lista de Solicitações de Análise
     */
    public List<SolicitacaoDeAnalise> findSolicitacaoDeAnaliseBySolicitante(Solicitante solicitante){
        return solicitacaoDeAnaliseRepository.findSolicitacaoDeAnaliseBySolicitante(solicitante);
    }

    /**
     * Método que atualiza os dados de uma Solicitação de Análise
     * @param solicitacaoDeAnalise Solicitação de Análise que terá os dados atualizados
     * @param solicitacaoDeAnaliseDTO Dados que serão atualizados na Solicitação de Análise
     * @return Solicitação de Análise Atualizada
     */
    public SolicitacaoDeAnalise updateData(SolicitacaoDeAnalise solicitacaoDeAnalise, SolicitacaoDeAnaliseDTO solicitacaoDeAnaliseDTO) {
        if(solicitacaoDeAnaliseDTO.getTipoDeAnalise() != null){
            solicitacaoDeAnalise.setTipoDeAnalise(solicitacaoDeAnaliseDTO.getTipoDeAnalise());
        }

        if(solicitacaoDeAnaliseDTO.getConsideracoesGerais() != null){
            solicitacaoDeAnalise.setConsideracoesGerais(solicitacaoDeAnaliseDTO.getConsideracoesGerais());
        }

        if (solicitacaoDeAnaliseDTO.getInformacoesAdicionais() != null){
            solicitacaoDeAnalise.setInformacoesAdicionais(solicitacaoDeAnaliseDTO.getInformacoesAdicionais());
        }

        return solicitacaoDeAnalise;
    }
}
