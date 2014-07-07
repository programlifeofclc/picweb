package com.toto.www.service;

import javax.annotation.Resource;

import com.toto.www.dao.BaseDao;

public class BaseService {
	@Resource(name="baseDao")
	public BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
