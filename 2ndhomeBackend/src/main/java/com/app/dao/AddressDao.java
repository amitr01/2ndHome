package com.app.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Address;

public interface AddressDao extends JpaRepository<Address, Long> {
	
	@Query("Select a.id from Address a where a.city=:city")
	Set<Long> findIdByCity(String city);
}
