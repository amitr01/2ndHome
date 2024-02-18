package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.ProprtyRoomDto;
import com.app.entities.Property;

import ch.qos.logback.core.subst.Token.Type;

public interface PropertDao extends JpaRepository<Property, Long> {
  Property findPropertyByName(String name);


  List<Property> findByType(Type type); 



}
