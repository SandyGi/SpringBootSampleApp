package com.sandy.example.BootDemo.user;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sandy.example.BootDemo.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	//Get all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDaoService.getAllUsers();
	}
	
	//Save user
	@PostMapping("/saveUser")
	public ResponseEntity<Object> saveNewUser(@Valid @RequestBody User user){
		User savedUser = userDaoService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Get single user
	@GetMapping("/getUser/{id}")
	public Resource<User> getUser(@PathVariable int id){
		
		User user = userDaoService.getUser(id);
		if(user == null)
			throw new UserNotFoundException("Id =" +id);
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		
		resource.add(linkTo.withRel("all_users"));
		
		return resource;
	}
	
	//Delete user by id
		@DeleteMapping("/deleteUser/{id}")
		public void deleteUser(@PathVariable int id){
			
			User user = userDaoService.deleteById(id);
			if(user == null)
				throw new UserNotFoundException("Id =" +id);
			
		}
}
