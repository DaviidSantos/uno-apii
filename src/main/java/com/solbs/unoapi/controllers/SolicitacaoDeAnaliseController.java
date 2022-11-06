package com.solbs.unoapi.controllers;

import com.solbs.unoapi.dtos.SolicitacaoDeAnaliseDTO;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.services.SolicitacaoDeAnaliseService;
import com.solbs.unoapi.services.SolicitanteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador da entidade Solicitação de Análise
 */
@RestController
@RequestMapping("/solicitacao-de-analise")
public class SolicitacaoDeAnaliseController {
    @Autowired
    private SolicitacaoDeAnaliseService solicitacaoDeAnaliseService;

    @Autowired
    private SolicitanteService solicitanteService;

    /**
     * Método HTTP que retorna uma lista de Solicitações de Análise
     * @return Entidade de resposta com a lista de Solicitações de Análise
     */
    @GetMapping
    public ResponseEntity<List<SolicitacaoDeAnalise>> retornarTodosSolicitacaoDeAnalises(){
        List<SolicitacaoDeAnalise> lista = solicitacaoDeAnaliseService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    /**
     * Método HTTP que retorna uma Solicitação de Análise a partir de seu id
     * @param idSA Id da Solicitação de Análise a ser retornada
     * @return Entidade de resposta com a solicitação de análise retornada
     */
    @GetMapping("/{idSA}")
    public ResponseEntity<SolicitacaoDeAnalise> retornarSolicitacaoDeAnalisePorId(@PathVariable Long idSA){
        SolicitacaoDeAnalise solicitacaoDeAnalise = solicitacaoDeAnaliseService.findById(idSA);
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoDeAnalise);
    }

    /**
     * Método HTTP que cadastra uma Solicitação de Análise na base de dados
     * @param solicitacaoDeAnaliseDTO Dados da Solicitação de Análise a ser cadastrada
     * @return Entidade de resposta com a solicitação de análise cadastrada
     */
    @PostMapping
    public ResponseEntity<SolicitacaoDeAnalise> cadastrarSolicitacaoDeAnalise(@RequestBody SolicitacaoDeAnaliseDTO solicitacaoDeAnaliseDTO){
        SolicitacaoDeAnalise solicitacaoDeAnalise = new SolicitacaoDeAnalise();
        BeanUtils.copyProperties(solicitacaoDeAnaliseDTO, solicitacaoDeAnalise);
        Solicitante solicitante = new Solicitante();
        solicitante = solicitanteService.findByCNPJ(solicitacaoDeAnaliseDTO.getCnpj());
        solicitacaoDeAnalise.setSolicitante(solicitante);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoDeAnaliseService.save(solicitacaoDeAnalise));
    }

    /**
     * Método HTTP que atualiza dados da Solicitação de Análise
     * @param idSA id da Solicitação que será atualizada
     * @param solicitacaoDeAnaliseDTO dados que serão atualizados na Solicitação de Análise
     * @return Entidade de resposta com a Solicitação de Análise atualizada
     */
    @PutMapping("/{idSA}")
    public ResponseEntity<SolicitacaoDeAnalise> atualizarSolicitacaoDeAnalise(@PathVariable Long idSA, @RequestBody SolicitacaoDeAnaliseDTO solicitacaoDeAnaliseDTO){
        SolicitacaoDeAnalise solicitacaoDeAnalise = solicitacaoDeAnaliseService.findById(idSA);
        solicitacaoDeAnalise = solicitacaoDeAnaliseService.updateData(solicitacaoDeAnalise, solicitacaoDeAnaliseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoDeAnaliseService.save(solicitacaoDeAnalise));
    }
}
