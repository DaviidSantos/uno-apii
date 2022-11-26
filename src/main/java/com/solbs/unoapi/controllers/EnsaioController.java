package com.solbs.unoapi.controllers;

import com.solbs.unoapi.dtos.EnsaioDTO;
import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.services.AmostraService;
import com.solbs.unoapi.services.EnsaioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador da entidade ensaio
 */
@RestController
@RequestMapping("/ensaio")
@CrossOrigin("*")
public class EnsaioController {

    @Autowired
    private EnsaioService ensaioService;

    @Autowired
    private AmostraService amostraService;

    /**
     * Método HTTP que retorna uma lista de todos os ensaios cadastrados na base de dados
     * @return Entidade de resposta com lista de ensaios
     */
    @GetMapping
    public ResponseEntity<List<Ensaio>> retornarTodosEnsaios(){
        List<Ensaio> ensaios = ensaioService.findAll();
        return ResponseEntity.ok().body(ensaios);
    }

    /**
     * Método HTTP que retorna um ensaio a partir de seu id
     * @param idEnsaio Id do ensaio
     * @return Entidade de resposta com o ensaio
     */
    @GetMapping("/{idEnsaio}")
    public ResponseEntity<Ensaio> retornarEnsaioPorId(@PathVariable String idEnsaio){
        Ensaio ensaio = ensaioService.findById(idEnsaio);
        return ResponseEntity.status(HttpStatus.OK).body(ensaio);
    }

    @GetMapping("/por-amostra/{idAmostra}")
    public ResponseEntity<List<Ensaio>> retornarEnsaioPorAmostra(@PathVariable Long idAmostra){
        return ResponseEntity.status(HttpStatus.OK).body(ensaioService.findEnsaioByAmostra(idAmostra));
    }


    /**
     * Método HTTP que cadastra um ensaio na base de dados
     * @param ensaioDTO Dados do ensaio a ser cadastrado
     * @return Entidadde de resposta com o ensaio cadastrado
     */
    @PostMapping
    public ResponseEntity<Ensaio> cadastrarEnsaio(@RequestBody EnsaioDTO ensaioDTO){
        Ensaio ensaio = new Ensaio();
        Amostra amostra = amostraService.findById(ensaioDTO.getAmostra());
        BeanUtils.copyProperties(ensaioDTO, ensaio);
        ensaio.setAmostra(amostra);
        ensaio = ensaioService.save(ensaio);
        return ResponseEntity.status(HttpStatus.CREATED).body(ensaio);
    }

    /**
     * Método HTTP que cadastra o resultado do ensaio
     * @param resultado Resultado do ensaio
     * @return Entidade de resposta com o ensaio atualizado
     */
    @PutMapping("/{idEnsaio}")
    public ResponseEntity<Ensaio> resultadoDoEnsaio(@PathVariable String idEnsaio, @RequestBody EnsaioDTO resultado){
        Ensaio ensaio = ensaioService.findById(idEnsaio);
        ensaio.setResultadoDoEnsaio(resultado.getResultadoDoEnsaio());
        ensaio = ensaioService.save(ensaio);
        return ResponseEntity.status(HttpStatus.OK).body(ensaio);
    }
}
