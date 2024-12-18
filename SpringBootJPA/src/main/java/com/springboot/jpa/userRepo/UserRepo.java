package com.springboot.jpa.userRepo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entity.beans.Users;

public interface UserRepo extends CrudRepository<Users,Integer> {

}
