package com.toto.www.service.owner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.toto.www.service.BaseService;

@Service("uploadService")
public class UploadService extends BaseService {

	public void saveImg(File file, String path, String fileName) throws IOException{
		String newPath = "dataImg/";
		FileUtils.copyFile(file, new File(path + newPath + fileName));
	}

}
