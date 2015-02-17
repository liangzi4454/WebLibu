package com.firstleap.action.firstpregnantarticle;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstPregnantArticle;
import com.firstleap.entity.po.FirstPregnantType;
import com.firstleap.entity.po.FirstType;
import com.firstleap.service.firstpregnantarticle.IFirstPregnantArticleService;
import com.firstleap.service.firstpregnanttype.IFirstPregnantTypeService;
import com.firstleap.service.firsttype.IFirstTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
@Controller("FirstPregnantArticleAction")
@Scope("prototype")
public class FirstPregnantArticleAction extends BaseAction {
	private String id;
	private String pid;
	private Pagination ltakLoginPagin;
	private FirstPregnantType firstPregnantType;
	private List<FirstPregnantArticle> articleList;
	private FirstPregnantArticle firstPregnantArticle;
	
	@Resource
	private IFirstPregnantTypeService firstPregnantTypeService;
	@Resource
	private IFirstPregnantArticleService firstPregnantArticleService;
	@Resource
	private IFirstTypeService firstTypeService;
	
	/**
	 * @return
	 * @throws Exception
	 *             孕妇大类分页查询
	 */
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstPregnantArticleService.findAllOrQuery(this.getPage(), firstPregnantArticle);
		this.pagination = ltakLoginPagin;
		articleList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (articleList != null) {
			return "list";
		}
		return INPUT;

	}
	/**
	 * 根据数量查询孕妇健康的列表
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
			String result = firstPregnantArticleService.list(Integer.valueOf(size));
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
			String result = firstPregnantArticleService.findArticleCategoryList(size, null, _ids);
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
	@Action("findPregnantArticleDetail")
	public String findPregnantArticleDetail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", id);
		request.setAttribute("pid", pid);
		firstPregnantArticle = firstPregnantArticleService.getByid(id);
		return "pregnantArticleDetail";
	}
	@Action("findPregnantArticleList")
	public String findPregnantArticleList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", id);
		request.setAttribute("pid", pid);
		firstPregnantArticle = new FirstPregnantArticle();
		firstPregnantArticle.setPregnantId(pid);
		ltakLoginPagin = firstPregnantArticleService.findAllOrQuery(this.getPage(), firstPregnantArticle);
		this.pagination = ltakLoginPagin;
		articleList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (articleList != null) {
			return "pregnantArticleList";
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
			firstPregnantType = firstPregnantTypeService.getByid(pId);
			String thirdName = firstPregnantType.getName();
			pId = firstPregnantType.getParentId();
			firstPregnantType = firstPregnantTypeService.getByid(pId);
			String secondName = firstPregnantType.getName();
			pId = firstPregnantType.getTypeId();
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
			String result = firstPregnantArticleService.findHotArticle();
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
	@Action("findCategoryList")
	public String findCategoryList() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String id = request.getParameter("id");
			String size = request.getParameter("size");
			String result = firstPregnantArticleService.findCategoryList(id, StringUtils.isEmpty(size)?5:Integer.valueOf(size));
			response.setContentType("text/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

	public Pagination getLtakLoginPagin() {
		return ltakLoginPagin;
	}

	public void setLtakLoginPagin(Pagination ltakLoginPagin) {
		this.ltakLoginPagin = ltakLoginPagin;
	}
	
	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}

	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
	}
	
	public List<FirstPregnantArticle> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<FirstPregnantArticle> articleList) {
		this.articleList = articleList;
	}

	public FirstPregnantArticle getFirstPregnantArticle() {
		return firstPregnantArticle;
	}

	public void setFirstPregnantArticle(
			FirstPregnantArticle firstPregnantArticle) {
		this.firstPregnantArticle = firstPregnantArticle;
	}
}