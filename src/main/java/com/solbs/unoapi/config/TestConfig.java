package com.solbs.unoapi.config;

import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.repositories.SolicitacaoDeAnaliseRepository;
import com.solbs.unoapi.repositories.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private SolicitacaoDeAnaliseRepository solicitacaoDeAnaliseRepository;

    @Override
    public void run(String... args) throws Exception {
        Solicitante s1 = new Solicitante("42923299000104", "David", "13331344", "Rua Carlos Sartorello", "Indaiatuba", "São Paulo", "19989971070", "daavid.psantos@gmail.com");
        Solicitante s2 = new Solicitante("42923299000105", "Paulo", "13331354", "Sei La", "Indaiatuba", "São Paulo", "19988571070", "paulo@gmail.com");

        solicitanteRepository.saveAll(Arrays.asList(s1, s2));

        SolicitacaoDeAnalise sa1 = new SolicitacaoDeAnalise(null, "Degradacao", "Teste", "Testando", s1);
        SolicitacaoDeAnalise sa2 = new SolicitacaoDeAnalise(null, "Desenvolvimento", "Teste", "Testando", s2);
        SolicitacaoDeAnalise sa3 = new SolicitacaoDeAnalise(null, "Monitoramento", "Teste", "Testando", s2);
        solicitacaoDeAnaliseRepository.saveAll(Arrays.asList(sa1, sa2, sa3));

    }
}