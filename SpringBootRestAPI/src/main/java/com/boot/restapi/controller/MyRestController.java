package com.boot.restapi.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;


import com.boot.restapi.beans.Users;
import com.boot.restapi.userServices.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//Current Java Class can't be same as annotations
//ex: @RestController(Annotation) and Current Class name is RestController
//it will throw an error as restcontroller is not an annotation type
@RestController
public class MyRestController {
//	@RequestMapping(value = "/testController", method=RequestMethod.GET)
//	//@ResponseBody is needed in case of @Controller but not is the case of @RestController
	@Autowired
	private UserService userService;
	
//	@GetMapping("/testController")
//	public String testController() {
//		return "This is a project for Spring Boot Rest API";
//	}
	
	@GetMapping("/userDetails")
	public List<Users> userDetails() {
		return  this.userService.getAllUsers();
	}
	
	@GetMapping("/userDetails/{id}")
	public Users userDetailsById(@PathVariable("id") int id) {
		return  this.userService.getUserById(id);
	}
	
	@PostMapping("/addUser")
	public List<Users> addUser(@RequestBody Users user) {
		return this.userService.addUser(user);
	}
	
	//"status": 404 ----> "error": "Not Found", Exception "trace": "org.springframework.web.servlet.resource.NoResourceFoundException: No static resource addUser1
	//"status": 400 ----> "error": "Bad Request" ,Exception org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing
	@DeleteMapping("/deleteUser/{userId}")
	public List<Users> deleteUser(@PathVariable("userId") int id){
		return this.userService.deleteUserById(id);
	}
	
	@PutMapping("updateUser/{userId}")
	public Users updateUserById(@RequestBody Users user, @PathVariable int userId){
		return this.userService.updateUserById(user, userId);
	}
	
}
