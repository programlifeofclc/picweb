package com.toto.www.service.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import beans.Module;
import beans.TotoImgs;

import com.toto.www.service.BaseService;

@Service("moduleService")
public class ModuleService extends BaseService {

	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
	public List<TotoImgs> findModuleAndImg(Module module){
		if(module == null || module.getId() == null) return null;
		String hql = "select g from Module t,PageModule p ,TotoImgs g where t.id=? and t.id = p.moduleId and p.imgId = g.id and p.flag = 1 ";
		List<Object> values = new ArrayList<Object>();
		values.add(module.getId());
		return (List<TotoImgs>)baseDao.findHqlList(hql, values, -1, -1);
	}
}
