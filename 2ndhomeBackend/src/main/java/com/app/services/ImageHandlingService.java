package com.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageHandlingService {

	String uploadr1image(MultipartFile image) throws IOException;

	String uploadr2image(MultipartFile image) throws IOException;
	
	String uploadr3image(MultipartFile image)throws IOException;

}
