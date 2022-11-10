package com.solbs.unoapi.controllers;

import com.solbs.unoapi.entities.Usuario;
import com.solbs.unoapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Método HTTP que retorna todos os usuários cadastrados na base de dados
     * @return Entidade de Resposta com Lista de Usuários Cadastrados
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> retornarTodosUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    /**
     * Método HTTP que retora um usuário a partir de seu id
     * @param idUsuario Id do Usuário que será retornado
     * @return Entidade de Resposta com Usuário
     */
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> retornarUsuarioPeloId(@PathVariable Long idUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(idUsuario));
    }

    /**
     * Método HTTP que cadastra um usuário na base de dados
     * @param usuario Dados do usuário que será cadastrado
     * @return Entidade de Resposta com Usuário cadastrado
     */
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    /**
     * Método HTTP que deleta um usuário da base de dados
     * @param idUsuario Id do Usuário que será deletado
     * @return Entidade de Resposta
     */
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Long idUsuario){
        Usuario usuario = usuarioService.findById(idUsuario);
        usuarioService.delete(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário Deletado com Sucesso!");
    }

    /**
     * Método HTTP que altera a senha de um usuário
     * @param novaSenha Nova senha do usuário
     * @param idUsuario Id do usuário cuja senha será alteraa
     * @return Entidade de Resposta com usuário atualizado
     */
    @PostMapping("/{idUsuario}")
    public ResponseEntity<Usuario> alterarSenha(@RequestBody String novaSenha, @PathVariable Long idUsuario){
        Usuario usuario = usuarioService.findById(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.alterarSenha(usuario, novaSenha));
    }
}
