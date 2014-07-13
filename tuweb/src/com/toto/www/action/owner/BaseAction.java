package com.toto.www.action.owner;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import utils.EasyUIPage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String test = "test";
	public int page;
	public int rows;
	public String resultString;
	public EasyUIPage epage;
	public HttpSession session;
	public HttpServletRequest req;
	public HttpServletResponse res;
	
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
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	
	public String object2JSONString(Object object){
		JSONObject jobj = JSONObject.fromObject(object);
		return jobj.toString();
	}
	
	public String array2JSONString(List<?> object){
		JSONArray jobj = JSONArray.fromObject(object);
		return jobj.toString();
	}
	
	public void print16String(String s) throws IOException{
		HttpServletResponse res = 
		(HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		res.getWriter().println(s);
	}
	
	public void print8String(String s) throws IOException{
		HttpServletResponse res = 
		(HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		res.getOutputStream().println(s);
	}
	
	public HttpServletResponse getRes(){
		if(res != null)
			return res;
		res = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		return res;
	}
	
	public HttpServletRequest getReq(){
		if(req != null)
			return req;
		req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		return req;
	}
	
	public HttpSession getSes(){
		if(session!=null)
			return session;
		session = (HttpSession)ActionContext.getContext().get(ServletActionContext.SESSION);
		return session;
	}

	public Map<String,Object> getSession(){
		return (Map<String,Object>)ActionContext.getContext().getSession();
	}
}
