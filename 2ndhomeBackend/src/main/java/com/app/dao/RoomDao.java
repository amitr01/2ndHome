package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Room;
import com.app.entities.User;

public interface RoomDao extends JpaRepository<Room, Long> {

	Room findByPropertyId(Long id);

}
