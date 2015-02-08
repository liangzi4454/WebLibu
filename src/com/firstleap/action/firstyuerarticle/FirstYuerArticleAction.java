package com.firstleap.action.firstyuerarticle;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.entity.po.FirstYuerArticle;
import com.firstleap.entity.po.FirstYuerType;
import com.firstleap.service.firstyuerarticle.IFirstYuerArticleService;
import com.firstleap.service.firstyuertype.IFirstYuerTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstYuerArticleAction")
@Scope("prototype")
public class FirstYuerArticleAction extends BaseAction {

	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstYuerTypeService firstYuerTypeService;

	private FirstYuerType firstYuerType;

	private List<FirstYuerType> typeList;

	@Autowired
	private IFirstYuerArticleService firstYuerArticleService;

	private FirstYuerArticle firstYuerArticle;

	private List<FirstYuerArticle> yuerList;

	private File file;// 附件
	private String fileFileName;// 附件名
	private String fileContentType;// 附件类型

	/**
	 * @return
	 * @throws Exception
	 *             网站大类分页查询
	 */
	@SuppressWarnings("unchecked")
	@Action("list")
	public String list() throws Exception {
		ltakLoginPagin = firstYuerArticleService.findAllOrQuery(this.getPage(),
				firstYuerArticle);
		this.pagination = ltakLoginPagin;
		yuerList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (yuerList != null) {
			return "list";
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

	public IFirstYuerTypeService getFirstYuerTypeService() {
		return firstYuerTypeService;
	}

	public void setFirstYuerTypeService(
			IFirstYuerTypeService firstYuerTypeService) {
		this.firstYuerTypeService = firstYuerTypeService;
	}

	public FirstYuerType getFirstYuerType() {
		return firstYuerType;
	}

	public void setFirstYuerType(FirstYuerType firstYuerType) {
		this.firstYuerType = firstYuerType;
	}

	public List<FirstYuerType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FirstYuerType> typeList) {
		this.typeList = typeList;
	}

	public IFirstYuerArticleService getFirstYuerArticleService() {
		return firstYuerArticleService;
	}

	public void setFirstYuerArticleService(
			IFirstYuerArticleService firstYuerArticleService) {
		this.firstYuerArticleService = firstYuerArticleService;
	}

	public FirstYuerArticle getFirstYuerArticle() {
		return firstYuerArticle;
	}

	public void setFirstYuerArticle(FirstYuerArticle firstYuerArticle) {
		this.firstYuerArticle = firstYuerArticle;
	}

	public List<FirstYuerArticle> getYuerList() {
		return yuerList;
	}

	public void setYuerList(List<FirstYuerArticle> yuerList) {
		this.yuerList = yuerList;
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
}