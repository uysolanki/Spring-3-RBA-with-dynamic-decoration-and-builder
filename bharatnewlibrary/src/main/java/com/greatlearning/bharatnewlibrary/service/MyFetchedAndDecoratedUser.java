package com.greatlearning.bharatnewlibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.bharatnewlibrary.entity.User;
import com.greatlearning.bharatnewlibrary.repository.UserRepository;

@Service
public class MyFetchedAndDecoratedUser implements UserDetailsService {

	@Autowired
	UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=null;
		
		user =userrepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User does not exist");
		
		
		return new UserDecorator(user);
	}

}
