package com.firstleap.service.firstwebarticle;

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
import com.firstleap.dao.firstwebarticle.IFirstWebArticleDao;
import com.firstleap.entity.po.FirstWebArticle;

@Transactional
@Service("FirstWebArticleServiceImpl")
public class FirstWebArticleServiceImpl extends BaseServiceImpl implements
		IFirstWebArticleService {

	@Autowired
	private IFirstWebArticleDao firstWebTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstWebArticle firstWebType;

	/*
	 * (non-Javadoc) 根据ID查询
	 * 
	 * @see
	 * net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.
	 * String)
	 */

	public FirstWebArticle getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstWebType = firstWebTypeDao.get(id);
		}
		return firstWebType;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo, FirstWebArticle firstWebArticle) {
		String hql = "from FirstWebArticle l where 1 = 1 ";
		return firstWebTypeDao.findByHql(hql, pageNo,
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
			FirstWebArticle firstWebArticle) {
		String hql = "from FirstWebArticle l where l = 1 ";
		return firstWebTypeDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);

	}

	public List<FirstWebArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstWebArticle l where 1 = 1 ";
		return firstWebTypeDao.findByListHql(hql, hosid);

	}

	/************************** 封装get set ***************************/
	public IFirstWebArticleDao getFirstWebTypeDao() {
		return firstWebTypeDao;
	}

	public void setFirstWebTypeDao(IFirstWebArticleDao firstWebTypeDao) {
		this.firstWebTypeDao = firstWebTypeDao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstWebArticle getFirstWebType() {
		return firstWebType;
	}

	public void setFirstWebType(FirstWebArticle firstWebType) {
		this.firstWebType = firstWebType;
	}
}