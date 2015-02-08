package com.firstleap.service.firstpregnantarticle;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.common.util.DeleteFileUtil;
import com.firstleap.dao.firstpregnantarticle.IFirstPregnantArticleDao;
import com.firstleap.entity.po.FirstPregnantArticle;

@Transactional
@Service("FirstPregnantArticleServiceImpl")
public class FirstPregnantArticleServiceImpl extends BaseServiceImpl implements
		IFirstPregnantArticleService {

	@Autowired
	private IFirstPregnantArticleDao firstPregnantArticleDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstPregnantArticle firstPregnantArticle;

	/*
	 * (non-Javadoc) 根据ID查询
	 * 
	 * @see
	 * net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.
	 * String)
	 */

	public FirstPregnantArticle getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstPregnantArticle = firstPregnantArticleDao.get(id);
		}
		return firstPregnantArticle;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo,
			FirstPregnantArticle firstPregnantArticle) {
		String hql = "from FirstPregnantArticle l where 1 = 1";
		return firstPregnantArticleDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQueryi(int pageNo,
			FirstPregnantArticle firstPregnantArticle) {
		String hql = "from FirstPregnantArticle l where l = 1 ";
		return firstPregnantArticleDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);
	}

	public List<FirstPregnantArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstPregnantArticle l where 1 = 1 ";
		return firstPregnantArticleDao.findByListHql(hql, hosid);

	}

	/************************** 封装get set ***************************/
	public IFirstPregnantArticleDao getFirstPregnantArticleDao() {
		return firstPregnantArticleDao;
	}

	public void setFirstPregnantArticleDao(
			IFirstPregnantArticleDao firstPregnantArticleDao) {
		this.firstPregnantArticleDao = firstPregnantArticleDao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstPregnantArticle getFirstPregnantArticle() {
		return firstPregnantArticle;
	}

	public void setFirstPregnantArticle(
			FirstPregnantArticle firstPregnantArticle) {
		this.firstPregnantArticle = firstPregnantArticle;
	}

}