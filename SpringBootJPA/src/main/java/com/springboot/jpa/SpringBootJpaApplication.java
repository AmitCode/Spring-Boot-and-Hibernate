package com.springboot.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;

import com.springboot.jpa.entity.beans.Users;
import com.springboot.jpa.userRepo.UserRepo;

@SpringBootApplication(scanBasePackages = "com.springboot.jpa")
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		//CRUD
		//Create
		UserRepo userRepo = context.getBean(UserRepo.class);
		
		Users user = new Users();
		user.setUserId(0015);
		user.setUserName("AmIT Kumar Pandey");
		user.setUserAddress("Siddharth Nagar, Uttar Prades");
//		//Saving Single User.
//		Users u1 = userRepo.save(user);
		
		Users user1 = new Users();
		user1.setUserId(0016);
		user1.setUserName("Aman Kumar Pandey");
		user1.setUserAddress("Siddharth Nagar, Uttar Prades");
		
		List<Users> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		//Saving Mutiple User
		//Iterable<Users> result= userRepo.saveAll(userList);
//		System.out.println("UserDetails : " +u1);
		
		//Read
		
		Optional<Users> userData = userRepo.findById(0015);
		System.out.println("UserId: 0015"  + " UserName: " +userData.get().getUserName());
		
		//Update
//		Users updateUser = userData.get();
//		System.out.println(updateUser);
//		updateUser.setUserAddress("Siddharth Nagar, Uttar Pradesh");
//		userRepo.save(updateUser);
		//Delete
		userRepo.deleteById(13);
	}

}
