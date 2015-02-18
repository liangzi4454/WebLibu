package com.firstleap.action.firstJcwenda;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.service.firstJcwenda.IFirstJcwendaService;

@SuppressWarnings("all")
@Controller("FirstJcwendaAction")
@Scope("prototype")
public class FirstJcwendaAction extends BaseAction {
	@Resource
	private IFirstJcwendaService firstJcwendaService;
	
	/**
	 * @author LHY 2015-2-16 上午10:57:07
	 * @return
	 * @throws Exception
	 */
	@Action("list")
	public String list() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=UTF-8");
			String size = request.getParameter("size");
			size = StringUtils.isEmpty(size)?"8":size;
			String result = firstJcwendaService.list(Integer.valueOf(size));
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String cc() throws Exception {
		System.out.println("adfasdf");
		return null;
	}
	public IFirstJcwendaService getFirstJcwendaService() {
		return firstJcwendaService;
	}
	public void setFirstJcwendaService(IFirstJcwendaService firstJcwendaService) {
		this.firstJcwendaService = firstJcwendaService;
	}
}