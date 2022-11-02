package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.services.AmostraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amostra")
public class AmostraController {

    @Autowired
    private AmostraService amostraService;

    @GetMapping
    public ResponseEntity<List<Amostra>> retornarTodasAmostras(){
        List<Amostra> amostras = amostraService.retornarTodasAmostras();
        return ResponseEntity.ok().body(amostras);
    }
}
