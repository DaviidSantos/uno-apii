package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.repositories.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteService {
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    public Solicitante cadastrarSolicitante(Solicitante solicitante){
        return solicitanteRepository.save(solicitante);
    }

    public List<Solicitante> retornarTodosSolicitantes(){
        return solicitanteRepository.findAll();
    }

    public Solicitante retornarSolicitantePorCnpj(String cnpj){
        Optional<Solicitante> obj = solicitanteRepository.findById(cnpj);
        return obj.get();
    }

}
