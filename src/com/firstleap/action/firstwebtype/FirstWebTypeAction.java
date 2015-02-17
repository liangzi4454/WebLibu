package com.firstleap.action.firstwebtype;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstType;
import com.firstleap.entity.po.FirstWebType;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.firstleap.service.firstwebtype.IFirstWebTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstWebTypeAction")
@Scope("prototype")
public class FirstWebTypeAction extends BaseAction {

	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstWebTypeService firstWebTypeService;

	private FirstWebType firstWebType;

	private List<FirstWebType> typeList;

	@Autowired
	private IFirstTypeService firstTypeService;

	private FirstType firstType;

	private List<FirstType> tyList;

	/**
	 * @return
	 * @throws Exception
	 *             网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstWebTypeService.findAllOrQuery(this.getPage(),
				firstWebType);
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
	 *             网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("listi")
	public String listi() throws Exception {
		ltakLoginPagin = firstWebTypeService.findAllOrQueryi(this.getPage(),
				firstWebType);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (typeList != null) {
			return "listi";
		}
		return INPUT;

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

	public Map getReq() {
		return req;
	}

	public void setReq(Map req) {
		this.req = req;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getMsgname() {
		return msgname;
	}

	public void setMsgname(String msgname) {
		this.msgname = msgname;
	}

	public IFirstWebTypeService getFirstWebTypeService() {
		return firstWebTypeService;
	}

	public void setFirstWebTypeService(IFirstWebTypeService firstWebTypeService) {
		this.firstWebTypeService = firstWebTypeService;
	}

	public FirstWebType getFirstWebType() {
		return firstWebType;
	}

	public void setFirstWebType(FirstWebType firstWebType) {
		this.firstWebType = firstWebType;
	}

	public List<FirstWebType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstWebType> typeList) {
		this.typeList = typeList;
	}

	public IFirstTypeService getFirstTypeService() {
		return firstTypeService;
	}

	public void setFirstTypeService(IFirstTypeService firstTypeService) {
		this.firstTypeService = firstTypeService;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}

	public List<FirstType> getTyList() {
		return tyList;
	}

	public void setTyList(List<FirstType> tyList) {
		this.tyList = tyList;
	}
}