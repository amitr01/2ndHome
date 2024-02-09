package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDTO;
import com.app.services.AddressService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/property/{pid}/address")
@Validated
public class AddressController {

	
	@Autowired
	private AddressService addrService;
	
	public AddressController() {
		System.out.println("in address controller");
	}
	
	//assign address to property
	@PostMapping
	@Operation(summary = "Assign Employe Address")
	public ResponseEntity<?> assignPropertyAddress(@PathVariable @NotNull Long pid,
			@RequestBody @Valid AddressDTO address){
		
		System.out.println("in assign address.");
		return ResponseEntity.status(HttpStatus.CREATED).body(addrService.assignPropertyAdddress(pid,address));
	}
	
	//get property Address
	@GetMapping
	@Operation(summary = "Get Employee Addess")
	public ResponseEntity<?>getPropAddress(@PathVariable Long pid){
		System.out.println("in get address.");
	
		return ResponseEntity.ok(addrService.getPropertyAddress(pid));
	}
	
	@PutMapping
	@Operation(summary = "Complete updation of property address")
	public ResponseEntity<?> updatePropAddress(@PathVariable @NotNull Long pid,
			@RequestBody @Valid AddressDTO address) {
		System.out.println("in complete update adr " + pid + " " + address);
		return ResponseEntity.ok()
				.body(addrService.updatePropertyAddress(pid, address));
	}
	
	
	
	
	
	
	
	
	
	
	
}
