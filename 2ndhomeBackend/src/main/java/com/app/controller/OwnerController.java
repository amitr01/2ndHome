package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.OwnerRequestDto;
import com.app.dto.PropertyDto;
import com.app.dto.PropertyUpdateDto;
import com.app.dto.RoomDto;
import com.app.services.AuthenticationService;
import com.app.services.ImageHandlingService;
import com.app.services.OwnerService;
import com.app.services.PropertyService;
import com.app.services.RoomService;

@RestController
@RequestMapping("owner")
@CrossOrigin(origins = "http://localhost:3000")
public class OwnerController {
   
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ImageHandlingService imageHandlingService;
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping("/addOwner")
	public ResponseEntity<?> addNewOwner(@RequestBody @Valid OwnerRequestDto dto
			){
		System.out.println("In add owner method");
		return ResponseEntity.status(HttpStatus.CREATED).
				body(authService.registerOwner(dto));
		
	}
	
	@PostMapping("/addProperty")
	public ResponseEntity<?> addNewProperty(@RequestBody @Valid  PropertyDto pdto){
		System.out.println("In add property Method");
		System.out.println(pdto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(propertyService.addNewProperty(pdto));
	}
	@PostMapping(value="/addProperty/r1images",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadr1image(@RequestParam MultipartFile image) throws IOException{
		System.out.println("In Image Handling");
		return ResponseEntity.ok(imageHandlingService.uploadr1image(image));
	}
	
	@PostMapping(value="/addProperty/r2images",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadr2image(@RequestParam MultipartFile image) throws IOException{
		System.out.println("In Image Handling");
		return ResponseEntity.ok(imageHandlingService.uploadr2image(image));
	}
	
	@PostMapping(value="/addProperty/r3images",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadr3image(@RequestParam MultipartFile image) throws IOException{
		System.out.println("In Image Handling");
		return ResponseEntity.ok(imageHandlingService.uploadr3image(image));
	}
	
	
	
	@PostMapping("/addRoom")
	public ResponseEntity<?> addNewRoom(@RequestBody @Valid RoomDto rdto){
		System.out.println("In add Room Method");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(roomService.addNewRoom(rdto));
		
	}
	
//	@GetMapping("/listProperty" )
//	public ResponseEntity<?> getAllProperties() throws IOException{
//		System.out.println("In Get All Properties Method");
//		return ResponseEntity.ok(propertyService.getAllProperty());
//
//	}
	
//	@GetMapping(value="/property/{pid}" ,produces ={ IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
//	public ResponseEntity<?> getImage(@PathVariable Long pid) throws IOException {
//		return ResponseEntity.ok(propertyService.getImage(pid));
//	}
	
	@GetMapping("/listProperty/{email}")
	public ResponseEntity<?> getPropertyByOwnerEmail(@PathVariable String email){
	System.out.println("In Get Property By Owner Email");
	return ResponseEntity.ok(propertyService.getPropertyByEmail(email));
	}
	
	@DeleteMapping("/deleteProperty/{name}")
	public ResponseEntity<?> deletePropertyByName(@PathVariable String name){
		System.out.println("In Delete Property By Name");
		return ResponseEntity.ok(ownerService.deletePropertyByName(name));
	}
	
	@DeleteMapping("/deletePropertyId/{pid}")
	public ResponseEntity<?> deletePropertyById(@PathVariable Long pid){
		return ResponseEntity.ok(ownerService.deletePropertyById(pid));
	}
	//After Fetched Property we will do the changes and save it 
	@PutMapping("/updateProperty/{pid}")
	public ResponseEntity<?> updateProperty(@PathVariable Long pid,@RequestBody @Valid PropertyUpdateDto dto){
		System.out.println("In Update Property");
		return ResponseEntity.ok(propertyService.updateProperty(pid,dto));
	}
	
	//For Updating the property we are fetching the property Details First
	@GetMapping("/property/{pid}")
	public ResponseEntity<?> getProperty(@PathVariable Long pid){
		System.out.println("In Get single Property");
		return ResponseEntity.ok(propertyService.getPropertById(pid));
	}
	
	//For Updating the Room Details we will fetch the rooms details first
	@GetMapping("/room/{rid}")
	public ResponseEntity<?> getRoomById(@PathVariable Long rid){
		System.out.println("In Get Single Room");
		return ResponseEntity.ok(roomService.getRoomById(rid));
	}
	
  @PutMapping("/updateRoom/{rid}")
  public ResponseEntity<?> updateRoom(@PathVariable Long rid,@RequestBody @Valid RoomDto dto){
	  System.out.println("In Update Room Dto");
	  return ResponseEntity.ok(roomService.updateRoom(rid,dto));
  }
  
  @DeleteMapping("/deleteRoom/{rid}")
  public ResponseEntity<?> deleteRoom(@PathVariable Long rid){
	  System.out.println("In Delete Room");
	  return ResponseEntity.ok(roomService.deleteRoom(rid));
  }
  
  //For Updating Owner
  @GetMapping("/ownerDetails/{oid}")
  public ResponseEntity<?> getOwnerDetails(@PathVariable Long oid){
	  System.out.println("In get Owner Details property");
	  return ResponseEntity.ok(ownerService.getOwnerDetails(oid));
  }
  
  //For Updating Owner
  @PutMapping("/updateOwner/{oid}")
  public ResponseEntity<?> updateOwnerDetails(@PathVariable Long oid,@RequestBody @Valid OwnerRequestDto dto){
	   System.out.println("In Update Owner");
	   return ResponseEntity.ok(ownerService.updateOwner(oid,dto));
  }
}
