package com.kh.rollingpaper.common;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class HelloSpringUtils {

	/**
	 * yyyyMMdd_HHmmssSSS_123.jpg
	 * @param upFile
	 * @return
	 */
	public static String renameMultipartFile(MultipartFile upFile) {
		String originalFilename = upFile.getOriginalFilename();
		String ext = "";
		int beginIndex = originalFilename.lastIndexOf(".");
		if(beginIndex > -1) {
			ext = originalFilename.substring(beginIndex);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd_HHmmssSSS_");
		DecimalFormat df = new DecimalFormat("000");
		
		return sdf.format(new Date()) + df.format(Math.random() * 1000) + ext;
	}

}
