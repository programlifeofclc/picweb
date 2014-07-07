package com.toto.www.service.owner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import beans.User;

import com.toto.www.service.BaseService;

@Service("loginService")
public class LoginService extends BaseService{
	
	public User findUser(User user){
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(user.getLoginName());
		list.add(user.getLoginPws());
		return (User)baseDao.findHqlObject("from User u where u.loginName = ? and u.loginPws = ? ",list);
	}
	
	public List<?> findMenuByRole(User user){
		ArrayList<Object> list = new ArrayList<Object>();
		return null;//(List<?>)baseDao.findHqlObject("from User u where u.loginName = ? and u.loginPws = ? ",list);
	}
	
	
}
