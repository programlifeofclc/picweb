package com.toto.www.action.owner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import utils.EasyUIPage;
import utils.Page;

@Controller("fileManagerAction")
public class FileManagerAction {
	//Logger log = Logger.getLogger(this.getClass());
	private int pageNumber;
	private int pageSize;
	private EasyUIPage epage;
	
	
	public String findImgs() throws IOException{
		List<Object> list = new ArrayList<Object>();
		for(int i = 0; i < pageSize; i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", "code"+i);
			map.put("name", "name"+i);
			list.add(map);
		}
		Page page = new Page(pageNumber,pageSize,120);
		page.setRows(list);
		
		this.epage = page.getUIPage();
		return "jsonstr";
	}

	
	
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public EasyUIPage getEpage() {
		return epage;
	}

	public void setEpage(EasyUIPage epage) {
		this.epage = epage;
	}

}
