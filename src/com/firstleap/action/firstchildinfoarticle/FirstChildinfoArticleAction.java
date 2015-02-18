package com.firstleap.action.firstchildinfoarticle;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.entity.po.FirstChildinfoArticle;
import com.firstleap.entity.po.FirstChildinfoType;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstType;
import com.firstleap.service.firstchildinfoarticle.IFirstChildinfoArticleService;
import com.firstleap.service.firstchildinfotype.IFirstChildinfoTypeService;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstChildinfoArticleAction")
@Scope("prototype")
public class FirstChildinfoArticleAction extends BaseAction {
	private String id;
	private String pid;
	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private FirstChildinfoType firstChildinfoType;
	private List<FirstChildinfoType> typeList;
	private FirstChildinfoArticle firstChildinfoArticle;
	private List<FirstChildinfoArticle> childList;

	@Resource
	private IFirstChildinfoTypeService childinfoTypeService;
	@Resource
	private IFirstChildinfoArticleService firstChildinfoArticleService;
	@Resource
	private IFirstTypeService firstTypeService;
	/**
	 * @return
	 * @throws Exception
	 *             网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstChildinfoArticleService.findAllOrQuery(this.getPage(), firstChildinfoArticle);
		this.pagination = ltakLoginPagin;
		childList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (childList != null) {
			return "list";
		}
		return INPUT;
	}
	
	/**
	 * 查询每个二级分类下给定数量在文章列表
	 * @author LHY 2015-2-10 上午1:19:05
	 * @return
	 * @throws Exception
	 */
	@Action("findArticleCategoryList")
	public String findArticleCategoryList() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			int size = Integer.valueOf(request.getParameter("size"));
			String ids = request.getParameter("ids");
			String[] _ids = {};
			if(StringUtils.isNotEmpty(ids) && ids.length()>0) {
				_ids = ids.split("&");
			}
			String result = firstChildinfoArticleService.findArticleCategoryList(size, null, _ids);
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
	/**
	 * 根据数量查询婴幼儿健康的列表
	 * @author LHY 2015-2-16 上午10:57:07
	 * @return
	 * @throws Exception
	 */
	public String findList() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=UTF-8");
			String size = request.getParameter("size");
			size = StringUtils.isEmpty(size)?"3":size;
			String result = firstChildinfoArticleService.list(Integer.valueOf(size));
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Action("findChildInfoArticleDetail")
	public String findChildInfoArticleDetail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", id);
		request.setAttribute("pid", pid);
		firstChildinfoArticle = firstChildinfoArticleService.getByid(id);
		return "nurseryArticleDetail";
	}
	@Action("findChildInfoArticleList")
	public String findChildInfoArticleList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", id);
		request.setAttribute("pid", pid);
		firstChildinfoArticle = new FirstChildinfoArticle();
		firstChildinfoArticle.setParentId(pid);
		ltakLoginPagin = firstChildinfoArticleService.findAllOrQuery(this.getPage(), firstChildinfoArticle);
		this.pagination = ltakLoginPagin;
		childList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (childList != null) {
			return "nurseryArticleList";
		}
		return INPUT;
	}
	@Action("findNavigation")
	public String findNavigation() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String id = request.getParameter("id");
			String pId = request.getParameter("pid");
			ArrayList<String> list = new ArrayList<String>();
			firstChildinfoType = childinfoTypeService.getByid(pId);
			String thirdName = firstChildinfoType.getName();
			pId = firstChildinfoType.getParentId();
			firstChildinfoType = childinfoTypeService.getByid(pId);
			String secondName = firstChildinfoType.getName();
			pId = firstChildinfoType.getTypeId();
			FirstType firstType = firstTypeService.getByid(pId);
			String firstName = firstType.getName();
			list.add(firstName);
			list.add(secondName);
			list.add(thirdName);
			JSONArray json = JSONArray.fromObject(list);
			response.setContentType("text/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Action("findHotArticle")
	public String findHotArticle() throws Exception {
		try {
			String result = firstChildinfoArticleService.findHotArticle();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String findArticle() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			List<FirstChildinfoArticle> list = firstChildinfoArticleService.list(id);
			String result = JSONArray.fromObject(list).toString();
			HttpServletResponse response = ServletActionContext.getResponse();
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

	public FirstChildinfoType getFirstChildinfoType() {
		return firstChildinfoType;
	}

	public void setFirstChildinfoType(FirstChildinfoType firstChildinfoType) {
		this.firstChildinfoType = firstChildinfoType;
	}

	public List<FirstChildinfoType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstChildinfoType> typeList) {
		this.typeList = typeList;
	}

	public void setFirstChildinfoArticle(
			FirstChildinfoArticle firstChildinfoArticle) {
		this.firstChildinfoArticle = firstChildinfoArticle;
	}

	public List<FirstChildinfoArticle> getChildList() {
		return childList;
	}

	public void setChildList(List<FirstChildinfoArticle> childList) {
		this.childList = childList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
}