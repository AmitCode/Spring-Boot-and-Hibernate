package com.boot.restapi.userServices;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.restapi.beans.Users;
import com.boot.restapi.user.repositories.UserRepositories;
@Component
public class UserService {
	@Autowired
	private UserRepositories userRepo;
	
	List<Users> listOfUsers=null;
	public List<Users> getAllUsers(){
		return (List<Users>)this.userRepo.findAll();
	}
	
	public Users getUserById(int userId) {
		return userRepo.findByUserId(userId);
	}
	
	public List<Users> addUser(Users user){
		userRepo.save(user);
		return (List<Users>)this.userRepo.findAll();
	}
	
	public List<Users> deleteUserById(int userId){
		
		listOfUsers = listOfUsers.stream().filter(user -> {
			if(user.getUserId() != userId) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		userRepo.deleteById(userId);
		return listOfUsers;
	}
	
	
//	public List<Users> updateUserById(Users user, int userId){
//		listOfUsers = listOfUsers.stream().map(us -> {
//			if(us.getUserId() == userId) {
//				us.setUserName(user.getUserName());
//				us.setUserAddress(user.getUserAddress());
//			}
//			return us;
//			
//		}).collect(Collectors.toList());
//		return listOfUsers;
//	}
	
	public Users updateUserById(Users user, int userId){
//		listOfUsers = listOfUsers.stream().filter(us -> {
//			if(us.getUserId() == userId) {
//				us.setUserName(user.getUserName());
//				us.setUserAddress(user.getUserAddress());
//				return true;
//			}else {
//				return true;
//			}
//			
//		}).collect(Collectors.toList());
		user.setUserId(userId);
		userRepo.save(user);
		return userRepo.findByUserId(userId);
	}
}
