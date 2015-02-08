package com.firstleap.service.firstchildinfoarticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.dao.firstchildinfoarticle.IFirstChildinfoArticleDao;
import com.firstleap.entity.po.FirstChildinfoArticle;

@Transactional
@Service("FirstChildinfoArticleServiceImpl")
public class FirstChildinfoArticleServiceImpl extends BaseServiceImpl implements
		IFirstChildinfoArticleService {

	@Autowired
	private IFirstChildinfoArticleDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstChildinfoArticle childinfoArticle;

	/**
	 * 根据ID查询
	 * 
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */

	public FirstChildinfoArticle getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			childinfoArticle = dao.get(id);
		}
		return childinfoArticle;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo,
			FirstChildinfoArticle firstChildinfoArticle) {
		String hql = "from FirstChildinfoArticle l where 1 = 1 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT,
				null);
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQueryi(int pageNo,
			FirstChildinfoArticle firstChildinfoArticle) {
		String hql = "from FirstChildinfoArticle l where l = 1 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT,
				null);
	}

	public List<FirstChildinfoArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstChildinfoArticle l where 1 = 1 ";
		return dao.findByListHql(hql, hosid);
	}

	/************************** 封装get set ***************************/
	public IFirstChildinfoArticleDao getDao() {
		return dao;
	}

	public void setDao(IFirstChildinfoArticleDao dao) {
		this.dao = dao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstChildinfoArticle getChildinfoArticle() {
		return childinfoArticle;
	}

	public void setChildinfoArticle(FirstChildinfoArticle childinfoArticle) {
		this.childinfoArticle = childinfoArticle;
	}
}