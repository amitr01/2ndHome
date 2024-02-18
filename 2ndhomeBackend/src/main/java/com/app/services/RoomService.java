package com.app.services;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.RoomDto;

public interface RoomService {

	ApiResponse addNewRoom(@Valid RoomDto rdto);

	RoomDto getRoomById(Long rid);

	ApiResponse updateRoom(Long rid, @Valid RoomDto dto);

	ApiResponse deleteRoom(Long rid);

}
