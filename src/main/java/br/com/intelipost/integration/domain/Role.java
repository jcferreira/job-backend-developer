package br.com.intelipost.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = -6627580636785936195L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(nullable=false)
	private String chaveAcesso;

	@Override
    public String getAuthority() {
	    return this.chaveAcesso;
    }
	
}
