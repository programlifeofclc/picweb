package com.toto.www.action.owner;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import beans.ImgTheme;
import beans.TotoImgs;

import com.toto.www.service.owner.ThemeService;
import com.toto.www.service.owner.TotoImgsService;

@Scope("prototype")
@Controller("managerAction")
public class ManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	private ImgTheme imgTheme;
	private TotoImgs totoImgs;
	
	@Resource(name="totoImgsService")
	private TotoImgsService totoImgsService;
	
	@Resource(name="themeService")
	private ThemeService themeService;
	
	/**
	 * 查询图片
	 * @return
	 * @throws IOException
	 */
	public String findImgs() throws IOException{
		System.out.println("数据:"+ test);
		TotoImgs totoImgs = new TotoImgs();
		this.epage = totoImgsService.findImgs(totoImgs, page, rows);
		return "jsonstr";
	}
	
	/**
	 * 查询主题
	 * @return
	 */
	public String findThemes(){
		test = "该了";
		System.out.println("数据:"+ test);
		ImgTheme theme = new ImgTheme();
		this.epage = themeService.findThemes(theme, page, rows);
		return "jsonstr";
	}
	
	/**
	 * 查询全部主题
	 * @return
	 */
	public String findThemesComboBox()throws IOException{
		System.out.println("数据:"+ test);
		ImgTheme theme = new ImgTheme();
		List<ImgTheme> list = themeService.findThemeList(theme, -1, -1);
		print16String(array2JSONString(list));
		return null;
	}
	
	
	/**
	 * 添加主题
	 * @return
	 * @throws IOException 
	 */
	public String addTheme() throws IOException{
		getReq().setCharacterEncoding("utf-8");
		getRes().setCharacterEncoding("utf-8");
		getRes().setContentType("text/html;charset=utf-8");
		
		if(imgTheme != null){
			themeService.saveImgTheme(imgTheme);
		}
		if(imgTheme != null && imgTheme.getId() != null){
			print16String( object2JSONString(imgTheme));
			return null;
		}else{
			print16String("{}");
			return null;
		}
	}
	
	/**
	 * 更新主题
	 * @return
	 * @throws IOException 
	 */
	public String updateImg() throws IOException{
		getReq().setCharacterEncoding("utf-8");
		getRes().setCharacterEncoding("utf-8");
		getRes().setContentType("text/html;charset=utf-8");
		
		if(totoImgs != null && totoImgs.getId()!=null){
			TotoImgs img = themeService.updateTotoImg(totoImgs);
			if(img != null){
				print16String("success");
			}else{
				print16String("error");
			}
		}else{
			print16String("error");
		}
		return null;
	}
	
	
	public TotoImgsService getTotoImgsService() {
		return totoImgsService;
	}

	public void setTotoImgsService(TotoImgsService totoImgsService) {
		this.totoImgsService = totoImgsService;
	}

	public ThemeService getThemeService() {
		return themeService;
	}

	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	public ImgTheme getImgTheme() {
		return imgTheme;
	}

	public void setImgTheme(ImgTheme imgTheme) {
		this.imgTheme = imgTheme;
	}

	public TotoImgs getTotoImgs() {
		return totoImgs;
	}

	public void setTotoImgs(TotoImgs totoImgs) {
		this.totoImgs = totoImgs;
	}
}
