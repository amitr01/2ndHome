package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.ProprtyRoomDto;
import com.app.entities.Property;

import ch.qos.logback.core.subst.Token.Type;

public interface PropertDao extends JpaRepository<Property, Long> {
  Property findPropertyByName(String name);

<<<<<<< HEAD
  List<Property> findByType(Type type); 
=======

>>>>>>> 4b11342e9f2e164b8510ffd725fc5d52c4f555ae
}
