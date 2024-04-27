package com.greatlearning.bharatnewlibrary.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.bharatnewlibrary.entity.Role;
import com.greatlearning.bharatnewlibrary.entity.User;

public class UserDecorator implements UserDetails{

	User user;
	
	public UserDecorator(User user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();    //ROLE_     ROLE_USER
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));  //ROLE_ADMIN   ROLE_MANAGER
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		LocalDate accExpiryDate=user.getAccountExpiryDate(); //accExpiryDate=27-May-2024;
		LocalDate todaysDate=LocalDate.now();				 //todaysDate=27-Apr-2024;
		if(accExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}
	//?:

	@Override
	public boolean isAccountNonLocked() {
		int accLockedStatus=user.getAccountLockedStatus();
//		if(accLockedStatus==1)
//			return true;
//		else
//			return false;
		
//return accLockedStatus==1?true:false;
		
		return user.getAccountLockedStatus()==1?true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
//		LocalDate credExpiryDate=user.getCredentialsExpiryDate();
//		LocalDate todaysDate=LocalDate.now();				 //todaysDate=27-Apr-2024;
//		if(credExpiryDate.isAfter(todaysDate))
//			return true;
//		else
//			return false;
//		
	
//return credExpiryDate.isAfter(todaysDate)? true: false;
		return user.getCredentialsExpiryDate().isAfter(LocalDate.now())? true: false;
	}

	@Override
	public boolean isEnabled() {
		int enabledStatus=user.getAccountEnabledStatus();
		if(enabledStatus==1)
			return true;
		else
			return false;
		
	}

}
