package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long> {
  Owner findOwnerByEmail(String email);
  
  Optional<Owner> findByEmailAndPassword(String email,String password);
}
