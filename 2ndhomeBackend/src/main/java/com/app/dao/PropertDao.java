package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Property;

public interface PropertDao extends JpaRepository<Property, Long> {
  Property findPropertyByName(String name);


}
