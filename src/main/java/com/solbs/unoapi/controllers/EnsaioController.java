package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.services.EnsaioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ensaio")
public class EnsaioController {

    @Autowired
    private EnsaioService ensaioService;

    @GetMapping
    public ResponseEntity<List<Ensaio>> retornarTodosEnsaios(){
        List<Ensaio> ensaios = ensaioService.retornarTodosEnsaios();
        return ResponseEntity.ok().body(ensaios);
    }
}
