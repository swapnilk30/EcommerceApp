package com.ecommerce.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.exception.BadApiRequestException;
import com.ecommerce.service.FileService;


@Service
public class FileServiceImpl implements FileService{

	private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class); 
	
	@Override
	public String uploadImage(MultipartFile file, String path) throws IOException {
		
		//abc.png
		String originalFilename = file.getOriginalFilename();
		log.info("Filename : {}",originalFilename);
		
		String fileName = UUID.randomUUID().toString();
		
		String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		String fileNameWithExtension=fileName+extension;
		
		String fullPathWithFileName=path + File.separator + fileNameWithExtension;
		
		if(extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".jpeg")) {
			
			//file save
			File folder = new File(path);
			
			if(!folder.exists()) {
				//create the folder
				folder.mkdirs();
			}
			
			//upload
			Files.copy(file.getInputStream(),Paths.get(fullPathWithFileName));
			return fileNameWithExtension;
			
		}else {
			throw new BadApiRequestException("File With This Extension "+ extension +" Not allowed !!");
		}
	}

	
	@Override
	public InputStream getResource(String path, String name) throws FileNotFoundException {
		String fullPath = path + File.separator + name;
		InputStream inputStream =new FileInputStream(fullPath);
		return inputStream;
	}

}
