package com.istm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.istm.dao.UserRepository;
import com.istm.entities.User;

public class UserDetailServiceImpl implements UserDetailsService{

	
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepository.getUserByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found");
			
		}
		CustomUserDetail customUserDetail = new CustomUserDetail(user);
		return customUserDetail;
	}

}
