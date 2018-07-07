package br.com.intelipost.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intelipost.integration.domain.UsuarioLogin;

public interface LoginRepository extends JpaRepository<UsuarioLogin, Long> {

}
