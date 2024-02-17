package com.app.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OwnerRequestDto;
import com.app.dto.PropertyDto;
import com.app.dto.RoomDto;
import com.app.services.OwnerService;
import com.app.services.PropertyService;
import com.app.services.RoomService;

@RestController
@RequestMapping("owner")
public class OwnerController {
   
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping("/addOwner")
	public ResponseEntity<?> addNewOwner(@RequestBody @Valid OwnerRequestDto dto
			){
		System.out.println("In add owner method");
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ownerService.addNewOwner(dto));
		
	}
	
	@PostMapping("/addProperty")
	public ResponseEntity<?> addNewProperty(@RequestBody @Valid  PropertyDto pdto){
		System.out.println("In add property Method");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(propertyService.addNewProperty(pdto));
	}
	
	@PostMapping("/addRoom")
	public ResponseEntity<?> addNewRoom(@RequestBody @Valid RoomDto rdto){
		System.out.println("In add Room Method");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(roomService.addNewRoom(rdto));
		
	}
	
	@GetMapping("/listProperty")
	public ResponseEntity<?> getAllProperties(){
		System.out.println("In Get All Properties Method");
		return ResponseEntity.ok(propertyService.getAllProperty());
	}
	
	@GetMapping("/listProperty{email}")
	public ResponseEntity<?> getPropertyByOwnerEmail(@PathVariable String email){
	System.out.println("In Get Property By Owner Email");
	return ResponseEntity.ok(propertyService.getPropertyByEmail(email));
	}
	
	@DeleteMapping("/deleteProperty/{name}")
	public ResponseEntity<?> deletePropertyByName(@PathVariable String name){
		System.out.println("In Delete Property By Name");
		return ResponseEntity.ok(ownerService.deletePropertyByName(name));
	}
}
