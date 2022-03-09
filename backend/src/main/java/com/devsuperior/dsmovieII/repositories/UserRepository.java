package com.devsuperior.dsmovieII.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovieII.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
