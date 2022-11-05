package com.solbs.unoapi.config;

import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.entities.enums.StatusAmostra;
import com.solbs.unoapi.repositories.AmostraRepository;
import com.solbs.unoapi.repositories.EnsaioRepository;
import com.solbs.unoapi.repositories.SolicitacaoDeAnaliseRepository;
import com.solbs.unoapi.repositories.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private SolicitacaoDeAnaliseRepository solicitacaoDeAnaliseRepository;

    @Autowired
    private AmostraRepository amostraRepository;

    @Autowired
    private EnsaioRepository ensaioRepository;

    @Override
    public void run(String... args) throws Exception {
        Solicitante s1 = new Solicitante("42923299000104", "David", "13331344", "Rua Carlos Sartorello", "Indaiatuba", "São Paulo", "19989971070", "daavid.psantos@gmail.com");
        Solicitante s2 = new Solicitante("42923299000105", "Paulo", "13331354", "Sei La", "Indaiatuba", "São Paulo", "19988571070", "paulo@gmail.com");

        solicitanteRepository.saveAll(Arrays.asList(s1, s2));

        SolicitacaoDeAnalise sa1 = new SolicitacaoDeAnalise(null, "Degradacao", "Teste", "Testando", s1);
        SolicitacaoDeAnalise sa2 = new SolicitacaoDeAnalise(null, "Desenvolvimento", "Teste", "Testando", s2);
        SolicitacaoDeAnalise sa3 = new SolicitacaoDeAnalise(null, "Monitoramento", "Teste", "Testando", s2);
        solicitacaoDeAnaliseRepository.saveAll(Arrays.asList(sa1, sa2, sa3));

        Amostra a1 = new Amostra(null, "Ibuprofeno", sa1, StatusAmostra.AGUARDANDO_ANALISE, Instant.now(), "Capsula", "123456789", LocalDate.parse("2022-11-15"));
        Amostra a2 = new Amostra(null, "Dipirona",  sa2,StatusAmostra.AGUARDANDO_ANALISE, Instant.now(), "Pilula", "132456789", null);

        amostraRepository.saveAll(Arrays.asList(a1, a2));

        Ensaio e1 = new Ensaio(null, "Degradação", "15x", null, a1);
        Ensaio e2 = new Ensaio(null, "Karl Fischer", "15x", null, a1);
        Ensaio e3 = new Ensaio(null, "Solubilidade", "15x", null, a1);
        Ensaio e4 = new Ensaio(null, "Degradação", "15x", null, a2);

        ensaioRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
    }
}
