package com.firstleap.action.firstchildinfoarticle;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.struts.action.BaseAction;
import com.firstleap.common.util.Constant;
import com.firstleap.entity.po.FirstChildinfoArticle;
import com.firstleap.entity.po.FirstChildinfoType;
import com.firstleap.entity.po.FirstLogin;
import com.firstleap.service.firstchildinfoarticle.IFirstChildinfoArticleService;
import com.firstleap.service.firstchildinfotype.IFirstChildinfoTypeService;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller("FirstChildinfoArticleAction")
@Scope("prototype")
public class FirstChildinfoArticleAction extends BaseAction {

	private Pagination ltakLoginPagin;
	private FirstLogin firstLogin;
	private Map req;
	private String areaid;
	private String msgname;
	@Autowired
	private IFirstChildinfoTypeService childinfoTypeService;

	private FirstChildinfoType firstChildinfoType;

	private List<FirstChildinfoType> typeList;

	@Autowired
	private IFirstChildinfoArticleService firstChildinfoArticleService;

	private FirstChildinfoArticle firstChildinfoArticle;

	private List<FirstChildinfoArticle> childList;

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
		ltakLoginPagin = firstChildinfoArticleService.findAllOrQuery(
				this.getPage(), firstChildinfoArticle);
		this.pagination = ltakLoginPagin;
		childList = ltakLoginPagin.getList();
		ActionContext.getContext().getSession().put("page", this.getPage());
		if (childList != null) {
			return "list";
		}
		return INPUT;

	}

	/**
	 * 跳到增加
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action("create")
	public String create() throws Exception {
		FirstLogin ltakLogin = (FirstLogin) ActionContext.getContext()
				.getSession().get(Constant.USER_SESSION);// ��ȡsession��¼ֵ
		typeList = childinfoTypeService.list("2");

		return "create";
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

	public IFirstChildinfoTypeService getChildinfoTypeService() {
		return childinfoTypeService;
	}

	public void setChildinfoTypeService(
			IFirstChildinfoTypeService childinfoTypeService) {
		this.childinfoTypeService = childinfoTypeService;
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

	public IFirstChildinfoArticleService getFirstChildinfoArticleService() {
		return firstChildinfoArticleService;
	}

	public void setFirstChildinfoArticleService(
			IFirstChildinfoArticleService firstChildinfoArticleService) {
		this.firstChildinfoArticleService = firstChildinfoArticleService;
	}

	public FirstChildinfoArticle getFirstChildinfoArticle() {
		return firstChildinfoArticle;
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
