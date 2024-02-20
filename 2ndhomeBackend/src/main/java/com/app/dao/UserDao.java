package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserDao extends JpaRepository<User,Long> {

	//find user by email
	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);
}
