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

@RestController
@RequestMapping("/amostra")
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
    public ResponseEntity<List<Amostra>> retornarTodasAmostras(){
        List<Amostra> amostras = amostraService.retornarTodasAmostras();
        return ResponseEntity.ok().body(amostras);
    }


    /**
     * Método HTTP que retorna uma amostra a partir do id
     * @param idAmostra id da amostra a ser retornada
     * @return Entidade de resposta com a amostra
     */
    @GetMapping("/{idAmostra}")
    public ResponseEntity<Amostra> retornarAmostraPeloId(@PathVariable Long idAmostra){
        Amostra amostra = amostraService.retornarAmostraPeloId(idAmostra);
        return ResponseEntity.status(HttpStatus.OK).body(amostra);
    }

    /**
     * Método HTTP que cadastra uma amostra na base de dados
     * @param amostraDTO dados da amostra a ser cadastrada
     * @return Entidade de resposta com a amostra cadastrada
     */
    @PostMapping
    public ResponseEntity<Amostra> cadastrarAmostra(@RequestBody AmostraDTO amostraDTO){
        Amostra amostra = new Amostra();
        SolicitacaoDeAnalise solicitacaoDeAnalise = solicitacaoDeAnaliseService.retornarSolicitacaoDeAnalisePorId(amostraDTO.getSolicitacaoDeAnalise());
        BeanUtils.copyProperties(amostraDTO, amostra);
        StatusAmostra statusAmostra = StatusAmostra.valor(amostraDTO.getStatusAmostra());
        amostra.setSolicitacaoDeAnalise(solicitacaoDeAnalise);
        amostra.setDataDeEntrada(Instant.now());
        amostra.setStatusAmostra(statusAmostra);
        return ResponseEntity.status(HttpStatus.CREATED).body(amostraService.cadastrarAmostra(amostra));
    }

    /**
     * Método que atualiza o Status da amostra
     * @param idAmostra id da amostra que terá o status atualizado
     * @param status código int do novo status
     * @return Entidade de resposta com a amostra atualizada
     */
    @PutMapping("/{idAmostra}")
    public ResponseEntity<Amostra> atualizarStatusAmostra(@PathVariable Long idAmostra, @RequestBody int status){
        Amostra amostra = amostraService.retornarAmostraPeloId(idAmostra);
        StatusAmostra statusAmostra = StatusAmostra.valor(status);
        amostra.setStatusAmostra(statusAmostra);
        return ResponseEntity.status(HttpStatus.OK).body(amostraService.cadastrarAmostra(amostra));
    }
}

