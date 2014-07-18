package base.servlet;


import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import beans.Module;
import beans.TotoImgs;

import com.toto.www.service.web.ModuleService;

public class ModuleTag extends BodyTagSupport {

	private String id;
	private String alt;
	private String style;
	private String className;
	
	private WebApplicationContext wcx;
	private PageContext pageContext;

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		wcx = WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());
	}

	
	@Override
	public int doStartTag() throws JspException{
		try {
			JspWriter out = pageContext.getOut();
			ModuleService moduleService = (ModuleService) wcx
					.getBean("moduleService");
			Module module = new Module();
			module.setId(Long.valueOf(id));
			if (id == "1") {
				List<TotoImgs> list = moduleService.findModuleAndImg(module);
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						TotoImgs timg = list.get(i);
						String imgn = timg.getImgName() == null ? "" : timg.getImgName();
						String imgType = imgn.substring(imgn.lastIndexOf(".") + 1);
						out.print("<img alt='" + (alt==null?"":alt) + "' src='/" + timg.getImgUrl() + "/img." + imgType + "' style=\"" + style + "\" class=\"" + className + "\" />");
					}
				}
			}
		} catch (Exception e) {
			throw new JspException("发生错误");
		}
		
		return EVAL_BODY_INCLUDE;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}


	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
