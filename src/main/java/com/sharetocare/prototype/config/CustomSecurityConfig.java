package com.sharetocare.prototype.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class CustomSecurityConfig  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("anand").password("{noop}anand").roles("USER")
		.and()
		.withUser("prachi").password("{noop}prachi").roles("USER","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/name").hasRole("USER")
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
	
	
	

}
