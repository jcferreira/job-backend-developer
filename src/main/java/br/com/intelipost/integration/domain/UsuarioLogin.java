package br.com.intelipost.integration.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuario_login")
@Data
public class UsuarioLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false)
    private String senha;

    @Column(nullable=false)
    private boolean ativo;
    
    @OneToMany(fetch=FetchType.EAGER)
    private List<Role> permissoes = new ArrayList<Role>();
    
}
