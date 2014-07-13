package com.toto.www.service.owner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import utils.EasyUIPage;
import utils.Page;
import beans.ImgTheme;

import com.toto.www.service.BaseService;

@Service("themeService")
public class ThemeService extends BaseService{

	public EasyUIPage findThemes(ImgTheme theme,int offset,int limit){
		Integer c = this.findThemeCount(theme);
		Page page = new Page(offset,limit,c);
		List<?> imglist = this.findThemeList(theme,page.getStartRow(),page.getPageSize());
		page.setRows(imglist);
		return page.getUIPage();
	}
	
	@SuppressWarnings("unchecked")
	public List<ImgTheme> findThemeList(ImgTheme theme,int offset,int limit){
		String hql = " select t from  ImgTheme t where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(theme != null){
			if(theme.getThemeName() != null){
				list.add( "%" + theme.getThemeName() + "%");
				hql += " and t.themeName like ? ";
			}
		}
		hql += " order by id desc ";
		return (List<ImgTheme>)baseDao.findHqlList(hql, list, offset, limit);
	}
	
	public Integer findThemeCount(ImgTheme theme){
		String hql = " select t from  ImgTheme t where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(theme != null){
			if(theme.getThemeName() != null){
				list.add( "%" + theme.getThemeName() + "%");
				hql += " and t.themeName like ? ";
			}
		}
		return  baseDao.findHqlListCount(hql, list);
	}
	
	
	public ImgTheme saveImgTheme(ImgTheme theme){
		int c = this.findThemeCount(theme);
		if(c > 0 )
			return theme;
		else
			return (ImgTheme)baseDao.saveOrUpdate(theme);
	}
	
}
