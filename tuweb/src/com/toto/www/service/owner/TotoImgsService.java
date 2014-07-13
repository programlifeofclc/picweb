package com.toto.www.service.owner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import utils.EasyUIPage;
import utils.Page;
import beans.TotoImgs;

import com.toto.www.service.BaseService;

@Service("totoImgsService")
public class TotoImgsService extends BaseService{

	
	
	public EasyUIPage findImgs(TotoImgs toto,int offset,int limit){
		String hql = " select t from  TotoImgs t where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(toto != null){
			if(toto.getThemeIds() != null){
				list.add( "%" + toto.getThemeIds() + "%");
				hql += " and t.themeIds like ? ";
			}
		}
		hql += " order by createTime desc ";
		Integer c = baseDao.findHqlListCount(hql, list);
		Page page = new Page(offset,limit,c);
		List<?> imglist = baseDao.findHqlList(hql,list,page.getStartRow(),page.getPageSize());
		page.setRows(imglist);
		return page.getUIPage();
	}
	
	
}
