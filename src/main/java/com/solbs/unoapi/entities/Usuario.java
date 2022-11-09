package com.solbs.unoapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    private String cargo;
    private String email;
    private String senha;
}
