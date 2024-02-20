package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserDao extends JpaRepository<User,Long> {

	//find user by email
	Optional<User> findByEmail(String email);
<<<<<<< HEAD

	Optional<User> findByEmailAndPassword(String email, String password);
=======
	
	Optional<User> findByEmailAndPassword(String email,String password);
>>>>>>> 26c1711e2b6fa6320487a77f755d9f55010ea21e
}
