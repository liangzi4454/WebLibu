package com.firstleap.action.firstpregnanttype;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstPregnantType;
import com.firstleap.entity.po.FirstType;
import com.firstleap.service.firstpregnanttype.IFirstPregnantTypeService;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
@Controller("FirstPregnantTypeAction")
@Scope("prototype")
public class FirstPregnantTypeAction extends BaseAction {

	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstPregnantTypeService firstPregnantTypeService;

	private FirstPregnantType firstPregnantType;

	private List<FirstPregnantType> typeList;

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
		ltakLoginPagin = firstPregnantTypeService.findAllOrQuery(this.getPage(), firstPregnantType);
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
	 * 网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("listi")
	public String listi() throws Exception {
		ltakLoginPagin = firstPregnantTypeService.findAllOrQueryi(this.getPage(), firstPregnantType);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (typeList != null) {
			return "listi";
		}
		return INPUT;
	}
	
	/**
	 * 跳转到孕妇健康页面
	 * @return
	 * @throws Exception
	 */
	@Action("pregnentIndex")
	public String pregnentIndex() throws Exception {
		return "pregnentIndex";
	}
	
	/**
	 * 查询孕妇相关的分类
	 * @author LHY 2015-2-8 下午4:51:01
	 * @return
	 * @throws Exception
	 */
	@Action("findCategory")
	public String findCategory() throws Exception {
		try {
			String result = firstPregnantTypeService.findCategory();
			HttpServletResponse response =  ServletActionContext.getResponse();
			response.setContentType("text/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
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

	public IFirstPregnantTypeService getFirstPregnantTypeService() {
		return firstPregnantTypeService;
	}

	public void setFirstPregnantTypeService(
			IFirstPregnantTypeService firstPregnantTypeService) {
		this.firstPregnantTypeService = firstPregnantTypeService;
	}

	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}

	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
	}

	public List<FirstPregnantType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstPregnantType> typeList) {
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