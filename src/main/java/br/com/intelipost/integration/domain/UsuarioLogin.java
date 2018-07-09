package br.com.intelipost.integration.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuario_login")
@Data
public class UsuarioLogin implements UserDetails {

    private static final long serialVersionUID = 5030385358666161643L;

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
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> permissoes = new ArrayList<Role>();

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	    return this.permissoes;
    }

	@Override
    public String getPassword() {
	    return this.senha;
    }

	@Override
    public String getUsername() {
	    return this.email;
    }

	@Override
    public boolean isAccountNonExpired() {
	    return true;
    }

	@Override
    public boolean isAccountNonLocked() {
	    return true;
    }

	@Override
    public boolean isCredentialsNonExpired() {
	    return true;
    }

	@Override
    public boolean isEnabled() {
	    return true;
    }
    
}
