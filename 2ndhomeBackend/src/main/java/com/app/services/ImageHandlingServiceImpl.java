package com.app.services;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static org.apache.commons.io.FileUtils.readFileToByteArray;
import static org.apache.commons.io.FileUtils.writeByteArrayToFile;
@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {

	@Value("${file.upload.location}") 
	
	private String uploadFolder;
	

	@PostConstruct
	public void init() throws IOException {
		// chk if folder exists --yes --continue
		File folder = new File(uploadFolder);
		if (folder.exists()) {
			System.out.println("folder exists alrdy !");
		} else {
			// no --create a folder
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}
	
	@Override
	public String uploadr1image(MultipartFile image) throws IOException {
		String path=uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		writeByteArrayToFile(new File(path), image.getBytes());
		return path;
	}

	@Override
	public String uploadr2image(MultipartFile image) throws IOException {
		String path=uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		writeByteArrayToFile(new File(path), image.getBytes());
		return path;
	}

	@Override
	public String uploadr3image(MultipartFile image) throws IOException {
		String path=uploadFolder.concat(image.getOriginalFilename());
		System.out.println(path);
		writeByteArrayToFile(new File(path), image.getBytes());
		return path;
	}

}
