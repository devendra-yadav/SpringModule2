package com.epam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users=User.withDefaultPasswordEncoder();
		
		UserBuilder user1=users.username("dev").password("dev").roles("EMPLOYEE");
		UserBuilder user2=users.username("man").password("man").roles("MANAGER");
		UserBuilder user3=users.username("adm").password("adm").roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser(user1);
		auth.inMemoryAuthentication().withUser(user2);
		auth.inMemoryAuthentication().withUser(user3);
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/processLogin").permitAll().and().logout().permitAll();
		
	}
}
