package com.siddu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				// enable in memory based authentication with a user named
				// "user" and "admin"
				.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("siddu")
				.password("asdf").roles("USER").and().withUser("admin").password("password").roles("USER", "ADMIN");
	}

	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				// .antMatchers("**/rest/*")
				.anyRequest().fullyAuthenticated().and().httpBasic();

		httpSecurity.csrf().disable();
	}

}
