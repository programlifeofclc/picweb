package com.toto.www.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import utils.EasyUIPage;
import beans.TotoImgs;

import com.toto.www.service.owner.TotoImgsService;

@Controller("fileManagerAction")
public class FileManagerAction {
	//Logger log = Logger.getLogger(this.getClass());
	private int page;
	private int rows;
	private EasyUIPage epage;
	@Resource(name="totoImgsService")
	private TotoImgsService totoImgsService;
	
	public String findImgs() throws IOException{
		System.out.println("数据:"+page+"-"+rows);
		TotoImgs totoImgs = new TotoImgs();
		this.epage = totoImgsService.findImgs(totoImgs, page, rows);
		return "jsonstr";
	}
	
	 
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public EasyUIPage getEpage() {
		return epage;
	}

	public void setEpage(EasyUIPage epage) {
		this.epage = epage;
	}

	public TotoImgsService getTotoImgsService() {
		return totoImgsService;
	}

	public void setTotoImgsService(TotoImgsService totoImgsService) {
		this.totoImgsService = totoImgsService;
	}

}
