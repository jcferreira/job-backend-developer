package br.com.intelipost.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsConfig userDetailsConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        	.authorizeRequests()
        	.antMatchers("/usuario/listar").hasRole("ADMIN")
        	.antMatchers("/usuario/cadastrar").permitAll()
        	.antMatchers("/").permitAll()
        	.anyRequest().authenticated()
        	.and()
        		.formLogin().permitAll()
	        .and()
	        	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsConfig)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/templates/**");
	}
	
}
