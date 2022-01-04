package com.greenshare.site.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()		
				.antMatchers("/dashboard")
					.hasRole("ADMIN")
					
				.antMatchers("/map")
					.hasAnyRole("USER", "ADMIN")
					
				.antMatchers("/**")
					.permitAll()
					    
			.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
					.failureUrl("/login?error=true")
			.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
			      		
			.and()
				.httpBasic()
			.and()
				.csrf()
			    	.disable();
			  

	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
		
		
		// Spring security 5
		// https://blog.marcosbarbero.com/password-encoder-migration-spring-security-5/
		// supporto per password criptate con vari password encoders
		
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(this.passwordEncoder());
	}
}
