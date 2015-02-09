package com.firstleap.action.firstpregnantarticle;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.firstleap.service.firstpregnantarticle.IFirstPregnantArticleService;
import com.firstleap.service.firstpregnanttype.IFirstPregnantTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
@Controller("FirstPregnantArticleAction")
@Scope("prototype")
public class FirstPregnantArticleAction extends BaseAction {

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
	private IFirstPregnantArticleService firstPregnantArticleService;

	private FirstPregnantArticle firstPregnantArticle;

	private List<FirstPregnantArticle> tyList;

	private File file;// 附件
	private String fileFileName;// 附件名
	private String fileContentType;// 附件类型

	/**
	 * @return
	 * @throws Exception
	 *             孕妇大类分页查询
	 */
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstPregnantArticleService.findAllOrQuery(
				this.getPage(), firstPregnantArticle);
		this.pagination = ltakLoginPagin;
		typeList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (typeList != null) {
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
			String result = firstPregnantArticleService.findArticleCategoryList(size, null, null);
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
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

	public IFirstPregnantArticleService getFirstPregnantArticleService() {
		return firstPregnantArticleService;
	}

	public void setFirstPregnantArticleService(
			IFirstPregnantArticleService firstPregnantArticleService) {
		this.firstPregnantArticleService = firstPregnantArticleService;
	}

	public FirstPregnantArticle getFirstPregnantArticle() {
		return firstPregnantArticle;
	}

	public void setFirstPregnantArticle(
			FirstPregnantArticle firstPregnantArticle) {
		this.firstPregnantArticle = firstPregnantArticle;
	}

	public List<FirstPregnantArticle> getTyList() {
		return tyList;
	}

	public void setTyList(List<FirstPregnantArticle> tyList) {
		this.tyList = tyList;
	}
}