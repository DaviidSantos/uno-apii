package com.solbs.unoapi.services;

import com.solbs.unoapi.entities.Usuario;
import com.solbs.unoapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Método que retorna uma lista com todos usuários cadastrados na base de dados
     * @return Lista de usuários
     */
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    /**
     * Método que retorna um usuário a partir de seu id
     * @param id Id do usuário
     * @return Usuário
     */
    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }

    /**
     * Método que salva um usuário na base de dados
     * @param usuario Usuário a ser salvo na base de dados
     * @return Usuário salvo na base dados
     */
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    /**
     * Método que apaga um usuário da base de dados
     * @param usuario Usuário que será deletado
     */
    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
