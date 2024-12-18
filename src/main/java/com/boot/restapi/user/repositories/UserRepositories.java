package com.boot.restapi.user.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.restapi.beans.Users;

public interface UserRepositories extends CrudRepository<Users,Integer>{
	public Users findByUserId(int userId);

}
