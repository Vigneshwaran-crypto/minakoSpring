package com.example.minakospring.minako.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minakospring.minako.Entities.Users;
import com.example.minakospring.minako.Repositories.UserRep;

@Service
public class UserServ {
	
	@Autowired
	UserRep userrep;
	
	
	public List<Users> getAllUsers(){
		return userrep.findAll();
	}
	
	
	public Users getUserById(Long id) {
		return userrep.findById(id).orElse(null);
	}
	
	public Users createUser(Users user) {
		return userrep.save(user);
	}
	
	
	public Users editUsers(Users user) {
		Users existingUser = userrep.findById(user.getId()).orElse(null);				
				
				if(existingUser != null) {
					existingUser.setEmail(user.getEmail());
					existingUser.setCoverImage(user.getCoverImage());
					existingUser.setPassword(user.getPassword());
					existingUser.setProfileImage(user.getProfileImage());
					existingUser.setUserName(user.getUserName());
					
					return userrep.save(existingUser);
				}else {
					return null;
				}
				
	}
	
	
	public void deleteUser(Long id) {
		userrep.deleteById(id);

	}
	
	
	
    
}
