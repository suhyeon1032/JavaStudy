package com.campus.myapp.controller;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class ClovaFileUpload {
	public static String fileUpload(String path, MultipartFile f) {
		String org = f.getOriginalFilename();
		try {
			f.transferTo(new File(path, org));
		}catch(Exception e) {
			
		}
		return org;
	}
}
