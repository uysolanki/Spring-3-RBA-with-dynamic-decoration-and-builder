//package com.greatlearning.bharatnewlibrary.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.greatlearning.bharatnewlibrary.service.MyFetchedAndDecoratedUser;
//
//@Configuration
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter
//{
//	//override 2 configure methods
//	//1. configure(AuthenticationManagerBuilder auth) //Authentication - DAO - Database
//	//2. configure(HttpSecurity http) //Authorization
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(myAuthenticationProvider());
//	}
//	
//	@Bean
//	public AuthenticationProvider myAuthenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(myPasswordEncoder());
//		return daoAuthenticationProvider;
//	}
//
//	@Bean
//	public PasswordEncoder myPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public  UserDetailsService myUserDetailsService() {
//		return new MyFetchedAndDecoratedUser(); //
//	}
//		//Fetching implements UserDetailsService - loadUserByUsername
//		//Decorate roles, credential expiry, acc locked UserDetails
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception 
//	{
//		http.authorizeRequests()
//        .antMatchers("/home","/createApi","/readApi","/403").hasAnyAuthority("USER","ADMIN")
//        .antMatchers("/updateApi","/deleteApi").hasAuthority("ADMIN")
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
//        .and()
//        .logout().logoutSuccessUrl("/login").permitAll()
//        .and()
//        .exceptionHandling().accessDeniedPage("/403")
//        .and()
//        .cors().and().csrf().disable();
//
//	}
//
//}
