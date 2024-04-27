package com.greatlearning.bharatnewlibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.bharatnewlibrary.service.MyFetchedAndDecoratedUser;

@Configuration
@EnableWebSecurity
public class MyWebConfigSpring3 {
	
	 	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	 	{
	 		http.authorizeRequests()
	        .requestMatchers("/home","/createApi","/readApi","/403").hasAnyAuthority("USER","ADMIN")
	        .requestMatchers("/updateApi","/deleteApi").hasAuthority("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
	        .and()
	        .logout().logoutSuccessUrl("/login").permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/403")
	        .and()
	        .cors().and().csrf().disable();
	 		
	 		
	 		
	 		http.authenticationProvider(myAuthenticationProvider());  
	 		return http.build();
	 		
	    }
	 
	 	@Bean
		public AuthenticationProvider myAuthenticationProvider() {
			DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
			daoAuthenticationProvider.setUserDetailsService(myUserDetailsService());
			daoAuthenticationProvider.setPasswordEncoder(myPasswordEncoder());
			return daoAuthenticationProvider;
		}

		@Bean
		public PasswordEncoder myPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		public  UserDetailsService myUserDetailsService() {
			return new MyFetchedAndDecoratedUser(); //
		}

}
