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
 * Controlador que performa as operações de criar, retornar e atualizar dados da entidade ensaio
 */
@RestController
@RequestMapping("/ensaio")
public class EnsaioController {

    @Autowired
    private EnsaioService ensaioService;

    @Autowired
    private AmostraService amostraService;

    /**
     * Método HTTP que retorna uma lista de todos os ensaios cadastrados na base de dados
     * @return entidade de resposta com lista de ensaios
     */
    @GetMapping
    public ResponseEntity<List<Ensaio>> retornarTodosEnsaios(){
        List<Ensaio> ensaios = ensaioService.retornarTodosEnsaios();
        return ResponseEntity.ok().body(ensaios);
    }

    /**
     * Método HTTP que retorna um ensaio a partir de seu id
     * @param idEnsaio id do ensaio
     * @return entidade de resposta com o ensaio
     */
    @GetMapping("/{idEnsaio}")
    public ResponseEntity<Ensaio> retornarEnsaioPorId(@PathVariable Long idEnsaio){
        Ensaio ensaio = ensaioService.retornarEnsaioPorId(idEnsaio);
        return ResponseEntity.status(HttpStatus.OK).body(ensaio);
    }

    /**
     * Método HTTP que cadastra um ensaio na base de dados
     * @param ensaioDTO dados do ensaio a ser cadastrado
     * @return entidadde de resposta com o ensaio cadastrado
     */
    @PostMapping
    public ResponseEntity<Ensaio> cadastrarEnsaio(@RequestBody EnsaioDTO ensaioDTO){
        Ensaio ensaio = new Ensaio();
        Amostra amostra = amostraService.retornarAmostraPeloId(ensaioDTO.getIdAmostra());
        BeanUtils.copyProperties(ensaioDTO, ensaio);
        ensaio.setAmostra(amostra);
        ensaio = ensaioService.cadastrarEnsaio(ensaio);
        return ResponseEntity.status(HttpStatus.CREATED).body(ensaio);
    }

    /**
     * Método HTTP que cadastra o resultado do ensaio
     * @param idEnsaio id do ensaio que terá seu resultado informado
     * @param resultado resultado do ensaio
     * @return entidade de resposta com o ensaio atualizado
     */
    @PutMapping("/{idEnsaio}")
    public ResponseEntity<Ensaio> resultadoDoEnsaio(@PathVariable Long idEnsaio, @RequestBody String resultado){
        Ensaio ensaio = ensaioService.retornarEnsaioPorId(idEnsaio);
        ensaio.setResultadoDoEnsaio(resultado);
        ensaio = ensaioService.cadastrarEnsaio(ensaio);
        return ResponseEntity.status(HttpStatus.OK).body(ensaio);
    }
}
