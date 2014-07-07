package com.toto.www.action.owner;

import java.util.Map;

import javax.annotation.Resource;


import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import utils.BeanScope;
import utils.Utils;
import beans.User;

import com.toto.www.service.owner.LoginService;

@Controller("loginAction")
public class LoginAction implements SessionAware{
	
	private Map<String, Object> session;
	private BeanScope beanScope;
	@Resource(name="loginService")
	private LoginService loginService;
	private User user;
	private String menuString;
	
	public String login(){
		if(user == null || !Utils.checkNN(user.getLoginName()) || !Utils.checkNN(user.getLoginPws()))
			return "login";

		User u = loginService.findUser(user);
		if(u == null)
			return "login";
		
		session.put("LoginUser",u);
		//JSONArray json = JSONArray.fromObject(loginService.findMenuByRole(u));
		//menuString = json.toString();
		return "success";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BeanScope getBeanScope() {
		return beanScope;
	}
	public void setBeanScope(BeanScope beanScope) {
		this.beanScope = beanScope;
	}
	public String getMenuString() {
		return menuString;
	}
	public void setMenuString(String menuString) {
		this.menuString = menuString;
	}

	/**
	 * 取得session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
