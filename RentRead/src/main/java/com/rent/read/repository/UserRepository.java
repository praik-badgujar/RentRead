package com.rent.read.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rent.read.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	//Users findByEmail(String email);
	 Optional<Users> findByEmail(String email);
}
