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

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/solicitacao-de-analise")
public class SolicitacaoDeAnaliseController {
    @Autowired
    private SolicitacaoDeAnaliseService solicitacaoDeAnaliseService;

    @Autowired
    private SolicitanteService solicitanteService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoDeAnalise>> retornarTodosSolicitacaoDeAnalises(){
        List<SolicitacaoDeAnalise> lista = solicitacaoDeAnaliseService.retornarTodasSolicitacoesDeAnalise();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<SolicitacaoDeAnalise> cadastrarSolicitacaoDeAnalise(@RequestBody SolicitacaoDeAnaliseDTO solicitacaoDeAnaliseDTO){
        SolicitacaoDeAnalise solicitacaoDeAnalise = new SolicitacaoDeAnalise();
        BeanUtils.copyProperties(solicitacaoDeAnaliseDTO, solicitacaoDeAnalise);
        Solicitante solicitante = new Solicitante();
        solicitante = solicitanteService.retornarSolicitantePorCnpj(solicitacaoDeAnaliseDTO.getCnpj());
        solicitacaoDeAnalise.setSolicitante(solicitante);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoDeAnaliseService.cadastrarSolicitacaoDeAnalise(solicitacaoDeAnalise));
    }
}
