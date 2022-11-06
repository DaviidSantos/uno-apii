package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Solicitante;
import com.solbs.unoapi.repositories.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SolicitanteService {
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    /**
     * Método que retorna uma lista com todos os solicitantes
     * @return Lista de Solicitantes
     */
    public List<Solicitante> findAll(){
        return solicitanteRepository.findAll();
    }

    /**
     * Método que retorna um solicitante a partir de seu CNPJ
     * @param cnpj CNPJ do solicitante
     * @return Solicitantee
     */
    public Solicitante findByCNPJ(String cnpj){
        return solicitanteRepository.findById(cnpj).get();
    }

    /**
     * Método que salva um solicitante na base de dados
     * @param solicitante Solicitante que será salvo
     * @return Solicitante salvo
     */
    @Transactional
    public Solicitante save(Solicitante solicitante){
        return solicitanteRepository.save(solicitante);
    }

    /**
     * Método que atualiza os dados de um solicitante
     * @param solicitante Solicitante que terá os dados atualizados
     * @param dados Dados do solicitante que serão atualizados
     * @return Solicitante atualizado
     */
    public Solicitante updateData(Solicitante solicitante, Solicitante dados) {
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
