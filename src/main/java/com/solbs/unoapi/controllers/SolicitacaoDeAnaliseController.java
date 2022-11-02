package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.services.SolicitacaoDeAnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitacao-de-analise")
public class SolicitacaoDeAnaliseController {
    @Autowired
    private SolicitacaoDeAnaliseService solicitacaoDeAnaliseService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoDeAnalise>> retornarTodosSolicitacaoDeAnalises(){
        List<SolicitacaoDeAnalise> lista = solicitacaoDeAnaliseService.retornarTodasSolicitacoesDeAnalise();
        return ResponseEntity.ok().body(lista);
    }
}
