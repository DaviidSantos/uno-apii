package com.solbs.unoapi.controllers;

import com.solbs.unoapi.dtos.AmostraDTO;
import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.enums.StatusAmostra;
import com.solbs.unoapi.services.AmostraService;
import com.solbs.unoapi.services.SolicitacaoDeAnaliseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

/**
 * Controlador da entidade amostra
 */
@RestController
@RequestMapping("/amostra")
@CrossOrigin("*")
public class AmostraController {

    @Autowired
    private AmostraService amostraService;

    @Autowired
    private SolicitacaoDeAnaliseService solicitacaoDeAnaliseService;


    /**
     * Método HTTP que retorna uma lista com todas as amostras na base de dados
     * @return Entidade de resposta com a lista com amostras
     */
    @GetMapping
    public ResponseEntity<List<Amostra>> findAllAmostras(){
        List<Amostra> amostras = amostraService.findAll();
        return ResponseEntity.ok().body(amostras);
    }


    /**
     * Método HTTP que retorna uma amostra a partir do id
     * @param idAmostra id da amostra a ser retornada
     * @return Entidade de resposta com a amostra
     */
    @GetMapping("/{idAmostra}")
    public ResponseEntity<Amostra> findById(@PathVariable Long idAmostra){
        Amostra amostra = amostraService.findById(idAmostra);
        return ResponseEntity.status(HttpStatus.OK).body(amostra);
    }

    /**
     * Método HTTP que cadastra uma amostra na base de dados
     * @param amostraDTO dados da amostra a ser cadastrada
     * @return Entidade de resposta com a amostra cadastrada
     */
    @PostMapping
    public ResponseEntity<Amostra> saveAmostra(@RequestBody AmostraDTO amostraDTO){
        Amostra amostra = new Amostra();
        SolicitacaoDeAnalise solicitacaoDeAnalise = solicitacaoDeAnaliseService.findById(amostraDTO.getSolicitacaoDeAnalise());
        BeanUtils.copyProperties(amostraDTO, amostra);
        StatusAmostra statusAmostra = StatusAmostra.valor(amostraDTO.getStatusAmostra());
        amostra.setStatusAmostra(statusAmostra);
        amostra.setSolicitacaoDeAnalise(solicitacaoDeAnalise);
        amostra.setDataDeEntrada(Instant.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(amostraService.save(amostra));
    }

    /**
     * Método HTTP que atualiza o Status da amostra
     * @param idAmostra id da amostra que terá o status atualizado
     * @param status código int do novo status
     * @return Entidade de resposta com a amostra atualizada
     */
    @PutMapping("/{idAmostra}")
    public ResponseEntity<Amostra> updateStatusAmostra(@PathVariable Long idAmostra, @RequestBody int status){
        Amostra amostra = amostraService.findById(idAmostra);
        StatusAmostra statusAmostra = StatusAmostra.valor(status);
        amostra.setStatusAmostra(statusAmostra);
        return ResponseEntity.status(HttpStatus.OK).body(amostraService.save(amostra));
    }

    /**
     * Método HTTP que retorna uma lista de amostras com analises concluídas
     * @return entidade de resposta com lista de amostras
     */
    @GetMapping("/concluido")
    public ResponseEntity<List<Amostra>> findAmostraConcluida(){
        List<Amostra> amostrasConcluidas = amostraService.findAmostraAnaliseFinalizada();
        return ResponseEntity.status(HttpStatus.OK).body(amostrasConcluidas);
    }

    /**
     * Método HTTP que retorna uma lista com amostras em análise
     * @return entidade de resposta com lista de amostras
     */
    @GetMapping("/em-analise")
    public ResponseEntity<List<Amostra>> findAmostraEmAnalise(){
        List<Amostra> amostrasEmAnalise = amostraService.findAmostraEmAnalise();
        return ResponseEntity.status(HttpStatus.OK).body(amostrasEmAnalise);
    }

    /**
     * Método HTTP que retorna uma lista com amostras aguardando análise
     * @return Entidade de resposta com lista de amostras
     */
    @GetMapping("/aguardando-analise")
    public ResponseEntity<List<Amostra>> findAmostraAguardandoAnalise(){
        List<Amostra> amostrasAguardandoAnalise = amostraService.findAmostraAguardandoAnalise();
        return ResponseEntity.status(HttpStatus.OK).body(amostrasAguardandoAnalise);
    }

    /**
     * Método HTTP que retorna uma lista de amostras em falta
     * @return Entidade de resposta com lista de amostras
     */
    @GetMapping("/amostra-em-falta")
    public ResponseEntity<List<Amostra>> findAmostraEmFalta(){
        List<Amostra> amostrasEmFalta = amostraService.findAmostraEmFalta();
        return ResponseEntity.status(HttpStatus.OK).body(amostrasEmFalta);
    }
}

