package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.services.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {
    @Autowired
    private SolicitanteService solicitanteService;

    @GetMapping
    public ResponseEntity<List<Solicitante>> retornarTodosSolicitantes(){
        List<Solicitante> lista = solicitanteService.retornarTodosSolicitantes();
        return ResponseEntity.ok().body(lista);
    }
}
