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
		totoImgs.setImgUrl(totoImgs.getImgUrl() + dir);
		String basePath = totoImgs.getBasePath() + totoImgs.getImgUrl();
		
		UpFileUtils.NokeepScaleFile(file, basePath + "/", "img_32_32." + FileType , 32, 32, 1, null);
		UpFileUtils.NokeepScaleFile(file, basePath + "/", "img_200_100." + FileType , 200, 100, 1, null);
		FileUtils.copyFile(file, new File(basePath + "/img." + FileType));
		baseDao.saveOrUpdate(totoImgs);
	}
	
	public static void main(String[] args) {
		System.out.println("as.asdf.jpg".substring(		 "as.asdf.jpg".lastIndexOf(".")));
	}

}
