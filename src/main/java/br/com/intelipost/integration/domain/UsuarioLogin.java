package br.com.intelipost.integration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuario_login")
@Data
public class UsuarioLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


}
