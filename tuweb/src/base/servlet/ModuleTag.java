package base.servlet;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import beans.Module;

import com.toto.www.service.web.ModuleService;

public class ModuleTag extends BodyTagSupport {

	private String id;
	private WebApplicationContext wcx;
	private PageContext pageContext;

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		ModuleService moduleService = (ModuleService)wcx.getBean("moduleService");
		Module module = new Module();
		module.setId(Long.valueOf(id));
		//module = moduleService.findModu0lesById(module);
		
		
		JspWriter out = pageContext.getOut();
		
		return super.doStartTag();
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		wcx = WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
