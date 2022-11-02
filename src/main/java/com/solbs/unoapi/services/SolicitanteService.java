package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.repositories.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteService {
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Transactional
    public Solicitante cadastrarSolicitante(Solicitante solicitante){
        return solicitanteRepository.save(solicitante);
    }

    public List<Solicitante> retornarTodosSolicitantes(){
        return solicitanteRepository.findAll();
    }

    public Solicitante retornarSolicitantePorCnpj(String cnpj){
        return solicitanteRepository.findById(cnpj).get();
    }

    public Solicitante atualizarDados(Solicitante solicitante, Solicitante dados) {
        if (dados.getNomeSolicitante() != null) {
            solicitante.setNomeSolicitante(dados.getNomeSolicitante());
        }

        if (dados.getCep() != null) {
            solicitante.setCep(dados.getCep());
        }

        if (dados.getEndereco() != null) {
            solicitante.setEndereco(dados.getEndereco());
        }

        if(dados.getCidade() != null){
            solicitante.setCidade(dados.getCidade());
        }

        if (dados.getEstado() != null) {
            solicitante.setEstado(dados.getEstado());
        }

        if (dados.getEmailComercial() != null) {
            solicitante.setEmailComercial(dados.getEmailComercial());
        }

        if (dados.getTelefoneComercial() != null) {
            solicitante.setTelefoneComercial(dados.getTelefoneComercial());
        }
        return solicitante;
    }
}
