package com.firstleap.action.firsttype;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstType;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
@Controller("FirstTypeAction")
@Scope("prototype")
public class FirstTypeAction extends BaseAction {

	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	@Resource
	private IFirstTypeService firstTypeService;

	private FirstType firstType;

	private List<FirstType> typeList;

	/**
	 * @return
	 * @throws Exception
	 *             网站大类分页查询
	 */
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstTypeService.findAllOrQuery(this.getPage(),
				firstType);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (typeList != null) {
			return "list";
		}
		return INPUT;

	}

	/**
	 * @return
	 * @throws Exception
	 *             网站二类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("listi")
	public String listi() throws Exception {
		ltakLoginPagin = firstTypeService.findAllOrQueryi(this.getPage(),
				firstType);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (typeList != null) {
			return "listi";
		}
		return INPUT;

	}
	public String findIndexMenu() throws Exception {
		try {
			String indexMenu = firstTypeService.findIndexMenu();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(indexMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Pagination getLtakLoginPagin() {
		return ltakLoginPagin;
	}

	public void setLtakLoginPagin(Pagination ltakLoginPagin) {
		this.ltakLoginPagin = ltakLoginPagin;
	}

	public FirstLogin getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(FirstLogin firstLogin) {
		this.firstLogin = firstLogin;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}

	public List<FirstType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstType> typeList) {
		this.typeList = typeList;
	}
}