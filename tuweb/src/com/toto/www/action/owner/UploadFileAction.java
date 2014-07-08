package com.toto.www.action.owner;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import beans.TotoImgs;

import com.toto.www.service.owner.UploadService;

@Controller("uploadFileAction")
public class UploadFileAction {
	Logger log = Logger.getLogger(this.getClass());
	
	
	private File uploadFile;
	private String Filename;
	private String Upload;
	private String uploadFileContentType;
	private String uploadFileFileName;
	private String imgContext;
	private String imgName;
	private UploadService uploadService;
	private String imgRootPath;
	
	public String uploadFile() throws IOException{
		String path = ServletActionContext.getRequest().getRealPath("/");
		log.error("我是谁");
		TotoImgs totoimg = new TotoImgs();
		totoimg.setCreateTime(new Date());
		totoimg.setImgContext(imgContext);
		totoimg.setImgName(uploadFileFileName);
		totoimg.setImgUploader("clc");
		totoimg.setImgUrl(path + imgRootPath);
		try{
		uploadService.saveImg(uploadFile,totoimg);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	public UploadService getUploadService() {
		return uploadService;
	}
	@Resource(name="uploadService")
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUpload() {
		return Upload;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public void setUpload(String upload) {
		Upload = upload;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}
	public String getImgContext() {
		return imgContext;
	}

	public void setImgContext(String imgContext) {
		this.imgContext = imgContext;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgRootPath() {
		return imgRootPath;
	}

	public void setImgRootPath(String imgRootPath) {
		this.imgRootPath = imgRootPath;
	}
	
}
