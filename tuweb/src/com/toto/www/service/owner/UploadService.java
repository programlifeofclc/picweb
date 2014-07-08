package com.toto.www.service.owner;

import java.io.File;
import java.io.IOException;
import java.util.Random;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import utils.UpFileUtils;

import beans.TotoImgs;

import com.toto.www.service.BaseService;

@Service("uploadService")
public class UploadService extends BaseService {
	Random r = new Random();
	
	public void saveImg(File file,TotoImgs totoImgs) throws IOException{
		String FileType = totoImgs.getImgName().substring(totoImgs.getImgName().lastIndexOf(".")+1);
		String dir = UpFileUtils.getRanName();
		
		UpFileUtils.NokeepScaleFile(file, totoImgs.getImgUrl() + dir +"/", "img_200_100." + FileType , 200, 100, 1, null);
		FileUtils.copyFile(file, new File(totoImgs.getImgUrl() + dir +"/img." + FileType));
	}
	
	public static void main(String[] args) {
		System.out.println("as.asdf.jpg".substring(		 "as.asdf.jpg".lastIndexOf(".")));
	}

}
