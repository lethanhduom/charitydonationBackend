package com.management.charitydonation.service.Impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.management.charitydonation.service.CloudinaryService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService{
	@Autowired
	private final Cloudinary cloudinary;
	@Override
	public String uploadImage(MultipartFile file) throws IOException {
	 Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
     return uploadResult.get("url").toString();
	
	}

}
