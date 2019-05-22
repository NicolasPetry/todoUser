package com.honeyBadger.todoListBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
		auth.inMemoryAuthentication()
        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
        .and()
        .withUser("user").password(passwordEncoder().encode("userPass")).roles("USER");
   
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .csrf().disable()
        .exceptionHandling()
        .and()
        .authorizeRequests()
        .antMatchers("/api/todo").authenticated()
        .antMatchers("/api/admin/**").hasRole("ADMIN")
        .and()
        .formLogin()
        .and()
        .logout();
    }
}
	
