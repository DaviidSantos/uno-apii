package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.services.RelatorioDeAnaliseService;
import com.solbs.unoapi.services.SolicitacaoDeAnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping("/gerar-relatorio")
@CrossOrigin("*")
public class RelatorioDeAnaliseController {

    @Autowired
    RelatorioDeAnaliseService relatorioDeAnaliseService;

    @Autowired
    SolicitacaoDeAnaliseService solicitacaoDeAnaliseService;

    @GetMapping("/{idSA}")
    public void gerarRelatorioDeAnalise(@PathVariable String idSA, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + idSA + ".pdf";
        response.setHeader(headerKey, headerValue);
        SolicitacaoDeAnalise solicitacaoDeAnalise = solicitacaoDeAnaliseService.findById(idSA);
        Solicitante solicitante = solicitacaoDeAnalise.getSolicitante();
        Set<Amostra> amostras = solicitacaoDeAnalise.getAmostras();
        relatorioDeAnaliseService.export(response, solicitante, solicitacaoDeAnalise, amostras);
    }
}
