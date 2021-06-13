package com.infy.recipe.update.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.inMemoryAuthentication()
			.withUser("admin")
			.password(passwordEncoder().encode("admin123")).roles("ADMIN")
			.and()
			.withUser("user")
			.password(passwordEncoder().encode("user123")).roles("USER");
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(HttpSecurity http) throws Exception {    
		   http
		     .authorizeRequests()
		      .antMatchers("/recipe/update/**").hasRole("ADMIN")
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic();
		   http.csrf().disable();
		}


}
