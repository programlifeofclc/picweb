package com.toto.www.service.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import beans.Module;

import com.toto.www.service.BaseService;

@Service("moduleService")
public class ModuleService extends BaseService {

	
	public List<Module> findModules(Module module,int offset,int limit){
		String hql = " select t from  Module t where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(module != null){
			if(module.getId() != null){
				list.add(module.getId());
				hql += " and t.id = ? ";
			}
		}
		hql += " order by id desc ";
		return (List<Module>)baseDao.findHqlList(hql, list, offset, limit);
	}
	
	public Module module(Module module){
		if(module == null || module.getId() == null) return null;
		return (Module)baseDao.get(Module.class, module.getId());
	}
	
	public Module findModuleAndImg(Module module){
		if(module == null || module.getId() == null) return null;
		String sql = "select t from Module t,PageModule p ,TotoImgs g where t.id=? and t. ";
		return (Module)baseDao.get(Module.class, module.getId());
	}
}
