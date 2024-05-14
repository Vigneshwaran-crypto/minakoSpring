package com.example.minakospring.minako.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.minakospring.minako.Entities.Users;
import com.example.minakospring.minako.Services.UserServ;

import Response.Response;

import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/minako/")
public class UserController {
	
	@Autowired
	UserServ userServ;
	
	
	@GetMapping("getAllUsers")
	public Response getMethodName() { 		
		List<Users> allusers = userServ.getAllUsers();
		return new Response(1,"success",allusers);
	}
	
	
	@GetMapping("getUserById")
	public Response getUsersById(@RequestBody Long id) {
		Users user = userServ.getUserById(id);
		return new Response(1,"success",user);
	}
	
	
	
	@PostMapping("saveUser")
	public Response createUser(@RequestBody Users user) {
		System.out.println("createUser request data :"+user);
		System.out.println("createUser email data :"+user.getEmail());
		
		
		String userName = user.getEmail().split("@")[0];
		user.setUserName(userName);

		Users savedUser = userServ.createUser(user);
		return new Response(1,"success",savedUser);
	}
	
	
	@PostMapping("createUser") //@ModelAttribute for handling form data
	public Response makeuser(@ModelAttribute Users user) {
		
		
		System.out.println("createUser form request :"+user);
		
		System.out.println("createUser form request email:"+user.getEmail());
		String userName = user.getEmail().split("@")[0];
		user.setUserName(userName);
		

		
		Users savedUser = userServ.createUser(user);
		return new Response(1,"User Created",savedUser);
	}
	
	
	@PostMapping("editUser")
	public Response editUser(@RequestBody Users user) {
		System.out.println("editUser request data :"+user);

		Users editedUser = userServ.editUsers(user);
		return new Response(1,"success",editedUser);
	}
	
	
	
	
	@PostMapping("deleteUser")
	public Response deleteUser(@RequestBody Long id) {
		System.out.println("deleteUser request data :"+id);
		userServ.deleteUser(id);
		return new Response(1,"user deleted successfully",null);
		
	}
	

}
