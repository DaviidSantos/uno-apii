package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.services.SolicitanteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {
    @Autowired
    private SolicitanteService solicitanteService;

    /**
     * Método HTTP que retorna todos os solicitantes cadastrados
     * @return Lista com todos Solicitantes
     */
    @GetMapping
    public ResponseEntity<List<Solicitante>> retornarTodosSolicitantes(){
        List<Solicitante> lista = solicitanteService.retornarTodosSolicitantes();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    /**
     * Método HTTP que retorna um solicitante a partir de seu cnpj
     * @param cnpj cnpj que será buscado na base de dados
     * @return solicitante
     */
    @GetMapping("/{cnpj}")
    public ResponseEntity<Solicitante> retornarSolicitantePorCnpj(@PathVariable String cnpj){
        return ResponseEntity.status(HttpStatus.OK).body(solicitanteService.retornarSolicitantePorCnpj(cnpj));
    }

    /**
     * Método HTTP que cadastra um solicitante na base de dados
     * @param solicitante objeto solicitante que será cadastrado na base de dados
     * @return Entidade de resposta HTTP
     */
    @PostMapping
    public ResponseEntity<Solicitante> cadastrarSolicitante(@RequestBody Solicitante solicitante){
        Solicitante obj = new Solicitante();
        BeanUtils.copyProperties(solicitante, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitanteService.cadastrarSolicitante(solicitante));
    }

    /**
     * Método HTTP que atualiza dados cadastrais de um solicitante
     * @param cnpj cnpj do solicitante que terá dados atualizados
     * @param dados dados que serão atualizados no solicitante
     * @return Entidade de resposta HTTP
     */
    @PutMapping("/{cnpj}")
    public ResponseEntity<Object> atualizarSolicitante(@PathVariable String cnpj, @RequestBody Solicitante dados){
        Solicitante solicitante = solicitanteService.retornarSolicitantePorCnpj(cnpj);
        solicitante = solicitanteService.atualizarDados(solicitante, dados);
        return ResponseEntity.status(HttpStatus.OK).body(solicitanteService.cadastrarSolicitante(solicitante));
    }
}
