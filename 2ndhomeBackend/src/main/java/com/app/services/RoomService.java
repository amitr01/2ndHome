package com.app.services;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.RoomDto;

public interface RoomService {

	ApiResponse addNewRoom(@Valid RoomDto rdto);

}
