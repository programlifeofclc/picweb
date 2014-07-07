package com.toto.www.action.owner;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.toto.www.service.owner.UploadService;

@Controller("uploadFileAction")
public class UploadFileAction {
	Logger log = Logger.getLogger(this.getClass());
	
	
	private File uploadFile;
	private String Filename;
	private String Upload;
	private String uploadFileContentType;
	private String uploadFileFileName;
	
	private UploadService uploadService;
	
	public String uploadFile() throws IOException{
		String path = ServletActionContext.getRequest().getRealPath("/");
		log.error("我是谁");
		uploadService.saveImg(uploadFile, path, Filename);
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
}
